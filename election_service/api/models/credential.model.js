import mongoose from "mongoose";

const credentialSchema = {
  user_id: { type: mongoose.Types.ObjectId, ref: "User" },
  process_id: { type: mongoose.Types.ObjectId, ref: "ElectionProcess" },
  password: String,
};
const Credential = mongoose.model(
  "Credential",
  new mongoose.Schema(credentialSchema),
  "credential"
);

export default Credential;
