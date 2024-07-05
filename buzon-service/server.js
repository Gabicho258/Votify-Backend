import express from "express";
import mongoose from "mongoose";
import cors from "cors";

import "dotenv/config.js"

// Mongo DB Atlas connection

const dbURI = process.env.DB_URI;

await mongoose.connect(dbURI).then(()=>console.log("Database connected")).catch((error)=>console.error(error))

// Server creation

const app = express();

// Middleware

app.use(cors());
app.use(express.json());

// Routes


// Server initializing

const PORT = process.env.PORT || 3002;

app.listen(PORT, ()=>{
    console.log(`Server is running on port: ${PORT}`)
})









