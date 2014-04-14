package com.intel.spark.log.processor;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.intel.spark.log.model.Node;

public abstract class BaseProcessor implements Processor {

	String logLine;
	long time;

	public Processor apply(String logLine) throws ParseException {
		this.logLine = logLine;
		time = getTime();
		return this;
	}

	private long getTime() throws ParseException {
		String dateStr = logLine.substring(0, 17);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return format.parse("20" + dateStr).getTime();
	}

	public void initNode(Node node) {
		node.setStr(logLine);
	}

}
