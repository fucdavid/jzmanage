/**   
 * @Title: Pinyin4j.java
 * @Package com.guoxin.common.util
 * @Description: TODO
 * @author xyu
 * @date 2011-5-20 下午06:29:00
 *  
 */

package com.guoxin.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * @项目名称：foreignaid
 * @类名称：Pinyin4j
 * @类描述：
 * @创建人：xyu
 * @创建时间：2011-5-20 下午06:29:00
 * @修改人：
 * @修改时间：2011-5-20 下午06:29:00
 * @修改备注：
 * @version
 */
public class Pinyin4j implements Comparator<Object> {

	public static List<Object[]> sortNameWebDAO(List<Object[]> objList) {
		List<Object[]> resultList = new ArrayList<Object[]>();
		Collections.sort(objList, new Pinyin4j());
		for (int i = objList.size() - 1; i >= 0; i--) {
			Object[] obj = (Object[]) objList.get(i);
			resultList.add(obj);
		}
		return resultList;
	}

	public int compare(Object o1, Object o2) {
		Object[] obj1 = (Object[]) o1;
		Object[] obj2 = (Object[]) o2;
		String key1 = obj1[1].toString();
		String key2 = obj2[1].toString();
		for (int i = 0; i < key1.length() && i < key2.length(); i++) {
			int codePoint1 = key1.charAt(i);
			int codePoint2 = key2.charAt(i);
			if (Character.isSupplementaryCodePoint(codePoint1) || Character.isSupplementaryCodePoint(codePoint2)) {
				i++;
			}
			if (codePoint1 != codePoint2) {
				if (Character.isSupplementaryCodePoint(codePoint1) || Character.isSupplementaryCodePoint(codePoint2)) {
					return codePoint1 - codePoint2;
				}
				String pinyin1 = pinyin((char) codePoint1);
				String pinyin2 = pinyin((char) codePoint2);
				if (pinyin1 != null && pinyin2 != null) { // 两个字符都是汉字
					if (!pinyin1.equals(pinyin2)) {
						return pinyin1.compareTo(pinyin2);
					}
				} else {
					return codePoint1 - codePoint2;
				}
			}
		}
		return key1.length() - key2.length();
	}

	private String pinyin(char c) {
		String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c);
		if (pinyins == null) {
			return null; // 如果转换结果为空，则返回null
		}
		return pinyins[0]; // 如果为多音字返回第一个音节
	}
}