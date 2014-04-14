package com.intel.spark.log.processor;

public abstract class BaseProcessor implements Processor {

	String logLine;

	public BaseProcessor(String logLine) {
		this.logLine = logLine;
	}
}
