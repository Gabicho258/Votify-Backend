import mongoose from "mongoose";

const candidateSchema = {
  list_id: { type: mongoose.Types.ObjectId, ref: "List" },
  candidate_name: String,
  photo_url: String,
  organization_name: String,
  logo_url: String,
  valid_votes: { type: Number, default: 0 },
};

const Candidate = mongoose.model(
  "Candidate",
  new mongoose.Schema(candidateSchema),
  "candidate"
);

export default Candidate;
