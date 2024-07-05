// require('dotenv').config();

import express from "express";
import { OAuth2Client } from "google-auth-library";
import "dotenv/config.js";
import cors from "cors";
import axios from "axios";

// const express = require('express');
// const { OAuth2Client, } = require('google-auth-library');
// const cors = require('cors');

const app = express();

app.use(cors());
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
  const userInfo = {
    tokens: tokens,user:  userResponse.data
  }
  res.json(userInfo);
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

app.listen(5000, () => console.log(`Server is running`));
