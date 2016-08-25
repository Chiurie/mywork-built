package com.work.built.pay.wxpay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.work.built.config.ApplicationConfig;
import com.work.built.pay.alipay.sign.MD5;





public class WxPayUtils {

	public static String buildRequestXml(Map<String,String> map){
		Map<String,String> params = buildRequestPara(map);
		return XMLParser.getSignedXMLFromMap(params);
	}

	/**
	 * 
	
	* @Title: buildRequestPara 
	
	* @Description: TODO(生成提交的给微信支付的 参数) 
	
	* @param @param map
	* @param @return    添加签名参数
	
	* @return Map<String,String>    返回类型 
	
	* @throws
	 */
	public static Map<String,String> buildRequestPara(Map<String,String> map){
		Map<String, String> params = paraFilter(map);//去除掉空的字段
		String signStr = createLinkString(params);//拼接成key=value&格式
		String stringSignTemp= signStr+"&key="+ApplicationConfig.WXPAY_PRIVATE_KEY;
		String sign = MD5.md5(stringSignTemp).toUpperCase();//采用md5加密 在转换为大写 
		params.put("sign", sign);
		return params;
	}
	
	//验签验证
	public static boolean verify(Map<String,String> map){
		String sign = "";
	    if(map.get("sign") != null) {sign = map.get("sign");}
		Map<String, String> params = paraFilter(map);//去除掉空的字段
		String signStr = createLinkString(params);//拼接成key=value&格式
		String stringSignTemp= signStr+"&key="+ApplicationConfig.WXPAY_PRIVATE_KEY;
		//System.out.println("待验签字符串:"+stringSignTemp);
		String signResult = MD5.md5(stringSignTemp).toUpperCase();
		//System.out.println("签完之后的字符串:"+signResult);
		if(sign.equals(signResult)){
			return true;	
		}else{
			return false;
		}
	}
	
	 /** 
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
	private static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }

    /** 
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
	private static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }
	
	/*public static void main(String[] args) {
	Map<String,String> map = new HashMap<String, String>();
	map.put("nonce_str", "PwzOv5DLUemru22o");
	map.put("appid", "wxb78563cd0869131e");
	map.put("sign", "666895C96D1E92E9BC57C817843DC760");
	map.put("trade_type", "APP");
	map.put("return_msg", "OK");
	map.put("result_code", "SUCCESS");
	map.put("mch_id", "1269268401");
	map.put("return_code", "SUCCESS");
	map.put("prepay_id", "wx20151013200346cd928cd12a0053418513");
	Map<String,String> params = new HashMap<String, String>();
	params.put("appid", "wxb78563cd0869131e");
	params.put("bank_type", "CCB_DEBIT");
	params.put("cash_fee", "1");
	params.put("fee_type", "CNY");
	params.put("is_subscribe", "N");
	params.put("mch_id", "1269268401");
	params.put("nonce_str", "8jcp6vgy3nu4w0iz1zpqbku4z");
	params.put("openid", "o_yyxv3En4sxYZ8e4PcQ21c4J28A");
	params.put("out_trade_no", "2015101400000102");
	params.put("result_code", "SUCCESS");
	params.put("return_code", "SUCCESS");
	params.put("sign", "9963A8C0F1445F5C7C6AC33DC8D0B77B");
	params.put("time_end", "20151014094823");
	params.put("total_fee", "1");
	params.put("trade_type", "APP");
	params.put("transaction_id", "1005760166201510141189593405");
	boolean isSign1 = verify(params);
	boolean isSign = verify(map);
	System.out.println(isSign+":"+isSign1);
}*/
}	
