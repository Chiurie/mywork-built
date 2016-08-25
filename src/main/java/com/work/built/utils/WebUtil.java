package com.work.built.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取客户端的IP地址
  * @ClassName: WebUtil
  * @Description: TODO
  * @author XuLve
  * @date 2015年12月19日 下午4:24:52
  *
 */
public class WebUtil {
	public static String getRealIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// 如果是多级代理，那么取第一个ip为客户ip
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
		}
		return ip;
	}
}
