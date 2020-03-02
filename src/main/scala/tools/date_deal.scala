package tools

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

import scala.collection.mutable.ListBuffer


object date_deal {
  /**
    * 获取当前日期前一个月最初一天
    * output("yyyyMMdd")
    * @param str
    * @return
    */

  def get_first_day_of_month(str:String): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }
    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val month=v_txdate.substring(4,6).toInt-2
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.YEAR,year)
    calendar.set(Calendar.MONTH,month)
    val maxday=calendar.getActualMinimum(Calendar.DAY_OF_MONTH)
    calendar.set(Calendar.DAY_OF_MONTH, maxday)
    val first_day=new SimpleDateFormat("yyyyMMdd").format(calendar.getTime())
    first_day
  }
  /**
    * 获取当前日期前一个月最初一天
    * output("yyyy-MM-dd")
    * @param str
    * @return
    */

  def get_first_day_of_month_yyyy_MM_dd_HH_mm_ss(str:String): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }
    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val month=v_txdate.substring(4,6).toInt-2
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.YEAR,year)
    calendar.set(Calendar.MONTH,month)
    val maxday=calendar.getActualMinimum(Calendar.DAY_OF_MONTH)
    calendar.set(Calendar.DAY_OF_MONTH, maxday)
    val first_day=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime())
    first_day
  }
  /**
    * 获取当前日期最初一天
    * output("yyyyMMdd")
    * @param str
    * @return
    */

  def get_first_day(str:String): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }
    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val month=v_txdate.substring(4,6).toInt-1
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.YEAR,year)
    calendar.set(Calendar.MONTH,month)
    val maxday=calendar.getActualMinimum(Calendar.DAY_OF_MONTH)
    calendar.set(Calendar.DAY_OF_MONTH, maxday)
    val first_day=new SimpleDateFormat("yyyyMMdd").format(calendar.getTime())
    first_day
  }

  /**
    * 获取当前日期前一月月份最后一天
    * output("yyyyMMdd")
    * @param str
    * @return
    */

  def get_last_day_of_month_yyyyMMdd(str:String): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }
    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val month=v_txdate.substring(4,6).toInt-2
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.YEAR,year)
    calendar.set(Calendar.MONTH,month)
    val maxday=calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    calendar.set(Calendar.DAY_OF_MONTH, maxday)
    val last_day=new SimpleDateFormat("yyyyMMdd").format(calendar.getTime())
    last_day
  }

  /**
    * 获取当前日期月份最后一天
    * output("yyyyMMdd")
    * @param str
    * @return
    */
  def get_last_day_yyyyMMdd(str:String): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }
    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val month=v_txdate.substring(4,6).toInt-1
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.YEAR,year)
    calendar.set(Calendar.MONTH,month)
    val maxday=calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    calendar.set(Calendar.DAY_OF_MONTH, maxday)
    val last_day=new SimpleDateFormat("yyyyMMdd").format(calendar.getTime())
    last_day
  }
  //上个月最后一天
  def get_last_day_of_month_yyyy_MM_dd_HH_mm_ss(str:String): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }
    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val month=v_txdate.substring(4,6).toInt-2
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.YEAR,year)
    calendar.set(Calendar.MONTH,month)
    val maxday=calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    calendar.set(Calendar.DAY_OF_MONTH, maxday)
    val last_day=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime())
    last_day
  }

  //获取传入日期当月最后一天
  def get_last_day_yyyy_MM_dd_HH_mm_ss(str:String): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }
    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val month=v_txdate.substring(4,6).toInt-1
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.YEAR,year)
    calendar.set(Calendar.MONTH,month)
    val maxday=calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    calendar.set(Calendar.DAY_OF_MONTH, maxday)
    val last_day=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime())
    last_day
  }

  /**
    * 获取当前日期前一月日期
    * output("yyyyMMdd")
    * @param str
    * @return
    */

  def get_first_day_of_month_before(str:String): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }
    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val month=v_txdate.substring(4,6).toInt-2
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.YEAR,year)
    calendar.set(Calendar.MONTH,month)
    val maxday=calendar.getActualMinimum(Calendar.DAY_OF_MONTH)
    calendar.set(Calendar.DAY_OF_MONTH, maxday)
    val first_day_month_before=new SimpleDateFormat("yyyyMMdd").format(calendar.getTime())
    first_day_month_before
  }

  /**
    * 获取当前日期年份最初日期
    * output("yyyyMMdd")
    * @param str
    * @return
    */
  def get_first_day_of_year(str:String): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }

    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val month=v_txdate.substring(4,6).toInt-2
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.YEAR,year)
    val maxday=calendar.getActualMinimum(Calendar.DAY_OF_YEAR)
    calendar.set(Calendar.DAY_OF_YEAR, maxday)
    val first_day_year=new SimpleDateFormat("yyyyMMdd").format(calendar.getTime())
    first_day_year
  }

  /**
    * 获取当前日期年份最初月份
    * output("yyyyMM")
    * @param str
    * @return
    */
  def get_first_month_of_year(str:String): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }

    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val month=v_txdate.substring(4,6).toInt-2
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.YEAR,year)
    calendar.set(Calendar.MONTH,month)
    val maxday=calendar.getActualMinimum(Calendar.DAY_OF_YEAR)
    calendar.set(Calendar.DAY_OF_YEAR, maxday)
    val first_month_year=new SimpleDateFormat("yyyyMM").format(calendar.getTime())
    first_month_year
  }


  /**
    * 获取当月的前后月份日期
    * output("yyyyMMdd")
    * @param str
    * @param i
    * @return
    */
  def date_add_month(str:String,i :Int): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }

    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val month=v_txdate.substring(4,6).toInt+i-1
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.MONTH,month)
    val add_month_date=new SimpleDateFormat("yyyyMMdd").format(calendar.getTime())
    add_month_date
  }

  /**
    * 获取当月的前后月份
    * output("yyyyMM")
    * @param str
    * @param i
    * @return
    */
  def month_add_month(str:String,i :Int): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }

    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val month=v_txdate.substring(4,6).toInt+i-1
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.MONTH,month)
    val add_month_date=new SimpleDateFormat("yyyyMM").format(calendar.getTime())
    add_month_date
  }

  /**
    * 获取当月的前后月份
    * output("yyyyMM")
    * @param str
    * @param i
    * @return
    */
  def month_add_month_yyyyMMdd_HH_mm_ss(str:String,i :Int): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }

    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val month=v_txdate.substring(4,6).toInt+i-1
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.MONTH,month)
    val add_month_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime())
    add_month_date
  }

  /**
    * 根据传入参数获取传入日期的前几天或者后几天
    * @param date
    * @param diff
    * @return yyyyMMdd
    */
  def getNextOrLastDateByParameterDate(date:String,diff:Int): String ={
    val date_temp=date.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(date)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(date)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(date)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(date)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(date)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date)
    }
    val calendar = Calendar.getInstance()
    calendar.setTime(date_temp)
    val day = calendar.get(Calendar.DATE)
    calendar.set(Calendar.DATE, day + diff)
    val v_etl_dt_temp = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime())
    v_etl_dt_temp
  }



  /**
    * 根据传入参数获取传入日期的前几天或者后几天
    * @param date
    * @param diff
    * @return yyyy-MM-dd HH:mm:ss
    */
  def getNextOrLastDateByParameterDate_yyyy_MM_dd(date:String,diff:Int): String ={
    val date_temp=date.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(date)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(date)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(date)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(date)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(date)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date)
    }
    val calendar = Calendar.getInstance()
    calendar.setTime(date_temp)
    val day = calendar.get(Calendar.DATE)
    calendar.set(Calendar.DATE, day + diff)
    val v_etl_dt_temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime())
    v_etl_dt_temp
  }


  /**
    * 获取上一年最后一个月 20190827  =====》   201812
    * @param date
    */
  def getLastYearAndLatestMonthByDate(date:String): String ={
    val date_temp=date.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(date)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(date)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(date)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(date)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(date)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date)
    }
    val calendar = Calendar.getInstance()
    calendar.setTime(date_temp)
    val year = calendar.get(Calendar.YEAR)
    calendar.set(Calendar.YEAR,year-1)
    val v_etl_dt_temp = new SimpleDateFormat("yyyy").format(calendar.getTime())+"12"
    v_etl_dt_temp
  }

  /**
    * 获取上一年12月31日
    * @param date
    * @return xxxx-12-31 00:00:00
    */
  def getLastYearAndLatestDayByDate(date:String): String ={
    val date_temp=date.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(date)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(date)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(date)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(date)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(date)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date)
    }
    val calendar = Calendar.getInstance()
    calendar.setTime(date_temp)
    val year = calendar.get(Calendar.YEAR)
    calendar.set(Calendar.YEAR,year-1)
    val v_etl_dt_temp = new SimpleDateFormat("yyyy").format(calendar.getTime())+"-12-31 00:00:00"
    v_etl_dt_temp
  }



  /**
    * 获取当年第一天 20190827 =====》 2019-01-01
    * @param str
    * @return
    */
  def getFirstDayAndFirstMonthByDate(str:String): String = {
    val date=str.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(str)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(str)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(str)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(str)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(str)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
    }

    val v_txdate=new SimpleDateFormat("yyyyMMdd").format(date)
    val year=v_txdate.substring(0,4).toInt
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.set(Calendar.YEAR,year)
    val maxday=calendar.getActualMinimum(Calendar.DAY_OF_YEAR)
    calendar.set(Calendar.DAY_OF_YEAR, maxday)
    val first_month_year=new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())
    first_month_year
  }


  /**
    * 获取当月最后一天   20190827 =====》2019-08-31
    * @param date
    * @return
    */
  def getLatestDayByDate(date:String): String ={
    val date_temp=date.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(date)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(date)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(date)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(date)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(date)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date)
    }
    val calendar = Calendar.getInstance()
    calendar.setTime(date_temp)
    val day = calendar.getActualMaximum(Calendar.DATE)
    calendar.set(Calendar.DAY_OF_MONTH,day)
    val first_month_year=new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())
    first_month_year
  }


  /**
    * 获取当月第一天   20190827 =====》2019-08-01
    * @param date
    * @return
    */
  def getFirstDayByDate(date:String): String ={
    val date_temp=date.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(date)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(date)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(date)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(date)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(date)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date)
    }
    val calendar = Calendar.getInstance()
    calendar.setTime(date_temp)
    val day = calendar.getActualMinimum(Calendar.DATE)
    calendar.set(Calendar.DAY_OF_MONTH,day)
    val first_month_year=new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())
    first_month_year
  }

  def getFirstDayByDate_yyyy_MM_dd_HH_mm_ss(date:String): String ={
    val date_temp=date.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(date)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(date)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(date)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(date)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(date)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date)
    }
    val calendar = Calendar.getInstance()
    calendar.setTime(date_temp)
    val day = calendar.getActualMinimum(Calendar.DATE)
    calendar.set(Calendar.DAY_OF_MONTH,day)
    val first_month_year=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime())
    first_month_year
  }

  /**
    * 获取当前季度第一天   20190827 =====》2019-07-01
    * @param date
    * @return
    */
  def get_first_day_of_quarter(date:String): String ={
    val date_temp=date.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(date)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(date)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(date)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(date)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(date)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date)
    }
    val calendar = Calendar.getInstance()
    calendar.setTime(date_temp)
    val date_parse=new SimpleDateFormat("yyyyMMdd").format(calendar.getTime())
    val first_day_of_quarter= date_parse.substring(4, 6) match {
      case "01" | "02" | "03" =>date_parse.substring(0,4).concat("-01-01")
      case "04" | "05" | "06" =>date_parse.substring(0,4).concat("-04-01")
      case "07" | "08" | "09" =>date_parse.substring(0,4).concat("-07-01")
      case "10" | "11" | "12" =>date_parse.substring(0,4).concat("-10-01")
    }
    first_day_of_quarter
  }
  /**
    * 获取当前日期前几天天   20190827 =====》2019-08-26
    * @param date
    * @return
    */
  def get_day_before_of_date(date:String,days:Int): String ={
    val date_temp=date.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(date)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(date)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(date)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(date)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(date)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date)
    }
    val calendar = Calendar.getInstance()
    calendar.setTime(date_temp)
    calendar.add(Calendar.DATE,days)
    val day_before_of_date=new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())
    day_before_of_date
  }

  def to_date(date:String): String = {
    val date_temp=date.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(date)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(date)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(date)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(date)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(date)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date)
    }
    val calendar = Calendar.getInstance()
    calendar.setTime(date_temp)
    val date_parse=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime())
    date_parse
  }

  def to_String_yyyyMMdd(date:String): String = {
    val date_temp=date.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(date)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(date)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(date)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(date)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(date)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date)
    }
    val calendar = Calendar.getInstance()
    calendar.setTime(date_temp)
    val date_parse=new SimpleDateFormat("yyyyMMdd").format(calendar.getTime())
    date_parse
  }

  /**
    * 根据传入参数获取传入日期的前几天或者后几天
    * @param date
    * @param diff
    * @return yyyy-MM-dd HH:mm:ss
    */

  def getNextOrLastDateByParameterDate_yyyy_MM_dd_HH_mm_ss(date:String,diff:Int): String ={
    val date_temp=date.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(date)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(date)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(date)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(date)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(date)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date)
    }
    val calendar = Calendar.getInstance()
    calendar.setTime(date_temp)
    val day = calendar.get(Calendar.DATE)
    calendar.set(Calendar.DATE, day + diff)
    val v_etl_dt_temp = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime())
    v_etl_dt_temp
  }

  /**
    * 获取两个日期间的所有日期
    * @param startdate
    * @param enddate
    * @return
    */
  def getTimesBetweenDates(startdate:String,enddate:String):ListBuffer[String]={
    var startdate_temp=startdate.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(startdate)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(startdate)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(startdate)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(startdate)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(startdate)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startdate)
    }
    var enddate_temp=enddate.length match{
      case 4=>  new SimpleDateFormat("yyyy").parse(enddate)
      case 6=>  new SimpleDateFormat("yyyyMM").parse(enddate)
      case 8=>  new SimpleDateFormat("yyyyMMdd").parse(enddate)
      case 10=> new SimpleDateFormat("yyyy-MM-dd").parse(enddate)
      case 12=> new SimpleDateFormat("yyyyMMddHHmmss").parse(enddate)
      case _=>  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(enddate)
    }

    //如果时间传反了
    val time1 = startdate_temp.getTime()
    val  time2 = enddate_temp.getTime()
    var midTime = new Date()
    if (time1 > time2) {
      midTime = startdate_temp
      startdate_temp = enddate_temp
      enddate_temp = midTime
    }

    import scala.collection.mutable.ListBuffer
    val list: ListBuffer[String] = new ListBuffer[String]()
    val sta_calendar: Calendar = Calendar.getInstance()
    sta_calendar.setTime(startdate_temp)
    val end_calendar: Calendar = Calendar.getInstance()
    end_calendar.setTime(enddate_temp)

    end_calendar.add(Calendar.DATE, +1)// 日期+1,将结束日期放入结果集
    while (sta_calendar.before(end_calendar)){
      list+=new SimpleDateFormat("yyyyMMdd").format(sta_calendar.getTime)
      sta_calendar.add(Calendar.DAY_OF_YEAR,1)
    }
    list
  }



}
