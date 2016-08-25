package com.work.built.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ApplicationConfig {

	public static final boolean HIDE_PLATFORM_COUPON;
	public static final String FILE_UPLOAD_PATH;
	public static final String LOCAL_ADRESS_URL;
	public static final String RONGCLOUD_KEY;
	public static final String RONGCLOUD_SECRET;
	public static final String DOWN_ANDROIDAPP_PATH;
	public static final String DOWN_ANDROIDAPP_NAME;
	public static final String DOWN_ANDROIDAPP_MERCHANTNAME;
	public static final String MERCHANT_PATH;
	public static final String REDIS_HOST;
	public static final int REDIS_PORT;
	public static final String CREATE_TEST_ORDERNO;
	public static final String MERCHANT_APPKEY;
	public static final String MERCHANT_MASTERSECRET;
	public static final String USER_APPKEY;
	public static final String USER_MASTERSECRET;
	
	//支付宝支付配置
	public static final String ALIPAY_PARTNER;
	public static final String ALIPAY_SELLER_EMAIL;
	public static final String ALIPAY_APP_PRIVATE_KEY;
	public static final String ALIPAY_KEY;
	public static final String ALIPAY_PUBLIC_KEY;
	public static final String ALIPAY_INPUT_CHARSET;
	public static final String ALIPAY_APP_SIGN_TYPE;
	public static final String ALIPAY_SIGN_TYPE;
	public static final String ALIPAY_PAYMENT_TYPE;
	public static final String ALIPAY_SHOW_URL;
	public static final String ALIPAY_NOTIFY_URL;
	public static final String ALIPAY_RETURN_URL;
	
	//微信支付配置
	/**
	 * 统一下单接口
	 */
	public static final String WXPAY_UNIFIED_SINGLE_URL;
	
	/**
	 * 查询该笔支付订单的状态
	 */
	public static final String WXPAY_ORDERQUERY;
	
	/**
	 * 下载对账单
	 */
	public static final String WXPAY_DOWNLOADBILL;
	/**
	 * 签名密钥
	 */
	public static final String WXPAY_PRIVATE_KEY;
	/**
	 * 公众号ID
	 */
	public static final String WXPAY_APP_ID;
	/**
	 * 商户号
	 */
	public static final String WXPAY_MCH_ID;
	
	//银联支付配置
	public static final String UNIONPAY_VERSION;
	public static final String UNIONPAY_ENCODING;
	
	static {
		Properties prop = new Properties();
		InputStream in = ApplicationConfig.class.getResourceAsStream("/com/work/built/config/application.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String filePath=prop.getProperty("uploadFilePath");
		FILE_UPLOAD_PATH=filePath;
		String hidePlatformCoupon = prop.getProperty("hide_platform_coupon", "true");
		HIDE_PLATFORM_COUPON = hidePlatformCoupon.equals("true") ? true : false;
		LOCAL_ADRESS_URL = prop.getProperty("localAdress");
		RONGCLOUD_KEY = prop.getProperty("rongcloud.key");
		RONGCLOUD_SECRET = prop.getProperty("rongcloud.secret");
		DOWN_ANDROIDAPP_PATH = prop.getProperty("down.androidapp.path");
		DOWN_ANDROIDAPP_NAME = prop.getProperty("down.androidapp.name");
		MERCHANT_PATH = prop.getProperty("merchant.path");
		REDIS_HOST = prop.getProperty("redis.host");
		REDIS_PORT = Integer.valueOf(prop.getProperty("redis.port"));
		DOWN_ANDROIDAPP_MERCHANTNAME = prop.getProperty("down.androidapp.merchantname");
		CREATE_TEST_ORDERNO = prop.getProperty("create.test.orderno");
		MERCHANT_APPKEY = prop.getProperty("jpush.merchant.appKey");
		MERCHANT_MASTERSECRET = prop.getProperty("jpush.merchant.masterSecret");
		USER_APPKEY = prop.getProperty("jpush.user.appKey");
		USER_MASTERSECRET = prop.getProperty("jpush.user.masterSecret");
		
		ALIPAY_PARTNER = prop.getProperty("alipay.partner");
		ALIPAY_SELLER_EMAIL = prop.getProperty("alipay.seller.email");
		ALIPAY_APP_PRIVATE_KEY = prop.getProperty("alipay.app.private.key");
		ALIPAY_KEY = prop.getProperty("alipay.key");
		ALIPAY_PUBLIC_KEY = prop.getProperty("alipay.public.key");
		ALIPAY_INPUT_CHARSET = prop.getProperty("alipay.input.charset");
		ALIPAY_APP_SIGN_TYPE = prop.getProperty("alipay.app.sign.type");
		ALIPAY_SIGN_TYPE = prop.getProperty("alipay.sign.type");
		ALIPAY_PAYMENT_TYPE = prop.getProperty("alipay.payment.type");
		ALIPAY_SHOW_URL = prop.getProperty("alipay.show.url");
		ALIPAY_NOTIFY_URL = prop.getProperty("alipay.notify.url");
		ALIPAY_RETURN_URL = prop.getProperty("alipay.return.url");
		
		WXPAY_UNIFIED_SINGLE_URL = prop.getProperty("wxpay.unified.single.url");
		WXPAY_ORDERQUERY = prop.getProperty("wxpay.orderquery");
		WXPAY_PRIVATE_KEY = prop.getProperty("wxpay.private.key");
		WXPAY_DOWNLOADBILL = prop.getProperty("wxpay.downloadbill");
		WXPAY_APP_ID = prop.getProperty("wxpay.app.id");
		WXPAY_MCH_ID = prop.getProperty("wxpay.mch.id");
		
		UNIONPAY_VERSION = prop.getProperty("unionpay.version");
		UNIONPAY_ENCODING = prop.getProperty("unionpay.encoding");
	}
}
