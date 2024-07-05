import express from "express";
import { ChatController } from "../controllers/index.js";

const { createChat, getChatsByUserId, getOneChat } = ChatController;

const router = express.Router();

const CHAT_ROUTES = {
  CREATE: "/chat/create",
  GET_CHATS_BY_USER_ID: "/chat/:id",
  GET_ONE: "/chat/:owner_id/:friend_id",
};

router.get(CHAT_ROUTES.GET_CHATS_BY_USER_ID, getChatsByUserId);
router.get(CHAT_ROUTES.GET_ONE, getOneChat);
router.post(CHAT_ROUTES.CREATE, createChat);

export default router;