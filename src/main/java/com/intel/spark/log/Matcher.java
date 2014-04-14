package com.intel.spark.log;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.intel.spark.log.processor.JobStartProcessor;
import com.intel.spark.log.processor.Processor;
import com.intel.spark.log.processor.StageStartProcessor;
import com.intel.spark.log.processor.TaskStartProcessor;

public class Matcher {

	static Map<String, Processor> map = new HashMap<String, Processor>();
	static {
		map.put("Starting job", new JobStartProcessor());
		map.put("Submitting Stage", new StageStartProcessor());
		map.put("Starting task", new TaskStartProcessor());
	}

	public static Processor build(String line) throws Exception {
		for (Entry<String, Processor> entry : map.entrySet()) {
			if (line.matches(entry.getKey())) {
				return entry.getValue().getClass().newInstance();
			}
		}
		return null;
	}
}
