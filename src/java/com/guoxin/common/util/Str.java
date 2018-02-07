package com.guoxin.common.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Str 用于对字符串的一些处理,如去空,截串,日期转换,乱码转换,转&nbsp; Str.java 对类的描述 1.public static
 * String ntrim(String str) 去空 2.public static String subHead(String
 * sourceStr,String mark) 以mark为分隔符, 截取第一个mark前的所有字符 (截头) 3.public static String
 * subTail(String sourceStr,String mark) 以mark为分隔符,截取最后一个mark后的所有字符 (截尾)
 * 4.public static String toUTF8(String sourceStr) 转成UTF-8 5.public static
 * String toGBK(String sourceStr) 转成GBK 6.public static String toNbsp(String
 * sourceStr) 空转&nbsp; 7.public static String toFmtDateStr(Date date,String
 * patternt) 转日期为美化字符串 8.public static Date toDate(String dateStr,String
 * pattern) 转美化字符串为日期 9.public static String trimHeadTailComma(String sourceStr)
 * 去除字符串首尾逗号空格 10.public static String trimHeadTail(String sourceStr,String
 * trimStr) 去除首尾trimStr字符串 11.public static String numToStr(int value,String
 * labels) 将数值换成相应中文显示 12.public static String toHttpUrl(String url)
 * 检查传入的url最前面是否有 “http://” 字符串，如果没有，则增加 13.public static String toFileSize(long
 * fileSizeBytes) 转成 MB 或 KB 结尾的美化字符串 14.public static String strToStr(String
 * simpleSource,String keys,String values) 以枚举形式，将字符串替换成指定字符串 15.public static
 * String getSuffixPicName(String fileName) 得到文件后缀的名称(PNG图片)
 * 
 * @author
 * @version 1.1
 * @date 2009-3-6
 */
public class Str {
	public Str() {

	}
	
	/**
	 * 讲null转成""空字符串ֵ
	 * 
	 * @param tempString
	 *            String
	 * @return String
	 */
	public static String changeNull(String tempString) {
		String result = "";
		if (tempString != null) {
			result = tempString.trim();
		}
		return result;
	}

	// HTML filters
	public static String HTMLFilter(String value) {
		if (value == null) {
			return (null);
		}
		char content[] = new char[value.length()];
		value.getChars(0, value.length(), content, 0);
		StringBuffer result = new StringBuffer(content.length + 50);
		boolean usenbsp = false;

		for (int i = 0; i < content.length; i++) {
			switch (content[i]) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			case '\'':
				result.append("&#39;");
				break;
			case '\n':
				result.append("<br>");
				break;
			case ' ':
				if (i > 0 && content[i - 1] == ' ' && usenbsp == false) {
					result.append("&nbsp;");
					usenbsp = true;
				} else {
					result.append(" ");
					usenbsp = false;
				}
				break;
			case '\r':
				break;
			default:
				result.append(content[i]);
			}
		}
		return (result.toString());
	}

	/**
	 * 截取前面前面N个字符+"...."
	 * 
	 * @param value
	 *            String
	 * @param maxlen
	 *            int
	 * @return String
	 */
	public static String stringFilter(String value, int maxlen) {
		String result = value;
		if (value.length() > maxlen) {
			result = value.substring(0, maxlen - 1) + "...";
		}
		return result;
	}

	/**
	 * 将float类型格式化成钱的String格式
	 * 
	 * @param value
	 *            double
	 * @return String
	 */
	public static String moneyFilter(float value) {
		DecimalFormat fmt = new DecimalFormat("#########0.00");
		return fmt.format(value);
	}

	/**
	 * 将指定字符串的第一个所要替换的字串，替换成所想要的字串
	 * 
	 * @author
	 * @date 2009-11-4
	 * @param source
	 * @param existsStr
	 * @param targetStr
	 * @return
	 */
	public static String replaceFirstStr(String source, String existsStr,
			String targetStr) {
		if (source == null) {
			return null;
		}
		int index = source.indexOf(existsStr);
		if (index != -1) {
			StringBuffer sb = new StringBuffer(source);
			sb.replace(index, index + existsStr.length(), targetStr);
			source = sb.toString();
		}
		return source;
	}

	/**
	 * 将指定字符串的所有要替换的字串，替换成所想要的字串
	 * 
	 * @author
	 * @date 2009-11-4
	 * @param source
	 * @param existsStr
	 * @param targetStr
	 * @return
	 */
	public static String replaceAllStr(String source, String existsStr,
			String targetStr) {
		if (source == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer(source);
		int startInd = source.indexOf(existsStr, 0);
		;
		while (startInd != -1) {
			sb.replace(startInd, startInd + existsStr.length(), targetStr);
			startInd = sb.indexOf(existsStr, startInd + targetStr.length());
		}
		return sb.toString();
	}

	/**
	 * 将空字串，替成替换成指定文字
	 * 
	 * @author
	 * @date 2009-10-23
	 * @param source
	 *            源字串
	 * @param s
	 *            空替换的字串
	 * @return 非空，则直接返回
	 */
	public static String emptyToStr(String source, String s) {
		return "".equals(Str.ntrim(source)) ? s : source;
	}

	/**
	 * 根据 map 的 key ，获取该 key 所对应的 map 值
	 * 
	 * @author
	 * @date 2009-10-14
	 * @param key
	 *            键名
	 * @param map
	 *            装值 map
	 * @return 所需的值
	 */
	public static String keyInMap(String key, Map map) {
		String s = "";
		if (map != null && !map.isEmpty()) {
			if (map.containsKey(key)) {
				Object obj = map.get(key);
				if (obj != null) {
					s = obj.toString();
				}
			}
		}
		return s;
	}

	/**
	 * 获取查询 like 字串,如果字串为 "" 或 null，则返回 null,否则返回 “%QryStr%”
	 * 
	 * @author
	 * @date 2009-10-14
	 * @param s
	 * @return
	 */
	public static String nullLike(String s) {
		s = Str.ntrim(s);
		return ("".equals(s)) ? null : "%" + s + "%";
	}

	/**
	 * 与 ntrim 刚好相反，使 "" 转为 NULL
	 * 
	 * @author
	 * @date 2009-10-14
	 * @param s
	 *            源
	 * @return 目标
	 */
	public static String trimToNull(String s) {
		s = Str.ntrim(s);
		return "".equals(s) ? null : s;
	}

	/**
	 * 将传入的字符串,使 NULL 变成 "",使非 Null 的字符串去掉首尾空格后返回 例: String s = " abc "; s =
	 * Str.ntrim(s); //此时 s 值为 "abc" s = null; s = Str.ntrim(s); //此时 s 值为 "";
	 * 
	 * 例: if("add".equals(Str.ntrim(actionName))) { ... }
	 * 
	 * @author
	 * @date 2009-3-6
	 * @param str
	 *            所要进行处理的字符串
	 * @return 处理后的字符串
	 */
	public static String ntrim(String str) {
		return (str == null) ? "" : str.trim();
	}

	public static String ntrim(Object sobj) {
		return (sobj == null) ? "" : sobj.toString().trim();
	}

	/**
	 * 截取 sourceStr 字符串中第一个 mark 字符前的所有字符串(不含 mark) 例: String fileName =
	 * "emap_4325234523.gif"; fileName = Str.subHead(fileName,"."); //此时
	 * fileName 为 "emap_4325234523"
	 * 
	 * @author
	 * @date 2009-3-6
	 * @param sourceStr
	 *            所要处理的字符串
	 * @param mark
	 *            用作标记基准的字符串
	 * @return 处理后的字符串
	 */
	public static String subHead(String sourceStr, String mark) {
		String str = "";
		if (sourceStr == null || mark == null) {
			return str;
		}
		if ("".equals(mark)) {
			str = sourceStr;
		} else if (sourceStr.indexOf(mark) != -1) // 包含
		{
			str = sourceStr.substring(0, sourceStr.indexOf(mark));
		}
		return str;
	}

	/**
	 * 截取 sourceStr 字符串中最后一个 mark 字符前的所有字符串(不含 mark) 例: String fileName =
	 * "/upload/32452432/emap_4325234523.gif"; fileName =
	 * Str.subTail(fileName,"/"); //截尾,此时 fileName 为 "emap_4325234523.gif"
	 * fileName = Str.subHead(fileName,"."); //截头,此时 fileName 为
	 * "emap_4325234523"
	 * 
	 * @author
	 * @date 2009-3-6
	 * @param sourceStr
	 *            所要处理的字符串
	 * @param mark
	 *            用作标记基准的字符串
	 * @return 处理后的字符串
	 */
	public static String subTail(String sourceStr, String mark) {
		String str = "";
		if (sourceStr == null || mark == null) {
			return str;
		}
		if ("".equals(mark)) {
			str = sourceStr;
		} else if (sourceStr.lastIndexOf(mark) != -1) // 包含
		{
			str = sourceStr.substring(sourceStr.lastIndexOf(mark) + 1);
		}
		return str;
	}

	/**
	 * 将乱码字符串转成 UTF-8 例: String s = "?????"; //str 为乱码,页面上为 utf-8 字符集 s =
	 * Str.toUTF8(s); //转字符串为 utf-8
	 * 
	 * @author
	 * @date 2009-3-10
	 * @param sourceStr
	 *            要处理的字符串
	 * @return 转码后的字符串
	 */
	public static String toUTF8(String sourceStr) {
		try {
			sourceStr = Str.ntrim(sourceStr);
			return new String(sourceStr.getBytes("iso-8859-1"), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 将乱码字符串转成 GBK 例: String s = "?????"; //str 为乱码,页面上为 GBK 字符集 s =
	 * Str.toGBK(s); //转字符串为 GBK
	 * 
	 * @author
	 * @date 2009-3-10
	 * @param sourceStr
	 *            要处理的字符串
	 * @return 转码后的字符串
	 */
	public static String toGBK(String sourceStr) {
		try {
			sourceStr = Str.ntrim(sourceStr);
			return new String(sourceStr.getBytes("iso-8859-1"), "gbk");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 将传入的字符串进行 HTML 空格转换,如果该字符串为空格 或 null 或 "",则转成 &nbsp;
	 * 所用之处:页面上输出时,空字符不撑单元格,影响页面美观,需用 &nbsp; 撑单元格 例: String s = ""; s =
	 * Str.toNbsp(s); //此时 s 为 "&nbsp;"
	 * 
	 * s = null; s = Str.toNbsp(s); //此时 s 为 "&nbsp;"
	 * 
	 * s = " "; s = Str.toNbsp(s); //此时 s 为 "&nbsp;"
	 * 
	 * s = " abc "; s = Str.toNbsp(s); //此时 s 为 "abc"
	 * 
	 * @author
	 * @date 2009-3-10
	 * @param sourceStr
	 *            要处理的字符串
	 * @return 处理后的 html 空格转换码
	 */
	public static String toNbsp(String sourceStr) {
		sourceStr = Str.ntrim(sourceStr);
		return "".equals(sourceStr) ? "&nbsp;" : sourceStr;
	}

	/**
	 * 美化日期输出成指定格式的字符串 例: Date date = new Date(); //当前时间 String dateStr =
	 * Str.toFmtDateStr(date,'yyyy-MM-dd'); //此时 dateStr 为 "2009-03-10" 格式
	 * dateStr = Str.toFmtDateStr(date,'yyyy 年 MM 月 dd 日'); //此时 dateStr 为 "2009
	 * 年 03 月 10 日" 格式 dateStr = Str.toFmtDateStr(date,'hh:mm:ss'); //此时 dateStr
	 * 为 "17:13:33" 时间格式 dateStr = Str.toFmtDateStr(date,'yyyy-MM-dd hh:mm:ss');
	 * //此时 dateStr 为 "2009-03-10 17:13:33" 时间格式
	 * 
	 * @author
	 * @date 2009-3-10
	 * @param date
	 *            所要处理的日期
	 * @param patternt
	 *            日期格式
	 * @return 美化成的日期字符串
	 */
	public static String toFmtDateStr(Date date, String patternt) {
		SimpleDateFormat fmt = new SimpleDateFormat(patternt);
		return fmt.format(date);
	}

	/**
	 * 根据具有一定规的字符串,转换成 Date 类型 例: String sd = " 2009-1-5 " Date date; date =
	 * Str.toDate(ds,""yyyy-M-d); //此时日期转成 Date 型 sd = " 2009-1-5 12:33:15";
	 * date = Str.toDate(ds,"yyyy-M-d hh:mm:ss"); //此时日期转成 Date 型
	 * 
	 * @author
	 * @date 2009-3-10
	 * @param dateStr
	 *            要处理的字符串
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static Date toDate(String dateStr, String pattern) {
		try {
			SimpleDateFormat fmt = new SimpleDateFormat(pattern);
			dateStr = Str.ntrim(dateStr);
			return fmt.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 去除字符串首尾的空格和逗号 在根据 ids 多删除时,处理 ids 十分有用 例: String ids = " , , ,2,3,5,15,
	 * 3, 100,,," ids = Str.trimHeadTailComma(ids); //此时 ids 为 "2,3,5,15, 3,
	 * 100" ids = ids.replaceAll(" ",""); //此时 ids 为 "2,3,5,15,3,100"
	 * 
	 * ids = " 'zhang','ya ng','li', " ids = Str.trimHeadTailComma(ids); //此时
	 * ids 为 "'zhang','ya ng','li'"
	 * 
	 * @author
	 * @date 2009-3-11
	 * @param sourceStr
	 * @return
	 */
	public static String trimHeadTailComma(String sourceStr) {
		return Str.trimHeadTail(sourceStr, ",");
	}

	/**
	 * 出除字符串 sourceStr 首尾的 trimStr 字符串,可以用于出除首尾的逗号,百分号等 例:String s =
	 * ",,,2,35,5,20, "; s = Str.trimHeadTail(s,","); //此时 s 为 "2,35,5,20" s = "%
	 * %%关键字% % %" s = Str.trimHeadTail(s,"%"); //此时 s 为 "关键字"
	 * 
	 * @author
	 * @date 2009-3-23
	 * @param sourceStr
	 *            要处理的字符串
	 * @param trimStr
	 *            首尾要去除的字符串
	 * @return
	 */
	public static String trimHeadTail(String sourceStr, String trimStr) {
		sourceStr = Str.ntrim(sourceStr);
		trimStr = Str.ntrim(trimStr);
		while (sourceStr.startsWith(trimStr) || sourceStr.endsWith(trimStr)) {
			sourceStr = (sourceStr.startsWith(trimStr)) ? sourceStr
					.substring(1) : sourceStr;
			sourceStr = (sourceStr.endsWith(trimStr)) ? sourceStr.substring(0,
					sourceStr.length() - 1) : sourceStr;
			sourceStr = sourceStr.trim();
		}
		return sourceStr;
	}

	/**
	 * 使值为 value 的数据转成与之对应的中文描述 label
	 * 
	 * @author
	 * @date 2009-3-11
	 * @param value
	 *            数值数据
	 * @param minValue
	 *            该 value 最小的值
	 * @param labels
	 *            以 regex 进行分隔的 label 字符串集
	 * @param regex
	 *            用于标识 label 的分隔符
	 * @return 处理后的字符串
	 */
	public static String numToStr(int value, int minValue, String labels,
			String regex) {
		try {
			labels = Str.ntrim(labels);
			String[] txts = labels.split(regex);
			return txts[value - minValue];
		} catch (NumberFormatException e) {
			return "";
		}
	}

	/**
	 * 重载方法,使值为 value 的数据转成与之对应的中文描述 label
	 * 
	 * @author
	 * @date 2009-3-11
	 * @param index
	 *            当前该值的下标
	 * @param labels
	 *            以 regex 进行分隔的 label 字符串集
	 * @param regex
	 *            用于标识 label 的分隔符
	 * @return 处理后的字符串
	 */
	public static String numToStr(int index, String labels, String regex) {
		try {
			labels = Str.ntrim(labels);
			String[] txts = labels.split(regex);
			return txts[index];
		} catch (NumberFormatException e) {
			return "";
		}
	}

	/**
	 * 重载方法,使值为 value 的数据转成与之对应的中文描述 label
	 * 
	 * @author
	 * @date 2009-3-11
	 * @param value
	 *            数值数据
	 * @param minValue
	 *            该 value 最小的值
	 * @param labels
	 *            以逗号进行分隔的 label 字符串集
	 * @return 处理后的字符串
	 */
	public static String numToStr(int value, int minValue, String labels) {
		try {
			labels = Str.ntrim(labels);
			String[] txts = labels.split(",");
			return txts[value - minValue];
		} catch (NumberFormatException e) {
			return "";
		}
	}

	/**
	 * 重载方法,使值为 value 的数据转成与之对应的中文描述 label
	 * 
	 * @author
	 * @date 2009-3-11
	 * @param index
	 *            数值数据
	 * @param labels
	 *            以逗号进行分隔的 label 字符串集
	 * @return 处理后的字符串
	 */
	public static String numToStr(int index, String labels) {
		try {
			labels = Str.ntrim(labels);
			String[] txts = labels.split(",");
			return txts[index];
		} catch (NumberFormatException e) {
			return "";
		}
	}

	/**
	 * 重载方法,使值为 value 的数据转成与之对应的中文描述 label
	 * 
	 * @author CLiang
	 * @date 2009-3-18
	 * @param index
	 *            字符串形式表示的数值数据
	 * @param labels
	 *            以逗号进行分隔的 label 字符串集
	 * @return 处理后的字符串
	 */
	public static String numToStr(String strIndex, String labels) {
		try {
			int index = Integer.parseInt(strIndex);
			return numToStr(index, labels);
		} catch (NumberFormatException e) {
			return "";
		}
	}

	/**
	 * 将字符串 simpleSource 替换成 values 中的指定的一部分字符串 如果 simpleSource 不在 keys 中，则返回 ""
	 * 如果 keys 中有重复的key,则以第一个出现的 key，value 对为准 如果 keys
	 * 中有的key，在values中没有对应的value,则返回 "" 例: String s = ""; s =
	 * Str.strToStr(s,"@","Apple@@Banana@Client", "苹果,水果,香蕉"); s = "Apple"; s =
	 * Str.strToStr(s,"@","Apple@@Banana@Client", "苹果,水果,香蕉"); s = "Balana"; s =
	 * Str.strToStr(s,"@","Apple@@Banana@Client", "苹果,水果,香蕉"); s = "Client"; s =
	 * Str.strToStr(s,"@","Apple@@Banana@Client", "苹果,水果,香蕉"); s = "XXXX"; s =
	 * Str.strToStr(s,"@","Apple@@Banana@Client", "苹果,水果,香蕉");
	 * 
	 * @author
	 * @date 2009-3-25
	 * @param simpleSource
	 *            要处理的字符串
	 * @param speratorChar
	 *            键值keys和values中字符串的分隔符
	 * @param keys
	 *            处理的字符串keys,以speratorChar隔开
	 * @param values
	 *            处理的字符串 values,以speratorChar隔开
	 * @return
	 */
	public static String strToStr(String simpleSource, String speratorChar,
			String keys, String values) {
		String str = "";
		try {
			keys = Str.ntrim(keys);
			values = Str.ntrim(values);
			String[] keys2 = keys.split(speratorChar);
			String[] values2 = values.split(speratorChar);
			int len = keys2.length;
			Map map = new HashMap();
			for (int i = 0; i < len; i++) {
				String key = Str.ntrim(keys2[i]);
				if (!map.containsKey(key)) {
					String value = (i < values2.length) ? Str.ntrim(values2[i])
							: "";
					map.put(key, value);
				}
			}
			simpleSource = Str.ntrim(simpleSource);
			if (map.containsKey(simpleSource)) {
				str = map.get(simpleSource).toString();
			}
		} catch (Exception e) {
			str = "";
		}
		return str;
	}

	/**
	 * 将字符串 simpleSource 替换成 values 中的指定的一部分字符串 如果 simpleSource 不在 keys 中，则返回 ""
	 * 如果 keys 中有重复的key,则以第一个出现的 key，value 对为准 如果 keys
	 * 中有的key，在values中没有对应的value,则返回 "" 例: String s = ""; s =
	 * Str.strToStr(s,"Apple,,Banana,Client", "苹果,水果,香蕉"); s = "Apple"; s =
	 * Str.strToStr(s,"Apple,,Banana,Client", "苹果,水果,香蕉"); s = "Balana"; s =
	 * Str.strToStr(s,"Apple,,Banana,Client", "苹果,水果,香蕉"); s = "Client"; s =
	 * Str.strToStr(s,"Apple,,Banana,Client", "苹果,水果,香蕉"); s = "XXXX"; s =
	 * Str.strToStr(s,"Apple,,Banana,Client", "苹果,水果,香蕉");
	 * 
	 * @author
	 * @date 2009-3-25
	 * @param simpleSource
	 *            要处理的字符串
	 * @param keys
	 *            处理的字符串keys,以逗号隔开
	 * @param values
	 *            处理的字符串 values,以逗号隔开
	 * @return
	 */
	public static String strToStr(String simpleSource, String keys,
			String values) {
		return Str.strToStr(simpleSource, ",", keys, values);
	}

	/**
	 * 
	 * 检查传入的url最前面是否有 “http://” 字符串，如果没有，则增加 原字符串中的 http 不区分大小写
	 * 
	 * @author CLiang
	 * @date 2009-3-12
	 * @param url
	 * @return
	 */
	public static String toHttpUrl(String url) {
		String tmpUrl = "http://";
		String regEx = "((?i)http)://";

		if (url != null) {
			url = url.trim();
			if (!"".equals(url)) {
				Pattern p = Pattern.compile(regEx);
				Matcher m = p.matcher(url);
				if (m.find()) {
					int index = m.start();
					if (index > 0) {
						tmpUrl += url;
					} else {
						tmpUrl = url;
					}
				} else {
					tmpUrl += url;
				}
			}
		}
		return tmpUrl;
	}

	/**
	 * 将以 byte 为单位的文件大小(byte)数值,转成 MB 或 KB 结尾的美化字符串
	 * 
	 * @author
	 * @date 2009-3-19
	 * @param fileSizeBytes
	 *            文件的大小 byte 数
	 * @return 美化的文件大小字符串
	 */
	public static String toFileSize(long fileSizeBytes) {
		String strSize = "0 byte";
		long kb = fileSizeBytes / 1024;
		if (kb <= 0) {
			strSize = fileSizeBytes + " byte";
		} else {
			long mb = fileSizeBytes / 1024 / 1024;
			if (mb <= 0) {
				strSize = ((long) (fileSizeBytes / 1024.0 * 100)) / 100.0
						+ " KB";
			} else {
				strSize = ((long) (fileSizeBytes / 1024.0 / 1024 * 100))
						/ 100.0 + " MB";
			}
		}
		return strSize;
	}

	/**
	 * 根据文件名,得到要在页面上显示的文件小图标名称
	 * 
	 * @author
	 * @date 2009-3-27
	 * @param fileName
	 *            含文件后缀的文件名
	 * @return 文件小图标名称
	 */
	public static String getSuffixPicName(String fileName) {
		String suffix = Str.ntrim(Str.subTail(fileName, "."));
		// 可用的后缀
		String[] includeSuffix = { "bmp", "gif", "jpg", "jpeg", "png", "rar",
				"doc", "pdf", "xls", "ppt", "txt", "exe", "htm", "html", "js",
				"css", "sql", "ssf", "mp3", "swf" };
		int len = includeSuffix.length;
		boolean flag = false; // 是否包含
		for (int i = 0; i < len; i++) {
			if (suffix.equalsIgnoreCase(includeSuffix[i])) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			suffix = "";
		}
		suffix += ".png";
		return suffix.toLowerCase();
	}

	public static void main(String[] args) {
		String s = "href='/abc.action' href='/123.action'";
		s = Str.replaceAllStr(s, "href='/", "href='http://192.168.0.172/pmk/");
		System.out.println("字串：" + s);
	}

	/**
	 * 字符串截取指定长度
	 * 
	 * @author AndyFay
	 * @date 2009 3 31
	 * @param title
	 * @param outLength
	 * @return
	 */
	public static String formatTitle(String title, int outLength,
			String titleFormat) {
		int nowLength = 0; // 当前所得字符长度（以asciII长度计算，一个中文字符算2个asciII字符）
		int countAllLength = 0; // 统计全部的字符串长度（以asciII长度计算，一个中文字符算2个asciII字符）
		int total = 2 * outLength;
		StringBuffer retStr = new StringBuffer("");
		for (int i = 0; i < title.length(); i++) {
			char tmpChar = title.charAt(i);

			// 如果当前取得的字符为asciII字符
			if (isLetter(tmpChar)) {
				if (nowLength < total - 2) {
					retStr.append(tmpChar);
					nowLength++;
				}
				countAllLength++;
			}

			// 如果当前取得的字符为其它字符（如汉，日，韩文字符）
			else {
				if (nowLength < (total - 3)) {
					retStr.append(tmpChar);
					nowLength += 2;
				}
				countAllLength += 2;
			}
		}

		// 如果字符总数小于或等于要截取的长度则直接返回该字符串
		if (countAllLength <= total) {
			return title;

			// 如果字符总数大于要截取的长度则返回截取后的长度
		} else {
			return retStr.append(titleFormat).toString();
		}
	}

	/**
	 * 判断一个字符是Ascill字符还是其它字符（如汉，日，韩文字符）
	 * 
	 * @author AndyFay
	 * @date 2009 3 31
	 * @param c
	 * @return
	 */
	public static boolean isLetter(char c) {
		int k = 0x80;
		return c / k == 0 ? true : false;
	}

	/**
	 * 将 html 转换成 txt文本
	 * 
	 * @author AndyFay
	 * @date 2009 3 31
	 * @param str
	 * @return
	 */
	public static String htmlToTxt(String str, int size) {
		String regxpForHtml = "<([^>]*)>|\\s|　|&nbsp;";
		// Pattern p = Pattern.compile(regEx);
		// Matcher m = p.matcher(str);
		return formatTitle(str.replaceAll(regxpForHtml, ""), size, "...");
	}

	/**
	 * 获取当前日期是星期几
	 * 
	 * @author zqi
	 * @param dt
	 * @return 当前日期是星期几
	 */
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return weekDays[w];
	}

	/**
	 * 对指定字符串进行判断，截取出所需要部分
	 * 
	 * @author chenjie
	 * @param str
	 * @return 处理后的字符串
	 */
	public static String splitStr(String str){
		String result = "";
		if(str == null || str.equals("")){
			result = "";
		}else if(str.lastIndexOf("】") == -1){
			result = str;
		}else {
			int index = str.lastIndexOf("】");
			result = str.substring(index+1);
		}
		return result;
	}
}
