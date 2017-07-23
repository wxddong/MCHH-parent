package com.threefiveninetong.mchh.util;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class CryptUtil {

	// --------------不可逆加密--------------

	public static class SHA {

		/** SHA算法可选以下算法：SHA-1、SHA-256 */
		private static final String ALGORITHM_SHA = "SHA-1";

		public static String encrypt(String plaintext, String encoding) throws Exception {
			MessageDigest sha1 = MessageDigest.getInstance(ALGORITHM_SHA);
			sha1.update(plaintext.getBytes(encoding));

			return toHex(sha1.digest());
		}
	}

	public static class MD5 {

		private static final String ALGORITHM_MD5 = "MD5";

		public static String encrypt(String plaintext, String encoding) throws Exception {
			MessageDigest md5 = MessageDigest.getInstance(ALGORITHM_MD5);
			md5.update(plaintext.getBytes(encoding));

			return toHex(md5.digest());
		}
	}

	public static class HMAC {

		/** HMAC算法可选以下多种算法：HmacMD5、HmacSHA1、HmacSHA256、HmacSHA384、HmacSHA512 */
		private static final String ALGORITHM_HMAC = "HmacMD5";

		public static String createKey() throws Exception {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM_HMAC);
			SecretKey secretKey = keyGenerator.generateKey();
			return Base64.encode(secretKey.getEncoded());
		}

		public static String encrypt(String plaintext, String key, String encoding) throws Exception {
			SecretKey secretKey = new SecretKeySpec(Base64.decode(key), ALGORITHM_HMAC);
			Mac mac = Mac.getInstance(secretKey.getAlgorithm());
			mac.init(secretKey);

			return toHex(mac.doFinal(plaintext.getBytes(encoding)));
		}
	}

	// --------------非对称加密--------------
	// RSA、DH、DSA

	public static class RSA {

		private static final String ALGORITHM_RSA = "RSA";
		/** RSA签名算法 可选：MD5withRSA、SHA1withRSA、SHA256withRSA */
		private static final String ALGORITHM_RSA_SIGNATURE = "SHA1withRSA";
		private static final String ALGORITHM_RSA_PRIVATE_KEY = "RSAPrivateKey";
		private static final String ALGORITHM_RSA_PUBLIC_KEY = "RSAPublicKey";

		public static Map<String, Object> createKeyMap() throws Exception {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM_RSA);
			keyPairGen.initialize(1024);
			KeyPair keyPair = keyPairGen.generateKeyPair();

			// 私钥  
			PrivateKey privateKey = keyPair.getPrivate();
			// 公钥  
			PublicKey publicKey = keyPair.getPublic();

			Map<String, Object> keyMap = new HashMap<String, Object>(2);
			keyMap.put(ALGORITHM_RSA_PRIVATE_KEY, privateKey);
			keyMap.put(ALGORITHM_RSA_PUBLIC_KEY, publicKey);
			return keyMap;
		}

		public static String getPrivateKey(Map<String, Object> keyMap) {
			Key key = (Key) keyMap.get(ALGORITHM_RSA_PRIVATE_KEY);
			return Base64.encode(key.getEncoded());
		}

		public static String getPublicKey(Map<String, Object> keyMap) {
			Key key = (Key) keyMap.get(ALGORITHM_RSA_PUBLIC_KEY);
			return Base64.encode(key.getEncoded());
		}

		/**
		 * RSA签名, 默认算法SHA1withRSA
		 * @param content 待签名数据
		 * @param privateKey 商户私钥
		 * @param encoding 编码格式
		 * @return 签名值
		 * @throws Exception 异常
		 */
		public static String sign(String content, String privateKey, String encoding) throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_RSA_SIGNATURE);
			return sign(content, privateKey, algorithm, encoding);
		}

		/**
		 * RSA签名
		 * @param content 待签名数据
		 * @param privateKey 商户私钥
		 * @param algorithm 算法
		 * @param encoding 编码格式
		 * @return 签名值
		 * @throws Exception 异常
		 */
		public static String sign(String content, String privateKey, Algorithm algorithm, String encoding) throws Exception {
			PrivateKey priKey = toPrivateKey(privateKey);

			Signature signature = Signature.getInstance(algorithm.getName());
			signature.initSign(priKey);
			signature.update(content.getBytes(encoding));

			byte[] signed = signature.sign();
			return Base64.encode(signed);
		}

		/**
		 * RSA验签名检查
		 * @param content 待签名数据
		 * @param sign 签名值
		 * @param publicKey 公钥
		 * @param encoding 编码格式
		 * @return 布尔值
		 * @throws Exception 异常
		 */
		public static boolean verify(String content, String sign, String publicKey, String encoding) throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_RSA_SIGNATURE);
			return verify(content, sign, publicKey, algorithm, encoding);
		}

		/**
		 * RSA验签名检查
		 * @param content 待签名数据
		 * @param sign 签名值
		 * @param publicKey 公钥
		 * @param algorithm 算法
		 * @param encoding 编码格式
		 * @return 布尔值
		 * @throws Exception 异常
		 */
		public static boolean verify(String content, String sign, String publicKey, Algorithm algorithm, String encoding) throws Exception {
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
			byte[] encodedKey = Base64.decode(publicKey);
			PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

			Signature signature = Signature.getInstance(algorithm.getName());
			signature.initVerify(pubKey);
			signature.update(content.getBytes(encoding));

			return signature.verify(Base64.decode(sign));
		}

		public static String encryptByPrivateKey(String plaintext, String privateKey, String encoding) throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_RSA);
			return encryptByPrivateKey(plaintext, privateKey, algorithm, encoding);
		}

		public static String encryptByPrivateKey(String plaintext, String privateKey, Algorithm algorithm, String encoding)
				throws Exception {
			PrivateKey priKey = toPrivateKey(privateKey);

			Cipher cipher = Cipher.getInstance(algorithm.get());
			cipher.init(Cipher.ENCRYPT_MODE, priKey);

			return Base64.encode(cipher.doFinal(plaintext.getBytes(encoding)));
		}

		public static String encryptByPublicKey(String plaintext, String publicKey, String encoding) throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_RSA);
			return encryptByPublicKey(plaintext, publicKey, algorithm, encoding);
		}

		public static String encryptByPublicKey(String plaintext, String publicKey, Algorithm algorithm, String encoding) throws Exception {
			PublicKey pubKey = toPublicKey(publicKey);

			Cipher cipher = Cipher.getInstance(algorithm.get());
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);

			return Base64.encode(cipher.doFinal(plaintext.getBytes(encoding)));
		}

		/**
		 * 私钥解密
		 * @param ciphertext 密文
		 * @param privateKey 商户私钥
		 * @param encoding 编码格式
		 * @return 解密后的字符串
		 */
		public static String decryptByPrivateKey(String ciphertext, String privateKey, String encoding) throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_RSA);
			return decryptByPrivateKey(ciphertext, privateKey, algorithm, encoding);
		}

		public static String decryptByPrivateKey(String ciphertext, String privateKey, Algorithm algorithm, String encoding)
				throws Exception {
			PrivateKey priKey = toPrivateKey(privateKey);

			Cipher cipher = Cipher.getInstance(algorithm.get());
			cipher.init(Cipher.DECRYPT_MODE, priKey);

			return new String(cipher.doFinal(Base64.decode(ciphertext)), encoding);
		}

		public static String decryptByPublicKey(String ciphertext, String publicKey, String encoding) throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_RSA);
			return decryptByPublicKey(ciphertext, publicKey, algorithm, encoding);
		}

		public static String decryptByPublicKey(String ciphertext, String publicKey, Algorithm algorithm, String encoding) throws Exception {
			PublicKey pubKey = toPublicKey(publicKey);

			Cipher cipher = Cipher.getInstance(algorithm.get());
			cipher.init(Cipher.DECRYPT_MODE, pubKey);

			return new String(cipher.doFinal(Base64.decode(ciphertext)), encoding);
		}

		/**
		 * 得到私钥
		 * @param key 密钥字符串（经过base64编码）
		 * @throws Exception
		 */
		private static PrivateKey toPrivateKey(String key) throws Exception {
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decode(key));
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
			return keyFactory.generatePrivate(keySpec);
		}

		/**
		 * 得到私钥
		 * @param key 密钥字符串（经过base64编码）
		 * @throws Exception
		 */
		private static PublicKey toPublicKey(String key) throws Exception {
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decode(key));
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
			return keyFactory.generatePublic(keySpec);
		}
	}

	// --------------对称加密--------------

	public static class DES {

		/** DES与AES本质上类似，只是密钥生成策略不同而已.可选算法：DES、DESede */
		private static final String ALGORITHM_DES = "DES";

		public static String createKey() throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_DES);
			return createKey(null, algorithm);
		}

		public static String createKey(Algorithm algorithm) throws Exception {
			return createKey(null, algorithm);
		}

		public static String createKey(byte[] seed) throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_DES);
			return createKey(seed, algorithm);
		}

		public static String createKey(byte[] seed, Algorithm algorithm) throws Exception {
			SecureRandom secureRandom;
			if (seed != null) {
				secureRandom = new SecureRandom(seed);
			} else {
				secureRandom = new SecureRandom();
			}
			KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm.getName());
			keyGenerator.init(secureRandom);

			SecretKey secretKey = keyGenerator.generateKey();
			return Base64.encode((secretKey.getEncoded()));
		}

		public static String encrypt(String plaintext, String key, String encoding) throws Exception {
			return Base64.encode(encrypt(plaintext, Base64.decode(key), encoding));
		}

		public static byte[] encrypt(String plaintext, byte[] key, String encoding) throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_DES);
			return encrypt(plaintext, key, algorithm, encoding);
		}

		public static String encrypt(String plaintext, String key, Algorithm algorithm, String encoding) throws Exception {
			return Base64.encode(encrypt(plaintext, Base64.decode(key), algorithm, encoding));
		}

		public static byte[] encrypt(String plaintext, byte[] key, Algorithm algorithm, String encoding) throws Exception {
			Key k = toKey(key);

			Cipher cipher = Cipher.getInstance(algorithm.get());

			if ("CBC".equals(algorithm.getMode())) {
				IvParameterSpec iv = new IvParameterSpec(new byte[8]);
				cipher.init(Cipher.ENCRYPT_MODE, k, iv);
			} else {
				cipher.init(Cipher.ENCRYPT_MODE, k);
			}

			return cipher.doFinal(plaintext.getBytes(encoding));
		}

		public static String decrypt(String ciphertext, String key, String encoding) throws Exception {
			return decrypt(Base64.decode(ciphertext), Base64.decode(key), encoding);
		}

		public static String decrypt(byte[] ciphertext, byte[] key, String encoding) throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_DES);
			return decrypt(ciphertext, key, algorithm, encoding);
		}

		public static String decrypt(String ciphertext, String key, Algorithm algorithm, String encoding) throws Exception {
			return decrypt(Base64.decode(ciphertext), Base64.decode(key), algorithm, encoding);
		}

		public static String decrypt(byte[] ciphertext, byte[] key, Algorithm algorithm, String encoding) throws Exception {
			Key k = toKey(key);

			Cipher cipher = Cipher.getInstance(algorithm.get());

			if ("CBC".equals(algorithm.getMode())) {
				IvParameterSpec iv = new IvParameterSpec(new byte[8]);
				cipher.init(Cipher.DECRYPT_MODE, k, iv);
			} else {
				cipher.init(Cipher.DECRYPT_MODE, k);
			}

			return new String(cipher.doFinal(ciphertext), encoding);
		}

		private static Key toKey(byte[] key) throws Exception {
			DESKeySpec dks = new DESKeySpec(key);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM_DES);
			SecretKey secretKey = keyFactory.generateSecret(dks);
			return secretKey;
		}
	}

	public static class AES {

		/** AES、Blowfish、RC2、ARCFOUR/RC4 */
		private static final String ALGORITHM_AES = "AES";

		public static String createKey() throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_AES);
			return createKey(null, algorithm);
		}

		public static String createKey(Algorithm algorithm) throws Exception {
			return createKey(null, algorithm);
		}

		public static String createKey(byte[] seed) throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_AES);
			return createKey(seed, algorithm);
		}

		public static String createKey(byte[] seed, Algorithm algorithm) throws Exception {
			SecureRandom secureRandom;
			if (seed != null) {
				secureRandom = new SecureRandom(seed);
			} else {
				secureRandom = new SecureRandom();
			}
			KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm.getName());
			keyGenerator.init(secureRandom);

			SecretKey secretKey = keyGenerator.generateKey();
			return Base64.encode((secretKey.getEncoded()));
		}

		public static String encrypt(String plaintext, String key, String encoding) throws Exception {
			return Base64.encode(encrypt(plaintext, Base64.decode(key), encoding));
		}

		public static byte[] encrypt(String plaintext, byte[] key, String encoding) throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_AES);
			return encrypt(plaintext, key, algorithm, encoding);
		}

		public static String encrypt(String plaintext, String key, Algorithm algorithm, String encoding) throws Exception {
			return Base64.encode(encrypt(plaintext, Base64.decode(key), algorithm, encoding));
		}

		public static byte[] encrypt(String plaintext, byte[] key, Algorithm algorithm, String encoding) throws Exception {
			Key k = new SecretKeySpec(key, ALGORITHM_AES);

			Cipher cipher = Cipher.getInstance(algorithm.get());

			if ("CBC".equals(algorithm.getMode())) {
				IvParameterSpec iv = new IvParameterSpec(new byte[8]);
				cipher.init(Cipher.ENCRYPT_MODE, k, iv);
			} else {
				cipher.init(Cipher.ENCRYPT_MODE, k);
			}

			return cipher.doFinal(plaintext.getBytes(encoding));
		}

		public static String decrypt(String ciphertext, String key, String encoding) throws Exception {
			return decrypt(Base64.decode(ciphertext), Base64.decode(key), encoding);
		}

		public static String decrypt(byte[] ciphertext, byte[] key, String encoding) throws Exception {
			Algorithm algorithm = new Algorithm();
			algorithm.setName(ALGORITHM_AES);
			return decrypt(ciphertext, key, algorithm, encoding);
		}

		public static String decrypt(String ciphertext, String key, Algorithm algorithm, String encoding) throws Exception {
			return decrypt(Base64.decode(ciphertext), Base64.decode(key), algorithm, encoding);
		}

		public static String decrypt(byte[] ciphertext, byte[] key, Algorithm algorithm, String encoding) throws Exception {
			Key k = new SecretKeySpec(key, ALGORITHM_AES);

			Cipher cipher = Cipher.getInstance(algorithm.get());

			if ("CBC".equals(algorithm.getMode())) {
				IvParameterSpec iv = new IvParameterSpec(new byte[8]);
				cipher.init(Cipher.DECRYPT_MODE, k, iv);
			} else {
				cipher.init(Cipher.DECRYPT_MODE, k);
			}

			return new String(cipher.doFinal(ciphertext), encoding);
		}
	}

	public final static class Base64 {

		private static final int BASELENGTH = 128;
		private static final int LOOKUPLENGTH = 64;
		private static final int TWENTYFOURBITGROUP = 24;
		private static final int EIGHTBIT = 8;
		private static final int SIXTEENBIT = 16;
		private static final int FOURBYTE = 4;
		private static final int SIGN = -128;
		private static final char PAD = '=';
		private static final boolean fDebug = false;
		private static final byte[] base64Alphabet = new byte[BASELENGTH];
		private static final char[] lookUpBase64Alphabet = new char[LOOKUPLENGTH];

		static {
			for (int i = 0; i < BASELENGTH; ++i) {
				base64Alphabet[i] = -1;
			}
			for (int i = 'Z'; i >= 'A'; i--) {
				base64Alphabet[i] = (byte) (i - 'A');
			}
			for (int i = 'z'; i >= 'a'; i--) {
				base64Alphabet[i] = (byte) (i - 'a' + 26);
			}

			for (int i = '9'; i >= '0'; i--) {
				base64Alphabet[i] = (byte) (i - '0' + 52);
			}

			base64Alphabet['+'] = 62;
			base64Alphabet['/'] = 63;

			for (int i = 0; i <= 25; i++) {
				lookUpBase64Alphabet[i] = (char) ('A' + i);
			}

			for (int i = 26, j = 0; i <= 51; i++, j++) {
				lookUpBase64Alphabet[i] = (char) ('a' + j);
			}

			for (int i = 52, j = 0; i <= 61; i++, j++) {
				lookUpBase64Alphabet[i] = (char) ('0' + j);
			}
			lookUpBase64Alphabet[62] = (char) '+';
			lookUpBase64Alphabet[63] = (char) '/';

		}

		private static boolean isWhiteSpace(char octect) {
			return (octect == 0x20 || octect == 0xd || octect == 0xa || octect == 0x9);
		}

		private static boolean isPad(char octect) {
			return (octect == PAD);
		}

		private static boolean isData(char octect) {
			return (octect < BASELENGTH && base64Alphabet[octect] != -1);
		}

		/**
		 * Encodes hex octects into Base64
		 * @param binaryData Array containing binaryData
		 * @return Encoded Base64 array
		 */
		public static String encode(byte[] binaryData) {

			if (binaryData == null) {
				return null;
			}

			int lengthDataBits = binaryData.length * EIGHTBIT;
			if (lengthDataBits == 0) {
				return "";
			}

			int fewerThan24bits = lengthDataBits % TWENTYFOURBITGROUP;
			int numberTriplets = lengthDataBits / TWENTYFOURBITGROUP;
			int numberQuartet = fewerThan24bits != 0 ? numberTriplets + 1 : numberTriplets;
			char encodedData[] = null;

			encodedData = new char[numberQuartet * 4];

			byte k = 0, l = 0, b1 = 0, b2 = 0, b3 = 0;

			int encodedIndex = 0;
			int dataIndex = 0;
			if (fDebug) {
				System.out.println("number of triplets = " + numberTriplets);
			}

			for (int i = 0; i < numberTriplets; i++) {
				b1 = binaryData[dataIndex++];
				b2 = binaryData[dataIndex++];
				b3 = binaryData[dataIndex++];

				if (fDebug) {
					System.out.println("b1= " + b1 + ", b2= " + b2 + ", b3= " + b3);
				}

				l = (byte) (b2 & 0x0f);
				k = (byte) (b1 & 0x03);

				byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2) : (byte) ((b1) >> 2 ^ 0xc0);
				byte val2 = ((b2 & SIGN) == 0) ? (byte) (b2 >> 4) : (byte) ((b2) >> 4 ^ 0xf0);
				byte val3 = ((b3 & SIGN) == 0) ? (byte) (b3 >> 6) : (byte) ((b3) >> 6 ^ 0xfc);

				if (fDebug) {
					System.out.println("val2 = " + val2);
					System.out.println("k4   = " + (k << 4));
					System.out.println("vak  = " + (val2 | (k << 4)));
				}

				encodedData[encodedIndex++] = lookUpBase64Alphabet[val1];
				encodedData[encodedIndex++] = lookUpBase64Alphabet[val2 | (k << 4)];
				encodedData[encodedIndex++] = lookUpBase64Alphabet[(l << 2) | val3];
				encodedData[encodedIndex++] = lookUpBase64Alphabet[b3 & 0x3f];
			}

			// form integral number of 6-bit groups
			if (fewerThan24bits == EIGHTBIT) {
				b1 = binaryData[dataIndex];
				k = (byte) (b1 & 0x03);
				if (fDebug) {
					System.out.println("b1=" + b1);
					System.out.println("b1<<2 = " + (b1 >> 2));
				}
				byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2) : (byte) ((b1) >> 2 ^ 0xc0);
				encodedData[encodedIndex++] = lookUpBase64Alphabet[val1];
				encodedData[encodedIndex++] = lookUpBase64Alphabet[k << 4];
				encodedData[encodedIndex++] = PAD;
				encodedData[encodedIndex++] = PAD;
			} else if (fewerThan24bits == SIXTEENBIT) {
				b1 = binaryData[dataIndex];
				b2 = binaryData[dataIndex + 1];
				l = (byte) (b2 & 0x0f);
				k = (byte) (b1 & 0x03);

				byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2) : (byte) ((b1) >> 2 ^ 0xc0);
				byte val2 = ((b2 & SIGN) == 0) ? (byte) (b2 >> 4) : (byte) ((b2) >> 4 ^ 0xf0);

				encodedData[encodedIndex++] = lookUpBase64Alphabet[val1];
				encodedData[encodedIndex++] = lookUpBase64Alphabet[val2 | (k << 4)];
				encodedData[encodedIndex++] = lookUpBase64Alphabet[l << 2];
				encodedData[encodedIndex++] = PAD;
			}

			return new String(encodedData);
		}

		/**
		 * Decodes Base64 data into octects
		 * @param encoded string containing Base64 data
		 * @return Array containind decoded data.
		 */
		public static byte[] decode(String encoded) {

			if (encoded == null) {
				return null;
			}

			char[] base64Data = encoded.toCharArray();
			// remove white spaces
			int len = removeWhiteSpace(base64Data);

			if (len % FOURBYTE != 0) {
				return null;//should be divisible by four
			}

			int numberQuadruple = (len / FOURBYTE);

			if (numberQuadruple == 0) {
				return new byte[0];
			}

			byte decodedData[] = null;
			byte b1 = 0, b2 = 0, b3 = 0, b4 = 0;
			char d1 = 0, d2 = 0, d3 = 0, d4 = 0;

			int i = 0;
			int encodedIndex = 0;
			int dataIndex = 0;
			decodedData = new byte[(numberQuadruple) * 3];

			for (; i < numberQuadruple - 1; i++) {

				if (!isData((d1 = base64Data[dataIndex++])) || !isData((d2 = base64Data[dataIndex++]))
						|| !isData((d3 = base64Data[dataIndex++])) || !isData((d4 = base64Data[dataIndex++]))) {
					return null;
				}//if found "no data" just return null

				b1 = base64Alphabet[d1];
				b2 = base64Alphabet[d2];
				b3 = base64Alphabet[d3];
				b4 = base64Alphabet[d4];

				decodedData[encodedIndex++] = (byte) (b1 << 2 | b2 >> 4);
				decodedData[encodedIndex++] = (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
				decodedData[encodedIndex++] = (byte) (b3 << 6 | b4);
			}

			if (!isData((d1 = base64Data[dataIndex++])) || !isData((d2 = base64Data[dataIndex++]))) {
				return null;//if found "no data" just return null
			}

			b1 = base64Alphabet[d1];
			b2 = base64Alphabet[d2];

			d3 = base64Data[dataIndex++];
			d4 = base64Data[dataIndex++];
			if (!isData((d3)) || !isData((d4))) {//Check if they are PAD characters
				if (isPad(d3) && isPad(d4)) {
					if ((b2 & 0xf) != 0)//last 4 bits should be zero
					{
						return null;
					}
					byte[] tmp = new byte[i * 3 + 1];
					System.arraycopy(decodedData, 0, tmp, 0, i * 3);
					tmp[encodedIndex] = (byte) (b1 << 2 | b2 >> 4);
					return tmp;
				} else if (!isPad(d3) && isPad(d4)) {
					b3 = base64Alphabet[d3];
					if ((b3 & 0x3) != 0)//last 2 bits should be zero
					{
						return null;
					}
					byte[] tmp = new byte[i * 3 + 2];
					System.arraycopy(decodedData, 0, tmp, 0, i * 3);
					tmp[encodedIndex++] = (byte) (b1 << 2 | b2 >> 4);
					tmp[encodedIndex] = (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
					return tmp;
				} else {
					return null;
				}
			} else { //No PAD e.g 3cQl
				b3 = base64Alphabet[d3];
				b4 = base64Alphabet[d4];
				decodedData[encodedIndex++] = (byte) (b1 << 2 | b2 >> 4);
				decodedData[encodedIndex++] = (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
				decodedData[encodedIndex++] = (byte) (b3 << 6 | b4);

			}

			return decodedData;
		}

		/**
		 * remove WhiteSpace from MIME containing encoded Base64 data.
		 * @param data the byte array of base64 data (with WS)
		 * @return the new length
		 */
		private static int removeWhiteSpace(char[] data) {
			if (data == null) {
				return 0;
			}

			// count characters that's not whitespace
			int newSize = 0;
			int len = data.length;
			for (int i = 0; i < len; i++) {
				if (!isWhiteSpace(data[i])) {
					data[newSize++] = data[i];
				}
			}
			return newSize;
		}
	}

	public static class Algorithm {
		/** 名称 */
		private String name;
		/** 模式 */
		private String mode;
		/** 填充方式 */
		private String padding;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMode() {
			return mode;
		}

		public void setMode(String mode) {
			this.mode = mode;
		}

		public String getPadding() {
			return padding;
		}

		public void setPadding(String padding) {
			this.padding = padding;
		}

		public String get() {
			if (mode == null || padding == null) {
				return name;
			}
			return name + '/' + mode + '/' + padding;
		}
	}

	/**
	 * 方法: toHex <br>
	 * 描述: 转16进制 <br>
	 * 作者: 王鹏 wangpeng@itkt.com <br>
	 * 时间: 2014-5-14 下午03:33:30
	 */
	private static String toHex(byte[] byteArray) {
		StringBuffer strBuffer = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			String hexStr = Integer.toHexString(0xFF & byteArray[i]);
			if (hexStr.length() == 1)
				strBuffer.append("0").append(hexStr);
			else
				strBuffer.append(hexStr);
		}
		return strBuffer.toString();
	}
}
