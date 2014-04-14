package com.intel.spark.log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.intel.spark.log.model.App;

public class Main {
	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.err.print("Please input Spark Driver's log file path.");
			System.exit(1);
		}
		String fileStr = args[0];
		processFile(fileStr);
	}

	private static void processFile(String fileStr) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileStr));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		String line;
		App app = new App();
		while ((line = br.readLine()) != null) {
			Matcher.match(line).process(app);
		}
	}
}
