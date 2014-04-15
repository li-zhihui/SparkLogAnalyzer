SparkLogAnalyzer
================


SparkLogAnalyzer is a tool could analyse Apache Spark log to output job, stage, task, memory statistics infomation.

Quick start:
1 mvn install
2 ./run.sh

job.csv format
job name, job start time, job end time, pre-job duration, job duration, post-job duration

stage.csv format
stage name, job name, stage start time, stage end time, pre-stage duration, stage suration, post-stage duration

task.csv format
taskId, stage name, job name, task start time, task end time, pre-task duration, task duration, post-task duration

