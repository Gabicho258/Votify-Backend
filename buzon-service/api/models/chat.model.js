import mongoose from "mongoose";

const chatSchema = {
  members: Array,
};

const Chat = mongoose.model(
  "Chat",
  new mongoose.Schema(chatSchema, { timestamps: true }, "chat")
);

export default Chat;