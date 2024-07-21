import express from "express";
import { CandidateController } from "../controllers/index.js";

const {
  createCandidate,
  getAllCandidates,
  getCandidateById,
  getCandidatesByListId,
  updateCandidate,
  addVoteCandidate,
} = CandidateController;

const CANDIDATE_ROUTES = {
  CREATE: "/candidate/create",
  GET_ALL: "/candidate/",
  GET_BY_ID: "/candidate/:id",
  GET_BY_LIST_ID: "/candidate/list/:id",
  UPDATE: "/candidate/update/:id",
  ADD_VOTE: "/candidate/add_vote/:id",
};

const router = express.Router();

router.post(CANDIDATE_ROUTES.CREATE, createCandidate);
router.put(CANDIDATE_ROUTES.ADD_VOTE, addVoteCandidate);
router.get(CANDIDATE_ROUTES.GET_ALL, getAllCandidates);
router.get(CANDIDATE_ROUTES.GET_BY_ID, getCandidateById);
router.get(CANDIDATE_ROUTES.GET_BY_LIST_ID, getCandidatesByListId);
router.put(CANDIDATE_ROUTES.UPDATE, updateCandidate);

export default router;
