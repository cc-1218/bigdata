package tools

import java.security.MessageDigest
import javax.swing.text.AbstractDocument.Content

import org.apache.commons.lang.StringEscapeUtils
import sun.misc.BASE64Decoder


object EncodeUtil {


  def getMd5(content: String):String = {
    MessageDigest.getInstance("MD5").digest((content).getBytes).map("%02x".format(_)).mkString.toUpperCase
  }

  def Unicode2ASCII(contents: String):String = {
    val strBuf = new StringBuffer()

    val content = StringEscapeUtils.unescapeHtml(contents)
    if (content.contains("&#")){
      val cuts = content.split("&#")
      for ( i <- Range(0,cuts.length) ){
        if(i==0){
          strBuf.append(cuts(i))
          println(strBuf)
        }
        if(cuts(i).contains(";")) {
          var cs = cuts(i).split(";")
          strBuf.append(cs(0).toInt.toChar)
          if (cs.length == 2)
            strBuf.append(cs(1))
        }
      }
    }
    else {
      strBuf.append(content)
    }

//    val cuts = content.split("&#")
////    println(cuts.length)
//    for ( i <- Range(0,cuts.length) ){
//      if(i==0){
//        strBuf.append(cuts(i))
//        println(strBuf)
//      }
//      if(cuts(i).contains(";")) {
//        var cs = cuts(i).split(";")
//        strBuf.append(cs(0).toInt.toChar)
//        if (cs.length == 2)
//          strBuf.append(cs(1))
//      }
//    }
   strBuf.toString

  }

  //base64解密
  def getBase64(str:String): String ={
    val  decoder = new BASE64Decoder()
    var str1 = decoder.decodeBuffer(str)
    val str2 = new String(str1)
    str2
  }

}
