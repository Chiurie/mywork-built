package com.work.built.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeUtils {
	
	private static final int BLACK = 0xff000000;  
    private static final int WHITE = 0xFFFFFFFF;
	
    
    
    public static void getQRCodeStream(String contents,OutputStream outStrem){
    	try {
       	 Hashtable<EncodeHintType,Object> hints = new Hashtable<EncodeHintType,Object>();  
            /*设置纠错级别(L 7%~M 15%~Q 25%~H 30%),纠错级别越高存储的信息越少*/  
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);  
            /*设置编码格式*/  
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
            /*设置边缘空白*/  
            hints.put(EncodeHintType.MARGIN, 0);  
            int width = 214;
            int height = 212;
            //String contents = phone+","+id;
            String format = "png";
   			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,BarcodeFormat.QR_CODE,width,height,hints);
   			//ServletOutputStream sos = response.getOutputStream();
   			writeToStream(bitMatrix, format, outStrem, false, "");
   		} catch (Exception e) {
   			e.printStackTrace();
   		}  
    }
    
    
	private static void writeToStream(BitMatrix bitMatrix,String format,OutputStream stream,boolean isLogo,String logoPath) throws IOException{  
        BufferedImage bi = toBufferedImageContents(bitMatrix);  
        if(isLogo){  
            int width_4 = bitMatrix.getWidth() / 4;  
            int width_8 = width_4 / 2;  
            int height_4 = bitMatrix.getHeight() / 4;  
            int height_8 = height_4 / 2;  
            /*返回由指定矩形区域定义的子图像*/  
            BufferedImage bi2 = bi.getSubimage(width_4 + width_8, height_4 + height_8, width_4, height_4);  
            /*获取一个绘图工具笔*/  
            Graphics2D g2 = bi2.createGraphics();  
            /*读取logo图片信息*/  
            Image img = ImageIO.read(new File(logoPath));//实例化一个Image对象。 
            /*当前图片的宽与高*/  
            int currentImgWidth = img.getWidth(null);  
            int currentImgHeight = img.getHeight(null);  
            /*处理图片的宽与高*/  
            int resultImgWidth = 0;  
            int resultImgHeight = 0;  
            if(currentImgWidth != width_4){  
                resultImgWidth = width_4;  
            }  
            if(currentImgHeight != width_4){  
                resultImgHeight = width_4;  
            }  
            /*绘制图片*/  
            g2.drawImage(img,0,0, resultImgWidth,resultImgHeight,null);  
            g2.dispose();    
            bi.flush();  
        }  
        ImageIO.write(bi, format, stream);  
    }  
    
    private static BufferedImage toBufferedImageContents(BitMatrix bitMatrix){  
        int width = bitMatrix.getWidth();  
        int height = bitMatrix.getHeight();  
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);  
        for(int x=0;x<width;x++){  
            for(int y=0;y<height;y++){  
                image.setRGB(x, y, bitMatrix.get(x, y) == true ? BLACK : WHITE);  
            }  
        }  
        return image;  
    }  
}
