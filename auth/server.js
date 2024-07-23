// require('dotenv').config();

import express from "express";
import { OAuth2Client } from "google-auth-library";
import "dotenv/config.js";
import cors from "cors";
import jwt from "jsonwebtoken";
import axios from "axios";

const app = express();

// app.use(cors());
app.use(express.json());

const oAuth2Client = new OAuth2Client(
  process.env.CLIENT_ID,
  process.env.CLIENT_SECRET,
  "postmessage"
);

app.post("/auth/google", async (req, res) => {
  const { tokens } = await oAuth2Client.getToken(req.body.code); // exchange code for tokens
  const userResponse = await axios.get(
    "https://www.googleapis.com/oauth2/v3/userinfo",
    { headers: { Authorization: `Bearer ${tokens.access_token}` } }
  );
  // console.log("tokens",tokens.access_token);
  // console.log("userinfo", userInfo);
  jwt.sign(userResponse.data, process.env.SECRET_KEY, (error, token) => {
    if (!error) {
      const userInfo = {
        tokens: { ...tokens, appJWT: token },
        user: userResponse.data,
      };
      res.status(200).json(userInfo);
    } else res.status(401).json({ message: "Error generating token" });
  });
});

app.post("/auth/google/refresh-token", async (req, res) => {
  const user = new UserRefreshClient(
    clientId,
    clientSecret,
    req.body.refreshToken
  );
  const { credentials } = await user.refreshAccessToken(); // optain new tokens
  res.json(credentials);
});

app.post("/auth/google/verify", async (req, res) => {
  const token = req.headers["authorization"]?.split(" ")[1];
  if (token) {
    jwt.verify(token, process.env.SECRET_KEY, (error, decoded) => {
      if (!error) {
        res.status(200).json({
          message: "Token verified succesfully",
        }); // pasamos a la siguiente función luego de autenticar al usuario
      } else res.status(401).send(); // Error "Unauthorized"
    });
  } else {
    // Solicitud invalida
    res.status(400).json({ error: "No token provided." });
  }
});

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => console.log(`Server listening on port ${PORT}`));
