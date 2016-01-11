
## Make sure to use Java 8

Set to Java 8 if it is not the case
```
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/
```

## Run the job

```
mvn package 
```

## Run the job

```
spark-submit  --class "com.databricks.apps.logs.chapter1.LogAnalyzer" --master local[4] target/log-analyzer-1.0.jar src/test/resources/ssl_access_log 
```

# Reference

This examples is based on this example

https://databricks.gitbooks.io/databricks-spark-reference-applications/content/logs_analyzer/chapter1/spark.html



