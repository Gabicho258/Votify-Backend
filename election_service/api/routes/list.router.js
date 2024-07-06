import express from "express";
import { ListController } from "../controllers/index.js";

const {
  createList,
  getAllLists,
  getListById,
  getListsByProcessId,
  updateList,
} = ListController;

const LIST_ROUTES = {
  CREATE: "/list/create",
  GET_ALL: "/list/",
  GET_BY_ID: "/list/:id",
  GET_BY_PROCESS_ID: "/list/process/:id",
  UPDATE: "/list/update/:id",
};

const router = express.Router();

router.post(LIST_ROUTES.CREATE, createList);
router.get(LIST_ROUTES.GET_ALL, getAllLists);
router.get(LIST_ROUTES.GET_BY_ID, getListById);
router.get(LIST_ROUTES.GET_BY_PROCESS_ID, getListsByProcessId);
router.put(LIST_ROUTES.UPDATE, updateList);

export default router;
