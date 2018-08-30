package com.first.app.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptUtil {

	public static String decrypt(String encrypted) {
		return decrypt(ConstantaVariable.ENCRYPT.KEY, ConstantaVariable.ENCRYPT.INIT_VECTOR, encrypted);
	}

	public static String encrypt(String value) {
		return encrypt(ConstantaVariable.ENCRYPT.KEY, ConstantaVariable.ENCRYPT.INIT_VECTOR, value);
	}

	public static String encrypt(String key, String initVector, String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
//			System.out.println("encrypted string: " + Base64.encodeBase64String(encrypted));
			System.out.println("encrypted string: " + Base64.getEncoder().encodeToString(encrypted));
//			return Base64.encodeBase64String(encrypted);
			return Base64.getDecoder().decode(encrypted).toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static String decrypt(String key, String initVector, String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

//			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
			byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
}
