package com.intel.spark.log.processor;

import com.intel.spark.log.model.App;

public interface Processor {

	void process(App app);
}
