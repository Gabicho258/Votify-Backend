import mongoose from "mongoose";

const listSchema = {
  process_id: { type: mongoose.Types.ObjectId, ref: "ElectionProcess" },
  title: String,
};

const List = mongoose.model("List", new mongoose.Schema(listSchema), "list");

export default List;
