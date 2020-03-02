package tools

import org.apache.spark.sql.SparkSession

/**
  * Author : caiwenjun
  * version :1.0
  * createtime : 2019/7/23 11:08
  */
object import_to_hive_read_partition {
  def import_data(source_table:String,target_table: String,source_database:String ,sql :String , sparkSession: SparkSession,numPartitions:Int,partitionColumn:String,lowerBound:String,upperBound:String): Unit ={

    val source_table_temp = sparkSession.read.format("jdbc").option("fetchSize" , "3000")
        .option("numPartitions",numPartitions).option("partitionColumn",partitionColumn).option("lowerBound", lowerBound).option("upperBound",upperBound)
        .options(tools.get_connection.red_format(source_table,source_database)).load()

    source_table_temp.createOrReplaceTempView("source_table_temp")

    val load_data=sparkSession.sql(sql)

    sparkSession.sql("use bistg")
    sparkSession.sql("set hive.exec.dynamic.partition.mode=nonstrict")
    sparkSession.sql("set hive.exec.dynamic.partition=true")
    load_data.write.option("numPartitions" , "2000").mode("overwrite").format("orc").insertInto(target_table)

  }

  def import_data_append(source_table:String,target_table: String,source_database:String ,sql :String , sparkSession: SparkSession,numPartitions:Int,partitionColumn:String,lowerBound:String,upperBound:String): Unit ={

    val source_table_temp = sparkSession.read.format("jdbc").option("fetchSize" , "3000")
      .option("numPartitions",numPartitions).option("partitionColumn",partitionColumn).option("lowerBound", lowerBound).option("upperBound",upperBound)
      .options(tools.get_connection.red_format(source_table,source_database)).load()

    source_table_temp.createOrReplaceTempView("source_table_temp")

    val load_data=sparkSession.sql(sql)
    sparkSession.sql("use bistg")
    load_data.write.option("numPartitions" , "2000").mode("append").insertInto(target_table)

  }
}
