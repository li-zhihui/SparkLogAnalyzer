package com.intel.spark.log;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.intel.spark.log.processor.JobFinishProcessor;
import com.intel.spark.log.processor.JobStartProcessor;
import com.intel.spark.log.processor.Processor;
import com.intel.spark.log.processor.StageFinishProcessor;
import com.intel.spark.log.processor.StageStartProcessor;
import com.intel.spark.log.processor.TaskFinishProcessor;
import com.intel.spark.log.processor.TaskSetAddProcessor;
import com.intel.spark.log.processor.TaskSetProcessor;
import com.intel.spark.log.processor.TaskStartProcessor;

public class Matcher {

	static Map<String, Processor> map = new HashMap<String, Processor>();
	static {
		map.put("(.*)Starting job(.*)", new JobStartProcessor());
		map.put("(.*)Submitting Stage(.*)", new StageStartProcessor());
		map.put("(.*)Starting task(.*)", new TaskStartProcessor());
		map.put("(.*)Submitting ([0-9]*) missing tasks from Stage(.*)",
				new TaskSetProcessor());
		map.put("(.*)Adding task set(.*)", new TaskSetAddProcessor());
		map.put("(.*)Starting task(.*)as TID(.*)", new TaskStartProcessor());
		map.put("(.*)TaskSetManager: Finished TID(.*)",
				new TaskFinishProcessor());
		map.put("(.*)DAGScheduler: Stage(.*)finished in(.*)",
				new StageFinishProcessor());
		map.put("(.*)SparkContext: Job finished(.*)", new JobFinishProcessor());
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
