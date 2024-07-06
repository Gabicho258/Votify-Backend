import express from "express";
import mongoose from "mongoose";
import cors from "cors";

import "dotenv/config.js";
import {
  CandidateRouter,
  ElectionProcessRouter,
  ListRouter,
} from "./api/routes/index.js";

// Database Mongo Atlas configuration

const dbURI = process.env.DB_URI;

await mongoose
  .connect(dbURI)
  .then(() => console.log("Database connected"))
  .catch((err) => console.error(err));

// Create server

const app = express();

// Middleware
app.use(cors());
app.use(express.json());

// Routes
app.use("/api", CandidateRouter);
app.use("/api", ElectionProcessRouter);
app.use("/api", ListRouter);

app.use("/", (req, res) => {
  res.send("Election service running...");
});

//Listening server

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => {
  console.log(`Server listening on port ${PORT}`);
});
