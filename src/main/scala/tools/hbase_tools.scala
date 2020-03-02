package tools

import org.apache.hadoop.hbase._
import org.apache.hadoop.hbase.client.{Admin, ConnectionFactory, Delete, Scan}
import org.apache.spark.sql.SparkSession
import org.apache.hadoop.hbase.spark.HBaseContext
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.filter.{BinaryComparator, CompareFilter, SingleColumnValueFilter}



object hbase_tools {
  val conf = HBaseConfiguration.create()
  conf.set("hbase.zookeeper.property.clientPort", "2181")
  conf.set("hbase.zookeeper.quorum", "d1,d2,d3,d4,d5")

  def delete_data(spark:SparkSession,tableName: String,v_txdate:String): Unit = {
    val target_table=TableName.valueOf(tableName)
    val scan = new Scan()
    scan.setStartRow(Bytes.toBytes(v_txdate))

   val hbaseContext = new HBaseContext(spark.sparkContext, conf)
    val ScanRdd = hbaseContext.hbaseRDD(target_table, scan)
    val rowkey_rdd=ScanRdd.map(line=>line._2.getRow)

    hbaseContext.bulkDelete[Array[Byte]](rowkey_rdd,target_table,
      putRecord => new Delete(putRecord), 5000)
  }

   def delete_data_by_value_equal(spark:SparkSession,tableName: String,volume:String,value:String): Unit = {
     val target_table = TableName.valueOf(tableName)
     val scan = new Scan()
     val filter = new SingleColumnValueFilter(Bytes.toBytes("info"), Bytes.toBytes(volume.toLowerCase()), CompareFilter.CompareOp.EQUAL, new BinaryComparator(value.getBytes))
     filter.setFilterIfMissing(true)
     scan.setFilter(filter)
    val hbaseContext = new HBaseContext(spark.sparkContext, conf)
     val ScanRdd = hbaseContext.hbaseRDD(target_table, scan)
     val rowkey_rdd = ScanRdd.map(line => line._2.getRow)

     hbaseContext.bulkDelete[Array[Byte]](rowkey_rdd, target_table,
       putRecord => new Delete(putRecord), 5000)

   }

  /**
    * Hbase客户端删除表
    * @param tablename
    */
  def deleteTableBytableName(tablename:String): Unit ={
    val admin : Admin= ConnectionFactory.createConnection(conf).getAdmin
    try{
    println(admin.toString)
    // 删除表
    if (admin.tableExists(TableName.valueOf(tablename))) {
      admin.disableTable(TableName.valueOf(tablename))
      admin.deleteTable(TableName.valueOf(tablename))
      val tableDescriptor : HTableDescriptor= new HTableDescriptor(TableName.valueOf(tablename))
      tableDescriptor.addFamily(new HColumnDescriptor("info"))
      admin.createTable(tableDescriptor)
      admin.close()
    } else{
      val tableDescriptor : HTableDescriptor= new HTableDescriptor(TableName.valueOf(tablename))
      tableDescriptor.addFamily(new HColumnDescriptor("info"))
      admin.createTable(tableDescriptor)
      admin.close()
    }
    }catch {
      case ex:Exception=>
      println(ex)
      admin.close()
    }
}



}
