import express from "express";
import mongoose from "mongoose";
import cors from "cors";
import updateElectionStatus from "./api/scheduler/updateProcessState.js";

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
app.use("/api/election-service", CandidateRouter);
app.use("/api/election-service", ElectionProcessRouter);
app.use("/api/election-service", ListRouter);

app.use("/", (req, res) => {
  res.send("Election service running...");
});

//Listening server

const PORT = process.env.PORT || 3001;

app.listen(PORT, () => {
  console.log(`Server listening on port ${PORT}`);
});

// Scheduler
updateElectionStatus();
