package tools

import org.apache.spark.sql.SparkSession


object import_to_hive {

def import_data(source_table:String,target_table: String,source_database:String ,sql :String , sparkSession: SparkSession): Unit ={

  val source_table_temp = sparkSession.read.format("jdbc").option("numPartitions" , "100").option("fetchSize" , "3000").options(tools.get_connection.red_format(source_table,source_database)).load()

  source_table_temp.createOrReplaceTempView("source_table_temp")

  val load_data=sparkSession.sql(sql)

  sparkSession.sql("use bistg")
  sparkSession.sql("set hive.exec.dynamic.partition.mode=nonstrict")
  sparkSession.sql("set hive.exec.dynamic.partition=true")
  load_data.write.option("numPartitions" , "2000").mode("overwrite").insertInto(target_table)

}

 def import_data_append(source_table:String,target_table: String,source_database:String ,sql :String , sparkSession: SparkSession): Unit = {
   val source_table_temp = sparkSession.read.format("jdbc").option("numPartitions" , "100").option("fetchSize" , "3000").options(tools.get_connection.red_format(source_table,source_database)).load()

   source_table_temp.createOrReplaceTempView("source_table_temp")

   val load_data=sparkSession.sql(sql)
   sparkSession.sql("use bistg")
   load_data.write.option("numPartitions" , "2000").mode("append").insertInto(target_table)
 }
}
