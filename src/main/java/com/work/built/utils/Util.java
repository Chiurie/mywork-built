package com.work.built.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.XStream;

/**
 * User: rizenguo
 * Date: 2014/10/23
 * Time: 14:59
 */
public class Util {

    //打log用
    //private static Log logger = new Log(LoggerFactory.getLogger(Util.class));

	/**
	 * 
	  * filterEmoji(过滤emoji表情文字)
	  *
	  * @Title: filterEmoji
	  * @Description: TODO
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	 */
	public static String filterEmoji(String source){
		if(StringUtils.isNotBlank(source)){  
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");  
        }else{  
            return source;  
        }  
	}
	
	
    /**
     * 通过反射的方式遍历对象的属性和属性值，方便调试
     *
     * @param o 要遍历的对象
     * @throws Exception
     */
    public static void reflect(Object o) throws Exception {
        Class cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            Util.log(f.getName() + " -> " + f.get(o));
        }
    }

    public static byte[] readInput(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
        return out.toByteArray();
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }


    public static InputStream getStringStream(String sInputString) throws UnsupportedEncodingException {
        ByteArrayInputStream tInputStringStream = null;
        if (sInputString != null && !sInputString.trim().equals("")) {
            tInputStringStream = new ByteArrayInputStream(sInputString.getBytes("UTF-8"));
        }
        return tInputStringStream;
    }

    public static Object getObjectFromXML(String xml, Class tClass) {
        //将从API返回的XML数据映射到Java对象
        XStream xStreamForResponseData = new XStream();
        xStreamForResponseData.alias("xml", tClass);
        xStreamForResponseData.ignoreUnknownElements();//暂时忽略掉一些新增的字段
        return xStreamForResponseData.fromXML(xml);
    }

    /**
     * 打log接口
     * @param log 要打印的log字符串
     * @return 返回log
     */
    public static String log(Object log){
        //logger.i(log.toString());
        //System.out.println(log);
        return log.toString();
    }

    /**
     * 读取本地的xml数据，一般用来自测用
     * @param localPath 本地xml文件路径
     * @return 读到的xml字符串
     */
    public static String getLocalXMLString(String localPath) throws IOException {
        return Util.inputStreamToString(Util.class.getResourceAsStream(localPath));
    }
    
    /**
     * 
    
    * @Title: genRamdomNonce 
    
    * @Description: TODO(生成随机的字符串) 
    
    * @param @return    设定文件 
    
    * @return String    返回类型 
    
    * @throws
     */
    public static String genRamdomNonce(){
    	Random ran = new Random();
    	ran.nextInt(8);//[0,8);
    	Integer num = ran.nextInt(8)+8;
    	//48~57,97~122,65~90
    	StringBuffer noce = new StringBuffer();
    	for (int i = 0; i < num; i++) {
    		char ch1 = (char) (ran.nextInt(10)+48);
    		noce.append(ch1);
    		char ch2 = (char) (ran.nextInt(26)+97);
    		noce.append(ch2);
    		char ch3 = (char) (ran.nextInt(26)+65);
    		noce.append(ch3);
		}
    	return noce.toString();
    }

   /* public static void main(String[] args) {
		System.out.println(genRamdomNonce());
	}*/
}

