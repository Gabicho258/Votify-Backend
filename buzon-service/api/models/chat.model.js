import mongoose from "mongoose";

const chatSchema = {
  members: Array,
  title: String,
  state: String,
  process_name: String,
};

const Chat = mongoose.model(
  "Chat",
  new mongoose.Schema(chatSchema, { timestamps: true }),
  "chat"
);

export default Chat;
