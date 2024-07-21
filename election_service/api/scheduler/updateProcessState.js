import cron from "node-cron";
import { ElectionProcess } from "../models/index.js";

const updateElectionStatus = () => {
  cron.schedule("* * * * *", async () => {
    // Ajusta el cron según sea necesario
    try {
      const now = new Date();
      const processes = await ElectionProcess.find();

      for (const process of processes) {
        if (
          process.process_status === "programmed" &&
          now >= new Date(process.start_date)
        ) {
          process.process_status = "in_progress";
          await process.save();
        } else if (
          process.process_status === "in_progress" &&
          now >= new Date(process.end_date)
        ) {
          process.process_status = "done";
          await process.save();
        }
      }
    } catch (error) {
      console.error("Error al actualizar los procesos electorales:", error);
    }
  });
};

export default updateElectionStatus;
