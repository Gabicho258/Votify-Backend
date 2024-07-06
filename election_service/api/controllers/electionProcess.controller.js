import { ElectionProcess } from "../models/index.js";

// Get controllers

export const getAllElectionProcesses = async (req, res) => {
  try {
    const electionProcesses = await ElectionProcess.find();
    res.status(200).json(electionProcesses);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

export const getElectionProcessById = async (req, res) => {
  const { id: process_id } = req.params;
  try {
    const electionProcess = await ElectionProcess.findById(process_id);
    if (electionProcess) {
      res.status(200).json(electionProcess);
    } else {
      res.status(404).json({ message: "Election process not found" });
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

export const getElectionProcessesByUserId = async (req, res) => {
  const { id: user_id } = req.params;
  try {
    const electionProcesses = await ElectionProcess.find({ user_id });
    res.status(200).json(electionProcesses);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// Write controllers

export const createElectionProcess = async (req, res) => {
  const processToCreate = req.body;
  try {
    const newProcess = new ElectionProcess(processToCreate);
    await newProcess.save();
    newProcess && res.status(201).json(newProcess);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

export const updateElectionProcess = async (req, res) => {
  const { id: process_id } = req.params;
  const processToUpdate = req.body;

  try {
    const processUpdated = await ElectionProcess.findByIdAndUpdate(
      process_id,
      processToUpdate,
      {
        new: true,
      }
    );
    if (processUpdated) {
      res.status(200).json(processUpdated);
    } else {
      res.status(204).json({ error: "Process not found" });
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};
