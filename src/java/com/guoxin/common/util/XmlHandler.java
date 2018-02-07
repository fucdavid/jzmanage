/**
 * @Title: XmlHandler.java
 * @Package com.psy.common.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author PSY
 * @date 2015-3-5 下午05:27:23
 * @version V1.0
 */
package com.guoxin.common.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.dom4j.Element;

/**
 * @ClassName: XmlHandler
 * @Description: 处理XML的转化，转成XML，或者是有XML转出
 * @author PSY
 * @date 2015-3-5 下午05:27:23
 */
public class XmlHandler {

	/**
	 * 将xml转化成Map
	 * @author PSY
	 * @createTime 2015-3-6 下午01:19:17
	 * @param element
	 * @return
	 */
	public static Map<String, String> xmlToMap(Element element) {
		Map<String, String> resultMap = new HashMap<String, String>();
		List nodes = element.elements();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			Element elm = (Element) it.next();
			resultMap.put(elm.getName(), elm.getText());
		}
		return resultMap;
	}
	
	/**
	 * 将对象转化成xml形式
	 * @author PSY
	 * @createTime 2015-3-6 下午03:04:59
	 * @param object
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String objToXml(Object object) throws UnsupportedEncodingException{
		XMLSerializer serializer = new XMLSerializer();
		serializer.setTypeHintsEnabled(false);
		serializer.setRootName("xml");
		String jsonString = GsonHandler.toJson(object);
//		System.out.println(JSONArray.parse(jsonString));
		String replyMsg = serializer.write((JSONObject) JSONSerializer.toJSON(jsonString)).substring(40);
		return replyMsg;
	}
	
	/**
	 * xml转Json
	 * @author PSY
	 * @createTime 2015-3-13 下午03:35:53
	 * @param xml
	 * @return
	 */
	public static String xml2JSON(String xml){
        return new XMLSerializer().read(xml).toString();
    }
	
	/**
	 * Json转Xml
	 * @author PSY
	 * @createTime 2015-3-13 下午03:36:22
	 * @param json
	 * @return
	 */
    public static String json2XML(JSONObject jobj){
        String xml =  new XMLSerializer().write(jobj);
        return xml;
    }
}