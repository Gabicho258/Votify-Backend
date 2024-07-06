import express from "express";
import { ElectionProcessController } from "../controllers/index.js";

const {
  createElectionProcess,
  getAllElectionProcesses,
  getElectionProcessById,
  getElectionProcessesByUserId,
  updateElectionProcess,
} = ElectionProcessController;

const PROCESS_ROUTES = {
  CREATE: "/process/create",
  GET_ALL: "/process/",
  GET_BY_ID: "/process/:id",
  GET_BY_USER_ID: "/process/user/:id",
  UPDATE: "/process/update/:id",
};

const router = express.Router();

router.post(PROCESS_ROUTES.CREATE, createElectionProcess);
router.get(PROCESS_ROUTES.GET_ALL, getAllElectionProcesses);
router.get(PROCESS_ROUTES.GET_BY_ID, getElectionProcessById);
router.get(PROCESS_ROUTES.GET_BY_USER_ID, getElectionProcessesByUserId);
router.put(PROCESS_ROUTES.UPDATE, updateElectionProcess);

export default router;
