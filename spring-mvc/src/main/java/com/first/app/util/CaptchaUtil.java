package com.first.app.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaptchaUtil {
	
	public static InputStream getImgStream(String path, String session) throws IOException{
		URL imgUrl = new URL(path);
		URLConnection connection = imgUrl.openConnection();
		connection.setRequestProperty("Cookie", "JSESSIONID="+session);
		InputStream is = connection.getInputStream();
		
		return is;
	}
	
	public static String getCaptcha(InputStream imgStream) throws IOException{
		String captcha = "";
		byte[] byteImage = IOUtils.toByteArray(imgStream);
		imgStream.read(byteImage);
		imgStream.close();
		
//		System.out.println("byte : " + new String(byteImage));
		if(new String(byteImage).length() > 24){
			captcha = new String(byteImage).substring(new String(byteImage).length() - 24 );
		}
		return captcha;
	}
	
	public static BufferedImage getCapthca(WebElement Image, WebDriver driver) throws IOException{
		int width=Image.getSize().getWidth();
	    int height=Image.getSize().getHeight();

	    File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    BufferedImage img=ImageIO.read(screen);
	    BufferedImage imgBuffer = img.getSubimage(Image.getLocation().getX(), Image.getLocation().getY(), width, height);
//	    ImageIO.write(imgBuffer, "png", screen);
//	    File file=new File("E:\\image.png");
//	    FileUtils.copyFile(screen,file);	
	    return imgBuffer;
	}
	
	public static String getCapthcaFromImageLoc(String imgLoc, Cookie cookie) throws IOException{
		String capthca = "";
		InputStream captchaStream = getImgStream(imgLoc,cookie.getValue());
		capthca = EncryptUtil.decrypt(CaptchaUtil.getCaptcha(captchaStream));
		return capthca;
	}
	
}
