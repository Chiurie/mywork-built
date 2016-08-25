package com.work.built.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.work.built.config.ApplicationConfig;

/**
 * 创建文件上传文件夹
 * 
 * @author jinbiao
 *
 */
public class FileUtiles {

	public static String restUrl() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String now = sdf.format(new Date());
		String path = ApplicationConfig.FILE_UPLOAD_PATH + "/res/" + now;
		File file = new File(path);
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
		return now;
	}

	// 检查有没有room上传路径
	public static String roomUrl() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String now = sdf.format(new Date());
		String path = ApplicationConfig.FILE_UPLOAD_PATH + "/room/" + now;
		File file = new File(path);
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
		return now;
	}

	// 检查有没有cuisine上传路径
	public static String cuisineUrl() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String now = sdf.format(new Date());
		String path = ApplicationConfig.FILE_UPLOAD_PATH + "/cuisine/" + now;
		File file = new File(path);
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
		return  now;
	}
	
	//广告路径
	public static String advUrl() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String now = sdf.format(new Date());
		String path = ApplicationConfig.FILE_UPLOAD_PATH + "/adv/" + now;
		File file = new File(path);
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
		return now;
	}
	
	
	
	//文件格式
	public static String fileFormat(String pattten){
		String paString="";
		if (!StringUtils.isEmpty(pattten)) {
			 paString=pattten.substring(pattten.length()-4);
		}
		return paString;
	}
	
	/*public static void main(String[] args) {
		System.out.println(FileUtiles.fileFormat("3.png"));
	}
*/
}
