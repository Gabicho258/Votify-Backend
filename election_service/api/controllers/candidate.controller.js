import { Candidate } from "../models/index.js";

// Get controllers

export const getAllCandidates = async (req, res) => {
  try {
    const candidates = await Candidate.find();
    res.status(200).json(candidates);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

export const getCandidateById = async (req, res) => {
  const { id: candidate_id } = req.params;
  try {
    const candidate = await Candidate.findById(candidate_id);
    if (candidate) {
      res.status(200).json(candidate);
    } else {
      res.status(404).json({ message: "Candidate not found" });
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

export const getCandidatesByListId = async (req, res) => {
  const { id: list_id } = req.params;
  try {
    const candidates = await Candidate.find({ list_id });
    if (candidates) {
      res.status(200).json(candidates);
    } else {
      res.status(404).json({ message: "No candidates found for this list" });
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// Write controllers

export const createCandidate = async (req, res) => {
  const candidateToCreate = req.body;

  try {
    const newCandidate = new Candidate(candidateToCreate);
    await newCandidate.save();
    newCandidate && res.status(201).json(newCandidate);
  } catch (error) {
    res.status(400).json({ message: error.message });
  }
};

export const updateCandidate = async (req, res) => {
  const { id: candidate_id } = req.params;
  const candidateToUpdate = req.body;

  try {
    const candidateUpdated = await Candidate.findByIdAndUpdate(
      candidate_id,
      candidateToUpdate,
      {
        new: true,
      }
    );
    if (candidateUpdated) {
      res.status(200).json(candidateUpdated);
    } else {
      res.status(204).json({ error: "Candidate not found" });
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};
