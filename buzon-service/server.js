import express from "express";
import mongoose from "mongoose";
import cors from "cors";
import { Eureka } from "eureka-js-client";
import { ChatRouter, MessageRouter } from "./api/routes/index.js";
import "dotenv/config.js";

// Mongo DB Atlas connection

const dbURI = process.env.DB_URI;

await mongoose
  .connect(dbURI)
  .then(() => console.log("Database connected"))
  .catch((error) => console.error(error));

// Server creation

const app = express();

// Middleware

app.use(cors());
app.use(express.json());

// Routes
app.use("/api/buzon-service", ChatRouter);
app.use("/api/buzon-service", MessageRouter);

app.use("/", (req, res) => {
  res.send("Buzon service running...");
});

// Eureka Client configuration
const eurekaClient = new Eureka({
  instance: {
    app: "buzon-service",
    hostName: "localhost",
    ipAddr: "127.0.0.1",
    statusPageUrl: `http://localhost:${process.env.PORT || 3002}`,
    port: {
      $: process.env.PORT || 3002,
      "@enabled": true,
    },
    vipAddress: "buzon-service",
    dataCenterInfo: {
      "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
      name: "MyOwn",
    },
  },
  eureka: {
    host: process.env.EUREKA_HOST || "localhost",
    port: process.env.EUREKA_PORT || 8761,
    servicePath: "/eureka/apps/",
  },
});

// Register with Eureka
eurekaClient.start((error) => {
  if (error) {
    console.log("Error registering with Eureka", error);
  } else {
    console.log("Registered with Eureka");
  }
});

// Server initializing

const PORT = process.env.PORT || 3002;

app.listen(PORT, () => {
  console.log(`Server is running on port: ${PORT}`);
});

// Handle application shutdown
process.on("SIGINT", () => {
  eurekaClient.stop();
  process.exit();
});
