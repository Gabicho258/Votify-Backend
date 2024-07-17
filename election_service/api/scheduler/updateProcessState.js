import cron from "node-cron";
import { ElectionProcess } from "../models/index.js";

const updateElectionStatus = () => {
  cron.schedule("* * * * *", async () => {
    // Ajusta el cron según sea necesario
    try {
      //   const now = new Date();
      //   const processes = await ElectionProcess.find();

      //   for (const process of processes) {
      //     if (process.status === "scheduled" && now >= process.startDate) {
      //       process.status = "in_progress";
      //     } else if (process.status === "in_progress" && now >= process.endDate) {
      //       process.status = "completed";
      //     }
      //     await process.save();
      //   }

      //   console.log("Procesos electorales actualizados.");
      console.log("revisa cada minuto");
    } catch (error) {
      console.error("Error al actualizar los procesos electorales:", error);
    }
  });
};

export default updateElectionStatus;
