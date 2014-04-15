package com.intel.spark.log;

import java.io.BufferedReader;
import java.io.FileReader;

import com.intel.spark.log.model.App;
import com.intel.spark.log.processor.Processor;

public class Main {
	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.err.print("Please input Spark Driver's log file path.");
			System.exit(1);
		}
		String fileStr = args[0];
		processFile(fileStr);
	}

	private static void processFile(String fileStr) throws Exception {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileStr));
			String line;
			App app = new App();
			while ((line = br.readLine()) != null) {
				Processor processor = Matcher.build(line);
				if(processor==null){
					continue;
				}
				processor.apply(line).process(app);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}finally{
			if(br!=null){
				br.close();
			}
		}
		
	}
}
