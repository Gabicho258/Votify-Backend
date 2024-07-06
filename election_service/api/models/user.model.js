import mongoose, { Mongoose } from "mongoose";

const userSchema = {
  role: String,
  user_name: String,
  user_surname: String,
  email: String,
  dni: String,
  is_active: Boolean,
};

const User = mongoose.model(
  "User",
  new mongoose.Schema(userSchema, { timestamps: true }),
  "user"
);

export default User;
