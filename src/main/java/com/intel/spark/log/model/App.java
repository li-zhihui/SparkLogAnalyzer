package com.intel.spark.log.model;

import java.util.HashMap;
import java.util.Map;

public class App extends Node<Job, Object> {
	public String CURRENT_TASK_SET = "currentTaskSet";
	public String CURRENT_JOB = "currentJob";// FIXME assume job is NOT
												// concurrent.
	private Map<String, Node> context = new HashMap<String, Node>();

	public Map<String, Node> getContext() {
		return context;
	}

	public void setContext(Map<String, Node> context) {
		this.context = context;
	}

}
