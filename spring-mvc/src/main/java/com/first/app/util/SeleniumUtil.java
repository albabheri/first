package com.first.app.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

public class SeleniumUtil {
	
	public static void trustAllCetificate(){
		// Create a new trust manager that trust all certificates
		TrustManager[] trustAllCerts = new TrustManager[]{
		    new X509TrustManager() {
		        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		            return null;
		        }
		        public void checkClientTrusted(
		            java.security.cert.X509Certificate[] certs, String authType) {
		        }
		        public void checkServerTrusted(
		            java.security.cert.X509Certificate[] certs, String authType) {
		        }
		    }
		};

		// Activate the new trust manager
		try {
		    SSLContext sc = SSLContext.getInstance("SSL");
		    sc.init(null, trustAllCerts, new java.security.SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void setDriver(String GECKO_DRIVER){
		System.setProperty("webdriver.gecko.driver", GECKO_DRIVER);
	}
	
	public static FirefoxProfile getProfileFirefox(String profile){
		ProfilesIni profiles = new ProfilesIni();
		FirefoxProfile fProfile = profiles.getProfile(profile);
		fProfile.setAcceptUntrustedCertificates(true);
		fProfile.setAssumeUntrustedCertificateIssuer(false);
		
		return fProfile;
	}
	
	public static FirefoxProfile setProfileFirefoxDownload(String pathDownload){
		FirefoxProfile fxProfile = new FirefoxProfile();
		fxProfile.setPreference("browser.download.folderList",2);
		fxProfile.setPreference("browser.download.dir", pathDownload);
		fxProfile.setPreference("browser.helperApps.neverAsk.openFile","application/octet-stream");
		fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
		fxProfile.setPreference("browser.download.manager.showWhenStarting",false);
		return fxProfile;
	}
	
	public static boolean isElementExist(WebDriver driver, By by){
		try {
			driver.findElement(by);
		} catch (NoSuchElementException e) {
//			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static boolean isAttributeExist(WebElement element, String attribute){
		Boolean result = false;
		try {
			String value = element.getAttribute(attribute);
	        if (value != null){
	        	result = true;
	        }
		} catch (Exception e) {
			return false;
		}
		return result;
	}
	
	public static boolean waitElement(WebDriver driver, int WAIT, By by){
		try {
			WebDriverWait driverWait = new WebDriverWait(driver, WAIT);
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	public static boolean checkElementExists(WebDriver driver, By by, int second){
		boolean result = false;
		try {
			driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
			driver.findElement(by);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		
		return false;
	}
	
	
	public static String getCookie(WebDriver driver, String cookieName){
		Cookie cookie = driver.manage().getCookieNamed(cookieName);
		return cookie.getValue();
	}
	
	
	public static boolean waitUntilElementDisplayed(WebDriver driver, By by, int second) throws InterruptedException{
		boolean result = false;
		if(checkElementExists(driver, by, second)){
			for(int i=0; i<second; i++){
				if(driver.findElement(by).isDisplayed()){
					return true;
				}else {
					Thread.sleep(1000);
				}
			}
		} else {
			result = false;
		}
		
		return result;
	}
	
	
	public static void downloadFileFromURL(String urlString, File destination) throws IOException {    
        URL website = new URL(urlString);
        ReadableByteChannel rbc;
        rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(destination);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
	
	public static Path download(String sourceURL, String targetDirectory) throws IOException
	{
	    URL url = new URL(sourceURL);
	    String fileName = "downloadIdeb";
	    Path targetPath = new File(targetDirectory + File.separator + fileName).toPath();
	    Files.copy(url.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

	    return targetPath;
	}
	
	public static void downloadUsingStream(String urlStr, String file, String session) throws IOException{
        URL url = new URL(urlStr);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("Cookie", "JSESSIONID="+session);
        BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
//        FileOutputStream fis = new FileOutputStream(file);
        FileOutputStream fis = new FileOutputStream("D:\\WorkSpace\\WebScraping\\jajal.ideb");
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
	
	
	
	
	public static String downloadFile(String url, String filenamePrefix, String fileExtension, String session) throws Exception{
  		URLConnection request = null;
  		request = new URL(url).openConnection();
  		request.setRequestProperty("Cookie", "JSESSIONID="+session);
		InputStream in = request.getInputStream();
		File downloadedFile = File.createTempFile(filenamePrefix, fileExtension);
		FileOutputStream out = new FileOutputStream(downloadedFile);		
		byte[] buffer = new byte[1024];
		int len = in.read(buffer);
		while (len != -1) {
		    out.write(buffer, 0, len);
		    len = in.read(buffer);
		    if (Thread.interrupted()) {
		        throw new InterruptedException();
		    }
		}
		in.close();
		out.close();
		return downloadedFile.getAbsolutePath();
	}
	
	public static void downloadFile3(String url, String path, WebDriver driver, FirefoxProfile fxProfile) throws Exception{
//		fxProfile.setPreference("browser.download.folderList",2);
//		fxProfile.setPreference("browser.download.dir", path);
////		fxProfile.setPreference("browser.helperApps.neverAsk.openFile","application/octet-stream");
//		fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
//		fxProfile.setPreference("browser.download.manager.showWhenStarting",false);
////		fxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
////		fxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
////		fxProfile.setPreference("browser.download.manager.focusWhenStarting", false);
////		fxProfile.setPreference("browser.download.manager.useWindow", false);
////		fxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
////		fxProfile.setPreference("browser.download.manager.closeWhenDone", false);
		
//		FirefoxProfile tes = new FirefoxProfile();
		driver.get(url);
//		driver = webdriver.Firefox(fxProfile);
	}
	
	
	
	public static void AjaxFileDownloader(WebDriver driver) {
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS); // maybe you need a different timeout
    }

    public static InputStream AjaxFileDownloader(String url, WebDriver driver) throws IOException {
        String script = "var url = arguments[0];" +
                "var callback = arguments[arguments.length - 1];" +
                "var xhr = new XMLHttpRequest();" +
                "xhr.open('GET', url, true);" +
                "xhr.responseType = \"arraybuffer\";" + //force the HTTP response, response-type header to be array buffer
                "xhr.onload = function() {" +
                "  var arrayBuffer = xhr.response;" +
                "  var byteArray = new Uint8Array(arrayBuffer);" +
                "  callback(byteArray);" +
                "};" +
                "xhr.send();";
        Object response = ((JavascriptExecutor) driver).executeAsyncScript(script, url);
        // Selenium returns an Array of Long, we need byte[]
        ArrayList<Long> byteList = (ArrayList<Long>) response;
        byte[] bytes = new byte[byteList.size()];
        for(int i = 0; i < byteList.size(); i++) {
            bytes[i] = (byte)(long)byteList.get(i);
        }
        return new ByteArrayInputStream(bytes);
    }
	
	
	
	public static void downloadFile2(String downloadUrl, String outputFilePath, WebDriver driver) throws Exception {

		CookieStore cookieStore = seleniumCookiesToCookieStore(driver);
		DefaultHttpClient httpClient = new DefaultHttpClient();
		httpClient.setCookieStore(cookieStore);

		HttpGet httpGet = new HttpGet(downloadUrl);
		SeleniumUtil.trustAllCetificate();
		System.out.println("Downloding file form: " + downloadUrl);
		HttpResponse response = httpClient.execute(httpGet);
		

		HttpEntity entity = response.getEntity();
		if (entity != null) {
			File outputFile = new File(outputFilePath);
			InputStream inputStream = entity.getContent();
			FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				fileOutputStream.write(bytes, 0, read);
			}
			fileOutputStream.close();
			System.out.println("Downloded " + outputFile.length() + " bytes. " + entity.getContentType());
		}
		else {
			System.out.println("Download failed!");
		}
	}
	
	private static CookieStore seleniumCookiesToCookieStore(WebDriver driver) {

		Set<Cookie> seleniumCookies = driver.manage().getCookies();
		CookieStore cookieStore = new BasicCookieStore();

		for(Cookie seleniumCookie : seleniumCookies){
			BasicClientCookie basicClientCookie =
					new BasicClientCookie(seleniumCookie.getName(), seleniumCookie.getValue());
			basicClientCookie.setDomain(seleniumCookie.getDomain());
			basicClientCookie.setExpiryDate(seleniumCookie.getExpiry());
			basicClientCookie.setPath(seleniumCookie.getPath());
			cookieStore.addCookie(basicClientCookie);
		}

		return cookieStore;
	}

	
	public static String convertFileToBase64String(String fileName) throws IOException {

        File file = new File(fileName);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();
        String encodedFile = Base64.getEncoder().encodeToString(bytes);

        return encodedFile;
    }
	
}
