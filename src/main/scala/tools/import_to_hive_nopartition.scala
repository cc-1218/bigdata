package tools

import org.apache.spark.sql.SparkSession

/**
  * Author : caiwenjun
  * version :1.0
  * createtime : 2019/7/18 9:43
  */
object import_to_hive_nopartition {
  def import_data_nopart(source_table:String,target_table: String,source_database:String ,sql :String , sparkSession: SparkSession): Unit ={

    val source_table_temp = sparkSession.read.format("jdbc").option("fetchSize" , "3000").option("spark.sql.files.maxPartitionBytes",268435456).option("spark.sql.files.openCostInBytes",8388608).options(tools.get_connection.red_format(source_table,source_database)).load()

    source_table_temp.createOrReplaceTempView("source_table_temp")

    val load_data=sparkSession.sql(sql)

    sparkSession.sql("use bistg")

    load_data.write.option("numPartitions" , "2000").mode("overwrite").format("orc").saveAsTable(target_table)

  }

  def import_data_append(source_table:String,target_table: String,source_database:String ,sql :String , sparkSession: SparkSession): Unit ={

    val source_table_temp = sparkSession.read.format("jdbc").option("fetchSize" , "3000").option("spark.sql.files.maxPartitionBytes",268435456).option("spark.sql.files.openCostInBytes",8388608).options(tools.get_connection.red_format(source_table,source_database)).load()

    source_table_temp.createOrReplaceTempView("source_table_temp")

    val load_data=sparkSession.sql(sql)

    sparkSession.sql("use bistg")

    load_data.write.option("numPartitions" , "2000").mode("append").insertInto(target_table)

  }
}
