import { List } from "../models/index.js";

// Get controllers

export const getAllLists = async (req, res) => {
  try {
    const lists = await List.find();
    res.status(200).json(lists);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

export const getListById = async (req, res) => {
  const { id: list_id } = req.params;
  try {
    const list = await List.findById(list_id);
    if (list) {
      res.status(200).json(list);
    } else {
      res.status(404).json({ message: "List not found" });
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

export const getListsByProcessId = async (req, res) => {
  const { id: process_id } = req.params;
  try {
    const lists = await List.find({ process_id });
    if (lists) {
      res.status(200).json(lists);
    } else {
      res.status(404).json({ message: "No lists found for this process" });
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// Write controllers

export const createList = async (req, res) => {
  const listToCreate = req.body;

  try {
    const newList = new List(listToCreate);
    await newList.save();
    newList && res.status(201).json(newList);
  } catch (error) {
    res.status(400).json({ message: error.message });
  }
};

export const updateList = async (req, res) => {
  const { id: list_id } = req.params;
  const listToUpdate = req.body;

  try {
    const listUpdated = await List.findByIdAndUpdate(list_id, listToUpdate, {
      new: true,
    });
    if (listUpdated) {
      res.status(200).json(listUpdated);
    } else {
      res.status(204).json({ error: "List not found" });
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};
