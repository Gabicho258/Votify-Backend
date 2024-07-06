import mongoose from "mongoose";

const electionProcessSchema = {
  user_id: String,
  is_owner: Boolean,
  title: String,
  admin_status: String,
  process_status: String,
  start_time: String,
  end_date: String,
};

const ElectionProcess = mongoose.model(
  "ElectionProcess",
  electionProcessSchema,
  "election_process"
);

export default ElectionProcess;
