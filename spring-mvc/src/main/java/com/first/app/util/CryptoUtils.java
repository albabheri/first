package com.first.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
 
/**
 * A utility class that encrypts or decrypts a file.
 * @author www.codejava.net
 *
 */
public class CryptoUtils {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
 
    public static void encrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }
    public static byte[] encrypt(String key,byte[] inputBytes)
            throws CryptoException {
       return  doCrypto(Cipher.ENCRYPT_MODE, key, inputBytes);
    }
    public static String encrypt(String key,String data)
            throws CryptoException, UnsupportedEncodingException {
    	return base64encode(doCrypto(Cipher.ENCRYPT_MODE, key, data.getBytes()));
       
    }
    public static String encryptStr(String key,byte[] inputBytes)
            throws CryptoException, UnsupportedEncodingException {
    	return base64encode(doCrypto(Cipher.ENCRYPT_MODE, key, inputBytes));
       
    }
    public static byte[] decrypt(String key,byte[] inputBytes)
            throws CryptoException {
       return  doCrypto(Cipher.DECRYPT_MODE, key, inputBytes);
    }
    public static String decrypt(String key,String data)
            throws CryptoException, UnsupportedEncodingException {
    	String result = new String(doCrypto(Cipher.DECRYPT_MODE, key, base64decode(data)), "UTF-8");
        return  result;
    }
    public static void decrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }
 
    private static void doCrypto(int cipherMode, String key, File inputFile,
            File outputFile) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
             
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
             
            byte[] outputBytes = cipher.doFinal(inputBytes);
             
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
             
            inputStream.close();
            outputStream.close();
             
        } catch (Exception ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }
    private static byte[] doCrypto(int cipherMode, String key, byte[] inputBytes) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
            byte[] outputBytes = cipher.doFinal(inputBytes);
             
            return  outputBytes;
        } catch (Exception ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }
    static BASE64Encoder enc=new BASE64Encoder();
    static BASE64Decoder dec=new BASE64Decoder();

    public static String base64encode(String text){
       try {
          String rez = enc.encode( text.getBytes( "UTF-8" ) );
          return rez;         
       }
       catch ( UnsupportedEncodingException e ) {
          return null;
       }
    }//base64encode
    public static String base64encode(byte[] text){
        try {
           String rez = enc.encode( text );
           return rez;         
        }
        catch ( Exception e ) {
           return null;
        }
     }//base64encode

    public static byte[] base64decode(String text){

        try {
           return dec.decodeBuffer( text );
        }
        catch ( IOException e ) {
          return null;
        }

     }
  /*  public static void main(String[] args) {
		for(int i=0;i<10;i++){
			if(i==4) {
				
			}else{
				System.out.println(i);
			}
			
		}
	}*/
    //base64decode
    /*public static void main(String[] args) {
		try {
			System.out.println(encrypt("iniadalahrahasia", "admin@167.com:Password.3:Cd6keEHf"));
			String s=decrypt("iniadalahrahasia", "LSwXeF9BrQbwRipBeZBHJLA0pp7RaK4n9FLksOrfBeA4t1RAYSUxM1JMxz5n2W9G");
			System.out.println("s:"+s);
		} catch (UnsupportedEncodingException | CryptoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	List<Integer> l=new ArrayList<>();
    	List<TUserSlik> la=new ArrayList<>();
    	int k=0;
    	for(int i=0;i<10;i++){
    		l.add(i+4);
    		TUserSlik s=new TUserSlik();
    		s.setId(""+k);
    		k++;
    		TUserSlik s1=new TUserSlik();
    		s1.setId(""+k);
    		k++;
    		TUserSlik s2=new TUserSlik();
    		s2.setId(""+k);
    		k++;
    		la.add(s);
    		la.add(s1);
    		la.add(s2);
    		
    	}
    	
    	for(int i=0;i<la.size();i++){
    		//System.out.println(getRandomNumberInRange(0, l.size()));
    		Integer in=getRandomNumberInRange(0, l.size()-1);
    		la.get(i).setDetail(l.get(in).toString());
    	}
    	int[][] j=new int[10][10];
    	
    	for(int i=0;i<la.size();i++){
    		System.out.println(la.get(i).getId()+":"+la.get(i).getDetail());
    	}
    	int a=4;
    	int b=20;
    	int pos=0;
    	for(int i=a-1;i>=0;i--){
    		if(pos==b){
    			pos=0;
    		}
    		
    		
    		if(a/b==0){
    			System.out.println(getRandomNumberInRange(0,b-1));
    		}else{
    			System.out.println(pos);
    		}
    		
    		
    		pos++;
    		a--;
    	}
    	//System.out.println(19/20);
		
		
	}*/
    
    private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
    /*public static void main(String[] args) {
		String aku="Hello";
		try {
			System.out.println(aku);
			System.out.println(aku.getBytes().toString());
			System.out.println(new String(aku.getBytes(),"UTF-8"));
			System.out.println(base64encode(aku));
			System.out.println(base64decode(aku));
			String h=encrypt("1234567890123456", aku);
			System.out.println(h);
			String d=decrypt("1234567890123456", h);
			System.out.println(d);
			System.out.println(base64encode(aku));
			byte[] a=encrypt("1234567890123456", aku.getBytes("UTF-8"));
			
			System.out.println(new String(a));
			System.out.println(base64encode(a));
//			System.out.println(base64decode2(a));
			String doc3=new String(decrypt("1234567890123456", a),"UTF-8");
			
			System.out.println("DECRIPT:"+doc3);
			
			String doc4=new String(decrypt("1234567890123456", base64decode(base64encode(a))),"UTF-8");
			System.out.println("DECRIPT:"+doc4);
			
			 Map<Integer, String> data = new HashMap<Integer, String>();
    data.put(1, "hello");
    data.put(2, "world");
    System.out.println(data.toString());

    // Convert Map to byte array
    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(byteOut);
    out.writeObject(data);

    // Parse byte array to Map
    ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
    ObjectInputStream in = new ObjectInputStream(byteIn);
    Map<Integer, String> data2 = (Map<Integer, String>) in.readObject();
    System.out.println(data2.toString());
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
}