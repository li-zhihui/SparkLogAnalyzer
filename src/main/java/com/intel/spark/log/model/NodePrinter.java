package com.intel.spark.log.model;

import java.io.File;
import java.io.FileOutputStream;

public class NodePrinter {

	public static void print(App app) throws Exception {
		FileOutputStream jobFs = new FileOutputStream(new File("/tmp/job.csv"));
		FileOutputStream stageFs = new FileOutputStream(new File(
				"/tmp/stage.csv"));
		FileOutputStream taskFs = new FileOutputStream(
				new File("/tmp/task.csv"));

		for (Job job : app.getChildren()) {
			String jobName = job.getName();
			jobFs.write((jobName + "," + job.getStartTime() + ","
					+ job.getEndTime() + "\r\n").getBytes());
			for (Stage stage : job.getChildren()) {
				String stageName = stage.getName();
				stageFs
						.write((stageName + "," + jobName + ","
								+ stage.getStartTime() + ","
								+ stage.getEndTime() + "\r\n").getBytes());
				for (TaskSet taskSet : stage.getChildren()) {
					for (Task task : taskSet.getChildren()) {
						taskFs.write((task.getId() + "," + stageName + ","
								+ jobName + "," + task.getStartTime() + ","
								+ task.getEndTime() + "\r\n").getBytes());
					}
				}
			}
		}
		jobFs.close();
		stageFs.close();
		taskFs.close();
	}
}
