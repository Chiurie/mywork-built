package com.work.built.pay.alipay.sign;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import org.apache.commons.codec.digest.DigestUtils;
/** 
* 功能：支付宝MD5签名处理核心文件，不需要修改
* 版本：3.3
* 修改日期：2012-08-17
* 说明：
* 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
* 该代码仅供学习和研究支付宝接口使用，只是提供一个
* */

public class MD5 {

    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static String sign(String text, String key, String input_charset) {
    	text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }
    
    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param sign 签名结果
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static boolean verify(String text, String sign, String key, String input_charset) {
    	text = text + key;
    	String mysign = DigestUtils.md5Hex(getContentBytes(text, input_charset));
    	if(mysign.equals(sign)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }
    
    
    public static String md5(String plainText){
    	StringBuffer buf = new StringBuffer(""); 
    	try { 
	    		MessageDigest md = MessageDigest.getInstance("MD5"); 
	    		md.update(plainText.getBytes()); 
	    		byte b[] = md.digest(); 
	
	    		int i; 
	
	    		for (int offset = 0; offset < b.length; offset++) { 
		    		i = b[offset]; 
		    		if(i<0) i+= 256; 
		    		if(i<16) 
		    		buf.append("0"); 
		    		buf.append(Integer.toHexString(i)); 
	    		} 
	
	    		//System.out.println("result: " + buf.toString());//32位的加密 
	
	    		//System.out.println("result: " + buf.toString().substring(8,24));//16位的加密 

    		} catch (NoSuchAlgorithmException e) { 
    		e.printStackTrace(); 
    		} 
    	return buf.toString();
    } 

    
   /* public static void main(String[] args) {
    	String plainText = "appid=wxd930ea5d5a258f4f&body=test&device_info=1000&mch_id=10000100&nonce_str=ibuaiVcKdpRxkhJA&key=192006250b4c09247ec02edce69f6a2d";
		System.out.println(md5(plainText).toUpperCase());
	}*/
}