import { Chat } from "../models/index.js";

export const createChat = async (req, res) => {
  const { owner_id, friend_id, title, state, process_name } = req.body;
  try {
    const chat = await Chat.findOne({
      // encontrará aquel chat que contenga los id's
      // mandandos, sin que sea importante si tiene más
      // valores
      process_name,
    });
    // const chat = await Chat.findOne({
    //   // encontrará aquel chat que contenga los id's
    //   // mandandos, sin que sea importante si tiene más
    //   // valores
    //   members: { $all: [owner_id, friend_id] },
    // });
    // si existe un chat, lo retornamos
    if (chat) return res.status(200).json(chat);

    // Si no existe un chat, lo creamos y retornamos
    const newChat = new Chat({
      members: [owner_id, friend_id],
      title,
      state,
      process_name,
    });
    const chatSaved = await newChat.save();
    if (chatSaved) return res.status(201).json(chatSaved);
    else return res.status(404).send("Error creando chat");
  } catch (error) {
    res.status(500).json(error);
  }
};

export const getChatsByUserId = async (req, res) => {
  const { id } = req.params;
  try {
    // obtenemos los chats donde aparezca el id del usuario
    const chats = await Chat.find({ members: { $in: [id] } });
    res.status(200).json(chats);
  } catch (error) {
    res.status(500).json(error);
  }
};

export const getOneChat = async (req, res) => {
  const { owner_id, friend_id } = req.params;
  try {
    // obtenemos los chats donde aparezca el id del usuario y el
    // usuario con quien se tenga la conversación
    const chat = await Chat.find({ members: { $all: [owner_id, friend_id] } });
    res.status(200).json(chat);
  } catch (error) {
    res.status(500).json(error);
  }
};

export const updateChat = async (req, res) => {
  const { id: chat_id } = req.params;
  const chatToUpdate = req.body;
  try {
    const chatUpdated = await Chat.findByIdAndUpdate(chat_id, chatToUpdate, {
      new: true,
    });
    if (chatUpdated) {
      res.status(200).json(chatUpdated);
    } else {
      res.status(204).json({ error: "Chat not found" });
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};
