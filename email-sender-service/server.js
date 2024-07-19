import { MailerSend, EmailParams, Sender, Recipient } from "mailersend";
import express from "express";

import { getHTMLTemplate } from "./templates/credential.js";
import "dotenv/config";

const mailerSend = new MailerSend({
  apiKey: process.env.API_KEY,
});

const sentFrom = new Sender(
  "votify.application@trial-pxkjn41w27plz781.mlsender.net",
  "Votify Application"
);

const app = express();

app.use(express.json());

// const data = {
//   process_name: "proceso temporal 1",
//   start_date: "19/07/2024",
//   start_time: "07:00",
//   end_date: "19/07/2024",
//   end_time: "17:00",
//   voters: [
//     {
//       email: "gabicho050@gmail.com",
//       name: "Gabicho",
//       dni: "12344321",
//       password: "pass321",
//     },
//     {
//       email: "votify.application@gmail.com",
//       name: "Votify",
//       dni: "09876543",
//       password: "321pass",
//     },
//   ],
// };
app.post("/api/email-service/credential", async (req, res) => {
  const { process_name, start_date, start_time, end_date, end_time, voters } =
    req.body;

  const bulkEmails = [];

  try {
    voters.forEach((voter) => {
      const { dni, email, name, password } = voter;
      const emailParams = new EmailParams()
        .setFrom(sentFrom)
        .setTo([new Recipient(email, name)])
        .setSubject("Entrega de credenciales")
        .setHtml(
          getHTMLTemplate(
            name,
            process_name,
            start_date,
            start_time,
            end_date,
            end_time,
            dni,
            password
          )
        );
      bulkEmails.push(emailParams);
    });

    await mailerSend.email.sendBulk(bulkEmails);
    res.status(200).json({ message: "Emails sent successfully" });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

const PORT = process.env.PORT || 3003;

app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
