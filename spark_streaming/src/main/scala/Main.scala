package diaf.bro

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

import org.apache.log4j.Logger
import org.apache.log4j.Level
import java.time.LocalDateTime

object Main {
  def main(args: Array[String]) {

    // Logger.getLogger("org").setLevel(Level.OFF)
    // Logger.getLogger("akka").setLevel(Level.OFF)
    // spark.sparkContext.setLogLevel("ERROR")

    val spark = SparkSession.builder
      .appName("Spark Streaming V2.0")
      // .config("spark.submit.deployMode", "cluster")
      // .config("spark.executor.memory", "6g")
      // .master("spark://0e9fdd096c1c.mylabserver.com:7077")
      .getOrCreate()

    import spark.implicits._


    val PATH = "data/diaf.txt"
    val text = spark.read.textFile(PATH)

    // val text = spark.readStream
    //   .format("socket")
    //   .option("host", "localhost")
    //   .option("port", "3000")
    //   .load()

    print(this.getClass().getCanonicalName())

    val wordCounts = text
      .select(explode(split(text("value"), " ")))
      .select(lower($"col").alias("word"))
      .groupBy("word")
      .count()
    //   .sort(col("count").desc())

    // wordCounts.head()

    wordCounts.write.csv(f"data/bro-${LocalDateTime.now()}")

    // val query = wordCounts.writeStream
    //   .outputMode("complete")
    //   .format("console")
    //   .start()

    // query.awaitTermination()

  }
}
