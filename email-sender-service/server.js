import "dotenv/config";
import { MailerSend, EmailParams, Sender, Recipient } from "mailersend";

const mailerSend = new MailerSend({
  apiKey: process.env.API_KEY,
});

const sentFrom = new Sender(
  "votify.application@trial-pxkjn41w27plz781.mlsender.net",
  "Votify Application"
);

const recipients = [new Recipient("gabicho050@gmail.com", "Gabicho")];

const emailParams = new EmailParams()
  .setFrom(sentFrom)
  .setTo(recipients)
  .setReplyTo(sentFrom)
  .setSubject("This is a Subject")
  .setHtml("<strong>This is the HTML content</strong>");

await mailerSend.email.send(emailParams);
