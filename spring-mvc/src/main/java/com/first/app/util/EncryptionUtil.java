package com.first.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EncryptionUtil {

	private static Logger logger = LoggerFactory.getLogger(EncryptionUtil.class);

	private static final String SYMETRIC_ALGORITHM = "AES";

	public static void aesDecrypt128Bit(String password, InputStream inputStream, OutputStream outputStream)
			throws CryptoException {
		aesEncryption128Bit(Cipher.DECRYPT_MODE, password, inputStream, outputStream);
	}

	private static final byte[] IV = "AAAAAAAAAAAAAAAA".getBytes();
	private static String cekPlainText = "1234567890";

	public static void aesEncryption128Bit(int cipherMode, String password, InputStream inputStream,
			OutputStream outputStream) throws CryptoException {
		CipherOutputStream out = null;
		try {
			byte[] aesKey = createAESKey(128, password);
			Key secretKey = new SecretKeySpec(aesKey, SYMETRIC_ALGORITHM);

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(cipherMode, secretKey, new IvParameterSpec(IV));

			if (cipherMode == Cipher.ENCRYPT_MODE) {
				out = new CipherOutputStream(outputStream, cipher);
				out.write(cekPlainText.getBytes());
			} else {
				out = new CipherOutputStream(new SkipOutputStream(outputStream, cekPlainText.length()), cipher);
			}
			IOUtils.copy(inputStream, out);

			out.flush();
		} catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IOException
				| InvalidAlgorithmParameterException ex) {
			logger.error("", ex);
			throw new CryptoException("Error encrypting/decrypting file", ex);
		} finally {
			IOUtils.closeQuietly(out);
		}
	}

	public static byte[] createAESKey(int length, String password) {
		return createAESKey(length, password, 'z');
	}

	public static byte[] createAESKey(int length, String password, char padding) {
		int charLength = length / 8;
		String padPwd = StringUtils.rightPad(password, charLength, padding);

		return padPwd.getBytes();
	}

}
