package com.guoxin.common.util;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;

public class Utilities {
  // Create an 24 byte UUID
  protected static int count = 0;
  
  /**
   * encrypt password
   *
   * @param username String
   * @param password String
   * @return String
   */
  public static String encryptPassword(String username, String password) {
    return username + "@spmvc#" + password;
  }
  
  
  /**
   * @return String
   */
  public static synchronized String getUUID() {
    count++;
    long time = System.currentTimeMillis();
    String uuid = "W" + Long.toHexString(time) + Integer.toHexString(count) +
        Long.toHexString(Double.doubleToLongBits(Math.random()));
    uuid = uuid.substring(0, 24).toUpperCase();
    return uuid;
  }



  /**
   * Mime types form download file
   *
   * @param filename String
   * @return String
   */
  public static String getMimeType(String filename) {
    String mimetype = "application/octet-stream";
    if (filename != null && filename.length() > 0) {
      if (filename.endsWith(".asf")) {
        mimetype = "video/x-ms-asf";
      }
      else if (filename.endsWith(".avi")) {
        mimetype = "video/avi";
      }
      else if (filename.endsWith(".doc")) {
        mimetype = "application/msword";
      }
      else if (filename.endsWith(".zip")) {
        mimetype = "application/zip";
      }
      else if (filename.endsWith(".xls")) {
        mimetype = "application/vnd.ms-excel";
      }
      else if (filename.endsWith(".gif")) {
        mimetype = "image/gif";
      }
      else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) {
        mimetype = "image/jpeg";
      }
      else if (filename.endsWith(".wav")) {
        mimetype = "audio/wav";
      }
      else if (filename.endsWith(".mp3")) {
        mimetype = "audio/mpeg3";
      }
      else if (filename.endsWith(".mpg") || filename.endsWith(".mpeg")) {
        mimetype = "video/mpeg";
      }
      else if (filename.endsWith(".rtf")) {
        mimetype = "application/rtf";
      }
      else if (filename.endsWith(".htm") || filename.endsWith(".html")) {
        mimetype = "text/html";
      }
      else if (filename.endsWith(".txt")) {
        mimetype = "text/plain";
      }
    }
    return mimetype;
  }
  

  /**
   * 过滤null值
   * @param tempString String
   * @return String
   */
  public static String changeNull(String tempString) {
    String result = "";
    if (tempString != null) {
      result = tempString.trim();
    }
    return result;
  }
  /**
   * 下载文档信息需要将文件的名称进行编码转换。
   * toUtf8String
   *
   * @param filename String
   * @return String
   */
  public static String fileNameFilter(String str) {
    String utf = str;
    try {
      utf = URLEncoder.encode(str, "UTF-8");
    }
    catch (Exception e) {
		e.printStackTrace();
    }
    return utf;
  }

  /**
   * 功能： 获取文件后缀
   * @author Alex
   * @param pathName
   * @return
   * 创建时间：2011-12-2 下午02:37:49
   */
  public static String getSuffix(String pathName){
	  int startIndex = pathName.lastIndexOf(".");
	  if(startIndex>0) return pathName.substring(startIndex,pathName.length());
	  else return null;
  }
  
  /**
   * 功能： 将制定的文件们的打包到制定的文件中去
   * @author Alex
   * @param zipName
   * @param files
   * @throws IOException
   * 创建时间：2011-12-2 下午03:40:04
   */
  public static String zipFile(String zipName,List<File> files){
 
	  String result = "success";
	  
      byte[] buf = new byte[1024];
      int len;
      FileOutputStream fos = null;
      BufferedOutputStream bos = null;
      ZipOutputStream zos = null;//压缩包
      FileInputStream fis = null;
      BufferedInputStream bis = null;
      try{
      	fos = new FileOutputStream(zipName);
        bos = new BufferedOutputStream(fos);
        zos = new ZipOutputStream(bos);//压缩包
      
      for(int i = 0;i<files.size();i++){
    	  File f =files.get(i);
    	   fis = new FileInputStream(f);
           bis = new BufferedInputStream(fis);
          ZipEntry ze = new ZipEntry(f.getName());//这是压缩包名里的文件名
          zos.putNextEntry(ze);//写入新的 ZIP 文件条目并将流定位到条目数据的开始处
          while((len=bis.read(buf))!=-1)
          {
             zos.write(buf,0,len);
             zos.flush();
          }
        
      }
    
      }catch (Exception e) {
    	  result = "error";
	}finally{
		try{
		  if(bis!=null)  bis.close();
		  if(zos!=null) zos.close(); 
		  if(fos!=null) fos.close();
		  if(bos!=null) bos.close();
		  if(fis!=null) fis.close();
		}catch (Exception e) {
			e.printStackTrace();
			result = "error";
		}
	}
	
	return result;
  }
  
  /**
   * 功能： 递归保存文件夹
   * @author Alex
   * @param output
   * @param file
   * @param basePath
   * @throws IOException
   * 创建时间：2011-12-2 下午05:10:59
   */
  private static   void zipFolder(ZipOutputStream output, File file,  
          String basePath) throws IOException {  
      FileInputStream input = null;  
      try {  
          /** 
           * 文件为目录 
           */  
          if (file.isDirectory()) {  
              /** 
               * 得到当前目录里面的文件列表 
               */  
              File list[] = file.listFiles();  
              basePath =   (basePath.length() == 0 ? "" : "/")  
                      + file.getName();  
              /** 
               * 循环递归压缩每个文件 
               */  
              for (File f : list)  
            	  zipFolder(output, f, basePath);  
          } else {  
              /** 
               * 压缩文件 
               */  
              basePath = (basePath.length() == 0 ? "" : basePath + "/")  
                      + file.getName();  
              output.putNextEntry(new ZipEntry(basePath));  
              input = new FileInputStream(file);  
              int readLen = 0;  
              byte[] buffer = new byte[1024 * 8];  
              while ((readLen = input.read(buffer, 0, 1024 * 8)) != -1)  
                  output.write(buffer, 0, readLen);  
          }  
      } catch (Exception ex) {  
//          logger.error("zip file [ " + file + " ] error.", ex);  
          throw new RuntimeException("zip file [ " + file + " ] error.", ex);  
      } finally {  
          /** 
           * 关闭流 
           */  
          if (input != null)  
              input.close();  
      }  
  } 
  
  /**
   * 功能：保存文件夹 
   * @author Alex
   * @param folderPath
   * @param saveName
   * @return
   * 创建时间：2011-12-2 下午05:11:17
   */
  public static String saveZip(String folderPath,String saveName){
	  String result = "success";
	  FileOutputStream fos = null;
      BufferedOutputStream bos = null;
      ZipOutputStream zos = null;//压缩包
      
		try {
			 fos = new FileOutputStream(saveName);
			 bos = new BufferedOutputStream(fos);
		     zos = new ZipOutputStream(bos);
		     zipFolder(zos,new File(folderPath),folderPath);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				  if(zos!=null) zos.close(); 
				  if(fos!=null) fos.close();
				  if(bos!=null) bos.close();
				}catch (Exception e) {
					e.printStackTrace();
					result = "error";
				}
		}
	  return result;
  }
  
  public static void convert(String source, String formatName, String result)  throws Exception
  {  
       
          File f = new File(source);  
          f.canRead();  
          BufferedImage src = ImageIO.read(f);  
          ImageIO.write(src, formatName, new File(result));  
      
  }  
  
  /**
   * 将long 型时间转换成需要的时间格式字符传
   * @param value
   * @param formModel
   * @return
   */
  
  public static String format(long value,String formModel) {
		Date date = new Date(value);
		SimpleDateFormat format = new SimpleDateFormat(formModel);
		String formatDate = format.format(date);

		return formatDate;
	} 
  
  /**
   * @Description: 过滤特殊字符
   * @author:longm
   * @date: 2013-10-8 下午06:31:07
   */
  public static String encode4Html(String value){
	  value = notNull(value);
	  if(value.equals(""))return "";
	  StringBuffer result = new StringBuffer();
	  for (int i = 0; i < value.length(); i++) {
		  char ch = value.charAt(i);
		  if (ch == '<')
		  result.append("&lt;");
		  else if (ch == '&')
		  result.append("&amp;");
		  else if(ch == '>')
		  result.append("&gt;");  
//		  else if (ch == '"')
//		  result.append("&quot;");
//		  else if (ch == '\r')
//		  result.append("<BR>");
//		  else if (ch == '\n') {
//		  if (value.charAt(i - 1) == '\r') {
//		  } else
//		  result.append("<BR>");
//		  } else if (ch == '\t')
//		  result.append("&nbsp;&nbsp;&nbsp;&nbsp");
//		  else if (ch == ' ')
//		  result.append("&nbsp;");
		  else if (ch == '$')
		  result.append("$$");
		  else
		  result.append(ch);
	  }
	  return result.toString();
  }
  
  /**
   * @Description: 验证是否为空 
   * @author:longm
   * @date: 2013-10-8 下午06:33:26
   */
  public static String notNull(Object s) {
	  if (s instanceof String) {
	  if (s == null || s.toString().trim().equals("")) {
	  return "";
	  } else {
	  return s.toString().trim();
	  }
	  } else if (s instanceof Integer) {
	  if (s == null) {
	  return "";
	  } else {
	  return s.toString();
	  }
	  } else {
	  return "";
	  }
	  }
  
  /**
   * @Description:截取字符串 回避汉字 
   * @author:longm
   * @date: 2013-10-8 下午06:47:29
   */
  public static String gxsubstring(String str,int num){
	  char[] charArray = str.toCharArray();
	  String subStr = "";
	  int index = 0;
	  for (int i = 0, j = 0; i < num;) {
	    char tempchar = charArray[j];
	    if (Character.getType(tempchar) == Character.OTHER_LETTER) {
	       i = i + 2;
	       if (i > num) {
	         if (i == (num + 1)) {
	           continue;
	         }
	        }
	      }
	      else {
	        i++;
	      }
	      index++;
	      j++;
	    }
	    subStr = str.substring(0, index);
	    return subStr;
  }
  
  /**
   * 验证手机号是否有效 
   * @author: Rocye
   * @createTime: 2015-07-06
   */
  public static boolean chkMobileIsEffect(String mobile){
      return mobile.matches("(13[0-9]|15[0-9]|18[0-9]|17[0-9]|14[0-9])[0-9]{8}");
  }
  
  /**
   * 计算短信内容所需条数（单条短信最大字节数134）
   * @author: Rocye
   * @createTime: 2015-07-13
   */
  public static int getSmsLengthByContent(String content){
      content = content.replaceAll("[^\\x00-\\xff]", "xx");
      int len = content.length();
      return len/134 + (len%134 > 0 ? 1 : 0);
  }
  
  public static void main(String[] args) {
	System.out.println(getUUID());
}
}
