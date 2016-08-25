package com.work.built.pay.wxpay;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.ObjectUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.work.built.utils.Util;

public class XMLParser {

	public static Map<String,String> getMapFromXML(String xmlString) throws ParserConfigurationException, IOException, SAXException {

        //这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream is =  Util.getStringStream(xmlString);
        Document document = builder.parse(is);

        //获取到document里面的全部结点
        NodeList allNodes = document.getFirstChild().getChildNodes();
        Node node;
        Map<String, String> map = new HashMap<String, String>();
        int i=0;
        while (i < allNodes.getLength()) {
            node = allNodes.item(i);
            if(node instanceof Element){
                map.put(node.getNodeName(),node.getTextContent());
            }
            i++;
        }
        return map;
    }

    /**
     * 
    
    * @Title: getXMLFromMap 
    
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    
    * @param @param map
    * @param @return    设定文件 
    
    * @return String    返回类型 
    
    * @throws
     */
    public static String getSignedXMLFromMap(Map<String,String> map){
		if(map == null){
			throw new NullPointerException("map 数据为空,不能解析!");
		}
		
		List<String> keys = new ArrayList<String>(map.keySet());
        Collections.sort(keys);
		
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		 for (int i = 0; i < keys.size(); i++) {
			 String key = keys.get(i);
				 if(key.equals("sign")){
					 continue;
				 }
	            String value = map.get(key);
	            sb.append("<"+key+">");
				sb.append(ObjectUtils.toString(value, ""));
				sb.append("</"+key+">");
		 }
		 sb.append("<sign>"+map.get("sign")+"</sign>");
		sb.append("</xml>");
		return sb.toString();
	}

    
    public static String getXMLFromMap(Map<String,String> map){
    	if(map == null){
			throw new NullPointerException("map 数据为空,不能解析!");
		}
		
		List<String> keys = new ArrayList<String>(map.keySet());
        Collections.sort(keys);
		
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		for (int i = 0; i < keys.size(); i++) {
			 String key = keys.get(i);
	            String value = map.get(key);
	            sb.append("<"+key+">");
				sb.append(ObjectUtils.toString(value, ""));
				sb.append("</"+key+">");
		 }
		sb.append("</xml>");
		return sb.toString();
    }
}