package com.guoxin.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;


/**
 * 与时间日期相关的工具类
 * @version 2017-03-22
 * @author liuk
 */
public class DateUtil {
    /** 日志对象 */
    private static final Logger logger = Logger.getLogger(DateUtil.class.getName());
    /** 时间格式 yyyy-MM-dd HH:mm:ss */
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /** 时间格式 yyyy-MM-dd */
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    /** 时间格式 yyyy/MM/dd HH:mm:ss */
    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    /** 时间格式 yyyy/MM/dd */
    private static final SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy/MM/dd");
    /** 时间格式 yyyy-MM-dd HH:mm */
    private static final SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    /** 时间格式 yyyy/MM/dd HH:mm */
    private static final SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    /** 时间格式 yyyyMMdd */
    private static final SimpleDateFormat sdf7 = new SimpleDateFormat("yyyyMMdd");
    /** 时间格式 yyyy-MM-dd HH:mm, Locale.CHINESE*/
    private static final SimpleDateFormat sdf8 =  new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.CHINESE);
    
    /**
     * 正则表达示解析
     * @param str 日期字符串
     * @return 日期{@link Date}
     */
    public static Date parse(String str) {
        Date date = null;
        Pattern p1 = Pattern.compile("^\\d{2,4}\\-\\d{1,2}\\-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
        Matcher m1 = p1.matcher(str);
        Pattern p2 = Pattern.compile("^\\d{2,4}\\-\\d{1,2}\\-\\d{1,2}$");
        Matcher m2 = p2.matcher(str);
        Pattern p3 = Pattern.compile("^\\d{2,4}\\/\\d{1,2}\\/\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
        Matcher m3 = p3.matcher(str);
        Pattern p4 = Pattern.compile("^\\d{2,4}\\/\\d{1,2}\\/\\d{1,2}$");
        Matcher m4 = p4.matcher(str);
        Pattern p5 = Pattern.compile("^\\d{2,4}\\-\\d{1,2}\\-\\d{1,2} \\d{1,2}:\\d{1,2}$");
        Matcher m5 = p5.matcher(str);
        Pattern p6 = Pattern.compile("^\\d{2,4}\\/\\d{1,2}\\/\\d{1,2} \\d{1,2}:\\d{1,2}$");
        Matcher m6 = p6.matcher(str);
        Pattern p7 = Pattern.compile("^\\d{2,4}\\d{1,2}\\d{1,2}$");
        Matcher m7 = p7.matcher(str);
        Pattern p8 = Pattern.compile("^\\d{1,2}-\\d{1,2} +(([1-9]{1})|([0-1][0-9])|([1-2][0-3])):([0-5][0-9])$"); //12-12 00:00
        Matcher m8 = p8.matcher(str);
        
        try {
            if (m1.matches())
                date = sdf1.parse(str);
            else if (m2.matches())
                date = sdf2.parse(str);
            else if (m3.matches())
                date = sdf3.parse(str);
            else if (m4.matches())
                date = sdf4.parse(str);
            else if (m5.matches())
                date = sdf5.parse(str);
            else if (m6.matches())
                date = sdf6.parse(str);
            else if (m7.matches())
                date = sdf7.parse(str);
            else if (m8.matches()){
            	Calendar cal = Calendar.getInstance();
            	int year = cal.get(Calendar.YEAR);
            	str = year+"-"+str;
            	date = sdf8.parse(str);
            }
        } catch (ParseException e) {
            logger.error(e.getMessage());
            return null;
        }
        return date;
    }

    /**
     * 格式化 yyyy-MM-dd HH:mm:ss
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyy-MM-dd HH:mm:ss
     */
    public static String format1(Date date) {
        return sdf1.format(date);
    }
    
    /**
     * 格式化 yyyy-MM-dd
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyy-MM-dd
     */
    public static String format2(Date date) {
        return sdf2.format(date);
    }
    
    /**
     * 格式化 yyyy/MM/dd HH:mm:ss
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyy/MM/dd HH:mm:ss
     */
    public static String format3(Date date) {
        return sdf3.format(date);
    }
    
    /**
     * 格式化yyyy/MM/dd
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyy/MM/dd
     */
    public static String format4(Date date) {
        return sdf4.format(date);
    }
    
    /**
     * 格式化 yyyy-MM-dd HH:mm
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyy-MM-dd HH:mm
     */
    public static String format5(Date date) {
        return sdf5.format(date);
    }
    
    /**
     * 格式化 yyyy/MM/dd HH:mm
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyy/MM/dd HH:mm
     */
    public static String format6(Date date) {
        return sdf6.format(date);
    }
    
    /**
     * 格式化 yyyyMMdd
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyyMMdd
     */
    public static String format7(Date date) {
        return sdf7.format(date);
    }

    /**
     * 格式化 MM-dd HH:mm
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:MM-dd HH:mm
     */
    public static String format8(Date date) {
        return sdf8.format(date);
    }
    
    /**
     * 格式化指定的格式
     * @param date 		日期 {@link Date}
     * @param pattern  	日期格式字符串
     * @return 时间字符串 
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 判断传入的Long时间是否当前月
     * @param time	时间戳 
     * @return true or false
     */
    public static boolean isNowMonthTime(Long time) {
        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);
        int nowMonth = calendar.get(Calendar.MONTH);
        calendar.setTime(new Date(time));
        if(nowYear == calendar.get(Calendar.YEAR) && nowMonth == calendar.get(Calendar.MONTH)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 获取当前日期
     * @return
     */
    public static Timestamp nowTime(){
  	  return Timestamp.valueOf(DateUtil.format(new java.util.Date(),"yyyy-MM-dd HH:mm:ss"));
    }
    
    /**
     * 正则表达式解析 (直接取时间日期中匹配的正则表达式的那一部分)
     *(注：年份为4位和2位的必须使用不同的SimpleDateFormat变成Date，否则最终格式化的结果年份会有问题)
     */
    public static Date parse2(String str) {
        Date date = null;
        str = str.replaceAll("时|分|秒",":");
        Pattern p1 = Pattern.compile("\\d{4}\\-\\d{1,2}\\-\\d{1,2}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}");
        Matcher m1 = p1.matcher(str);
        Pattern p2 = Pattern.compile("\\d{4}\\-\\d{1,2}\\-\\d{1,2}");
        Matcher m2 = p2.matcher(str);
        Pattern p3 = Pattern.compile("\\d{4}\\/\\d{1,2}\\/\\d{1,2}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}");
        Matcher m3 = p3.matcher(str);
        Pattern p4 = Pattern.compile("\\d{4}\\/\\d{1,2}\\/\\d{1,2}");
        Matcher m4 = p4.matcher(str);
        Pattern p5 = Pattern.compile("\\d{4}\\-\\d{1,2}\\-\\d{1,2}\\s*\\d{1,2}:\\d{1,2}");
        Matcher m5 = p5.matcher(str);
        Pattern p6 = Pattern.compile("\\d{4}\\/\\d{1,2}\\/\\d{1,2}\\s*\\d{1,2}:\\d{1,2}");
        Matcher m6 = p6.matcher(str);
        Pattern p8 = Pattern.compile("\\d{1,2}-\\d{1,2} +(([1-9]{1})|([0-1][0-9])|([1-2][0-3])):([0-5][0-9])"); //12-12 00:00
        Matcher m8 = p8.matcher(str);
        Pattern p9 = Pattern.compile("\\d{4}\\s*年\\s*\\d{1,2}\\s*月\\s*\\d{1,2}\\s*日\\s*\\d{1,2}:\\d{1,2}");
        Matcher m9 = p9.matcher(str);
        Pattern p10 = Pattern.compile("\\d{4}\\s*年\\s*\\d{1,2}\\s*月\\s*\\d{1,2}\\s*日\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}");
        Matcher m10 = p10.matcher(str);
        
        Pattern p11 = Pattern.compile("\\d{2}\\-\\d{1,2}\\-\\d{1,2}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}");
        Matcher m11 = p11.matcher(str);
        Pattern p21 = Pattern.compile("\\d{2}\\-\\d{1,2}\\-\\d{1,2}");
        Matcher m21 = p21.matcher(str);
        Pattern p31 = Pattern.compile("\\d{2}\\/\\d{1,2}\\/\\d{1,2}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}");
        Matcher m31 = p31.matcher(str);
        Pattern p41 = Pattern.compile("\\d{2}\\/\\d{1,2}\\/\\d{1,2}");
        Matcher m41 = p41.matcher(str);
        Pattern p51 = Pattern.compile("\\d{2}\\-\\d{1,2}\\-\\d{1,2}\\s*\\d{1,2}:\\d{1,2}");
        Matcher m51 = p51.matcher(str);
        Pattern p61 = Pattern.compile("\\d{2}\\/\\d{1,2}\\/\\d{1,2}\\s*\\d{1,2}:\\d{1,2}");
        Matcher m61 = p61.matcher(str);
        Pattern p91 = Pattern.compile("\\d{2}\\s*年\\s*\\d{1,2}\\s*月\\s*\\d{1,2}\\s*日\\s*\\d{1,2}:\\d{1,2}");
        Matcher m91 = p91.matcher(str);
        Pattern p101 = Pattern.compile("\\d{2}\\s*年\\s*\\d{1,2}\\s*月\\s*\\d{1,2}\\s*日\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}");
        Matcher m101 = p101.matcher(str);
        Pattern p102 = Pattern.compile("\\d{1,2}\\s*月\\s*\\d{1,2}\\s*日\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}");
        Matcher m102 = p102.matcher(str);
        Pattern p103 = Pattern.compile("\\d{1,2}\\s*月\\s*\\d{1,2}\\s*日\\s*\\d{1,2}:\\d{1,2}");
        Matcher m103 = p103.matcher(str);
        
        Pattern p12 = Pattern.compile("\\d{1,2}\\/\\d{1,2}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}");
        Matcher m12 = p12.matcher(str);
        Pattern p13 = Pattern.compile("\\d{1,2}\\/\\d{1,2}\\s*\\d{1,2}:\\d{1,2}");
        Matcher m13 = p13.matcher(str);
        try{
        	if (m1.find()){
        		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        		date = sdf1.parse(m1.group());
        	}else if (m3.find()){
        		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        		date = sdf3.parse(m3.group());
        	}else if (m5.find()){
        		SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        		date = sdf5.parse(m5.group());
        	}else if (m6.find()){
        		SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        		date = sdf6.parse(m6.group());
        	}else if (m9.find()){
    			SimpleDateFormat sdf9 = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
    			date = sdf9.parse(m9.group().replaceAll("\\s*", ""));
    		}else if (m10.find()){
    			SimpleDateFormat sdf10 = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
    			date = sdf10.parse(m10.group().replaceAll("\\s*", ""));
    		}else if (m11.find()){
    			SimpleDateFormat sdf11 = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    			date = sdf11.parse(m11.group());
    		}else if (m31.find()){
    			SimpleDateFormat sdf31 = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
    			date = sdf31.parse(m31.group());
    		}else if (m51.find()){
    			SimpleDateFormat sdf51 = new SimpleDateFormat("yy-MM-dd HH:mm");
    			date = sdf51.parse(m51.group());
    		}else if (m61.find()){
    			SimpleDateFormat sdf61 = new SimpleDateFormat("yy/MM/dd HH:mm");
    			date = sdf61.parse(m61.group());
    		}else if (m8.find()){
    			Calendar cal = Calendar.getInstance();
            	int year = cal.get(Calendar.YEAR);
            	String sTime = year+"-"+m8.group();
            	SimpleDateFormat sdf8 =  new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.CHINESE);	
    			date = sdf8.parse(sTime);
    		}else if (m91.find()){
    			SimpleDateFormat sdf91 = new SimpleDateFormat("yy年MM月dd日HH:mm");
    			date = sdf91.parse(m91.group().replaceAll("\\s*", ""));
    		}else if (m101.find()){
    			SimpleDateFormat sdf101 = new SimpleDateFormat("yy年MM月dd日HH:mm:ss");
    			date = sdf101.parse(m101.group().replaceAll("\\s*", ""));
    		}else if (m102.find()){
    			Calendar cal = Calendar.getInstance();
            	int year = cal.get(Calendar.YEAR);
            	String sTime = year+"年"+m102.group().replaceAll("\\s*", "");
            	SimpleDateFormat sdf10 = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
            	date = sdf10.parse(sTime);
    		}else if (m103.find()){
    			Calendar cal = Calendar.getInstance();
    			int year = cal.get(Calendar.YEAR);
    			String sTime = year+"年"+m103.group().replaceAll("\\s*", "");
    			SimpleDateFormat sdf9 = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
    			date = sdf9.parse(sTime);
    		}else if (m12.find()){
    			Calendar cal = Calendar.getInstance();
            	int year = cal.get(Calendar.YEAR);
            	String sTime = year+"/"+m12.group();
            	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    			date = sdf3.parse(sTime);
    		}else if (m13.find()){
    			Calendar cal = Calendar.getInstance();
    			int year = cal.get(Calendar.YEAR);
    			String sTime = year+"/"+m13.group();
    			SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    			date = sdf6.parse(sTime);
    		}else if(m21.find()){
    			SimpleDateFormat sdf21 = new SimpleDateFormat("yy-MM-dd");
    			date = sdf21.parse(m21.group());
    		}else if(m2.find()){
    			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    			date = sdf2.parse(m2.group());
    		}else if(m41.find()){
    			SimpleDateFormat sdf41 = new SimpleDateFormat("yy/MM/dd");
    			date = sdf41.parse(m41.group());
    		}else if(m4.find()){
    			SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy/MM/dd");
    			date = sdf4.parse(m4.group());
    		}
        } catch (ParseException e) {
            logger.error("时间格式化出错!", e);
        }
        return date;
    }
    
    /**
     * 
     * 入库前要将判断时期是否为有效格式(yyyy-MM-dd HH:mm:ss)
     * @param formModel
     * @return
     */
    public static Timestamp getValidTimestamp(String formModel) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String reTime = format.format(new Date()); 
    	Date date = DateUtil.parse2(formModel);
    	if(date != null)
    		reTime = format.format(date);
    	return Timestamp.valueOf(reTime);
    }
    
    
    /**
     * 根据提供的关键字确定日期，如“昨天”,"今天"，“前天”，“10-05”，这样的日期
     * @param date
     * @return
     */
	public static String getValidChangeDate(String date) {
		Calendar cal=Calendar.getInstance();
		Pattern p1 = Pattern.compile("\\d{2}\\-\\d{2}");
		Matcher m1 = p1.matcher(date);
		if(date!= null && !"".equals(date)){
			if("昨天".equals(date)){
				cal.add(Calendar.DATE,-1);
			    Date d=cal.getTime();
				SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
				String zuotian=sp.format(d);//获取昨天日期
				return zuotian;
			}else if("前天".equals(date)){
				cal.add(Calendar.DATE,+1);
			    Date d=cal.getTime();
				SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
				String qiantian=sp.format(d);//获取前天日期
				return qiantian;
			}else if(m1.find()){
				int year = cal.get(Calendar.YEAR);
				date = year+"-"+date;
				return date;
			}else if(date.contains("小时前")){
				Calendar c = Calendar.getInstance();
				String [] val=date.split("小时前");
				String dates=val[0].trim();
				int i=Integer.parseInt(dates);
				c.setTime(new Date());
				c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) - i);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				date=df.format(c.getTime());
				return date;
			}else{
			    Date d=cal.getTime();
				SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
				String today=sp.format(d);//获取前天日期
				return today;
			}
		}else{
			Date d=cal.getTime();
			SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
			String today=sp.format(d);//获取前天日期
			return today;
		}
		
	}
	
	/**
     * 
     * 入库前要将判断时期是否为有效格式(yyyy-MM-dd HH:mm:ss)
     * @param formModel
     * @return
     */
    public static String getValidDate(String formModel) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String reTime = format.format(new Date()); 
		Date date = DateUtil.parse2(formModel);
		if(date != null)
			reTime = format.format(date);
		return reTime;

	}
    
    /**
     * 判断当前时间是否在指定区间
     * @param date
     * @param strDateBegin
     * @param strDateEnd
     * @return
     */
    public static boolean isInDate(Date date, String strDateBegin,  
            String strDateEnd) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String strDate = sdf.format(date);  
        // 截取当前时间时分秒  
        int strDateH = Integer.parseInt(strDate.substring(11, 13));  
        int strDateM = Integer.parseInt(strDate.substring(14, 16));  
        int strDateS = Integer.parseInt(strDate.substring(17, 19));  
        // 截取开始时间时分秒  
        int strDateBeginH = Integer.parseInt(strDateBegin.substring(0, 2));  
        int strDateBeginM = Integer.parseInt(strDateBegin.substring(3, 5));  
        int strDateBeginS = Integer.parseInt(strDateBegin.substring(6, 8));  
        // 截取结束时间时分秒  
        int strDateEndH = Integer.parseInt(strDateEnd.substring(0, 2));  
        int strDateEndM = Integer.parseInt(strDateEnd.substring(3, 5));  
        int strDateEndS = Integer.parseInt(strDateEnd.substring(6, 8));  
        if ((strDateH >= strDateBeginH && strDateH <= strDateEndH)) {  
            // 当前时间小时数在开始时间和结束时间小时数之间  
            if (strDateH > strDateBeginH && strDateH < strDateEndH) {  
                return true;  
                // 当前时间小时数等于开始时间小时数，分钟数在开始和结束之间  
            } else if (strDateH == strDateBeginH && strDateM >= strDateBeginM  
                    && strDateM <= strDateEndM) {  
                return true;  
                // 当前时间小时数等于开始时间小时数，分钟数等于开始时间分钟数，秒数在开始和结束之间  
            } else if (strDateH == strDateBeginH && strDateM == strDateBeginM  
                    && strDateS >= strDateBeginS && strDateS <= strDateEndS) {  
                return true;  
            }  
            // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数小等于结束时间分钟数  
            else if (strDateH >= strDateBeginH && strDateH == strDateEndH  
                    && strDateM <= strDateEndM) {  
                return true;  
                // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数等于结束时间分钟数，秒数小等于结束时间秒数  
            } else if (strDateH >= strDateBeginH && strDateH == strDateEndH  
                    && strDateM == strDateEndM && strDateS <= strDateEndS) {  
                return true;  
            } else {  
                return false;  
            }  
        } else {  
            return false;  
        }  
    }
    
    /**
     * 获取当前日期是星期几<br>
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    
    public static void main(String[] args) {
    	Calendar calendar = new GregorianCalendar();
    	calendar.setTime(new Date()); 
    	calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
		System.out.println(format2(calendar.getTime()));
	}
}