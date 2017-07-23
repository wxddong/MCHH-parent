package com.threefiveninetong.mchh.util;
//package cn.leifeng.core.util;
//
//import java.io.UnsupportedEncodingException;
//import java.security.NoSuchAlgorithmException;
//
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//
//public class CryptUtils {
//
//    /**
//     * CryptUtils.
//     */
//    private CryptUtils() {
//    }
//
//    /**
//     * 生成3DES密钥.
//     * 
//     * @param key_byte
//     *            seed key
//     * @throws Exception
//     * @return javax.crypto.SecretKey Generated DES key
//     */
//    public static javax.crypto.SecretKey genDESKey(byte[] key_byte) {
//        SecretKey k = null;
//        k = new SecretKeySpec(key_byte, "DESede");
//        return k;
//    }
//
//    /**
//     * 3DES 解密(byte[]).
//     * 
//     * @param key
//     *            SecretKey
//     * @param crypt
//     *            byte[]
//     * @throws Exception
//     *             异常
//     * @return byte[]
//     */
//    public static byte[] desDecrypt(javax.crypto.SecretKey key, byte[] crypt) throws Exception {
//        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede");
//        cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key);
//        return cipher.doFinal(crypt);
//    }
//
//    /**
//     * 3DES加密(byte[]).
//     * 
//     * @param key
//     *            SecretKey
//     * @param src
//     *            byte[]
//     * @throws Exception
//     *             异常
//     * @return byte[]
//     */
//    public static byte[] desEncrypt(javax.crypto.SecretKey key, byte[] src) throws Exception {
//        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede");
//        cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
//        return cipher.doFinal(src);
//    }
//
//
//    /**
//     * MD5 摘要计算(byte[]).
//     * 
//     * @param src
//     *            byte[]
//     * @throws NoSuchAlgorithmException
//     *             异常
//     * @return byte[] 16 bit digest
//     */
//    public static byte[] md5Digest(byte[] src) throws NoSuchAlgorithmException {
//        java.security.MessageDigest alg = java.security.MessageDigest.getInstance("MD5");
//        // MD5 is 16 bit message digest
//
//        return alg.digest(src);
//    }
//
//    /**
//     * MD5 摘要计算(String).
//     * 
//     * @param src
//     *            String
//     * @throws Exception
//     * @return String
//     */
//    public static String md5DigestToString(byte[] src) {
//        try {
//            return toHex(md5Digest(src));
//        }
//        catch (NoSuchAlgorithmException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//    
//    /**
//     * MD5 摘要计算(String).
//     * 
//     * @param src
//     *            String
//     * @throws Exception
//     * @return String
//     */
//    public static String md5Digest(String src) {
//        try {
//            return toHex(md5Digest(src.getBytes()));
//        }
//        catch (NoSuchAlgorithmException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//    
//    /**
//     * md5Digest.
//     * 
//     * @param src
//     *            char[]
//     * @return String
//     */
//    public static String md5Digest(char[] src){
//        try {
//            return toHex(md5Digest(String.valueOf(src).getBytes()));
//        }
//        catch (NoSuchAlgorithmException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//    /**
//     * BASE64 编码.
//     * 
//     * @param src
//     *            String inputed string
//     * @return String returned string
//     */
//    public static String base64Encode(String src) {
//        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
//
//        return encoder.encode(src.getBytes());
//    }
//
//    /**
//     * BASE64 编码(byte[]).
//     * 
//     * @param src
//     *            byte[] inputed string
//     * @return String returned string
//     */
//    public static String base64Encode(byte[] src) {
//        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
//
//        return encoder.encode(src);
//    }
//
//    /**
//     * BASE64 解码.
//     * 
//     * @param src
//     *            String inputed string
//     * @return String returned string
//     */
//    public static String base64Decode(String src) {
//        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
//
//        try {
//            return new String(decoder.decodeBuffer(src));
//        }
//        catch (Exception ex) {
//            return null;
//        }
//
//    }
//
//    /**
//     * BASE64 解码(to byte[]).
//     * 
//     * @param src
//     *            String inputed string
//     * @return String returned string
//     */
//    public static byte[] base64DecodeToBytes(String src) {
//        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
//
//        try {
//            return decoder.decodeBuffer(src);
//        }
//        catch (Exception ex) {
//            return null;
//        }
//
//    }
//
//    /**
//     * 对给定字符进行 URL 编码.
//     * 
//     * @param src
//     *            String
//     * @return String
//     * @throws UnsupportedEncodingException
//     *             异常
//     */
//    public static String urlEncode(String src) throws UnsupportedEncodingException {
//        return java.net.URLEncoder.encode(src, "GB2312");
//    }
//
//    /**
//     * 对给定字符进行 URL 解码.
//     * 
//     * @param value
//     *            解码前的字符串
//     * @return 解码后的字符串
//     * @throws UnsupportedEncodingException
//     *             异常
//     */
//    public String urlDecode(String value) throws UnsupportedEncodingException {
//        return java.net.URLDecoder.decode(value, "GB2312");
//    }
//    
//	private final static byte key = 0x1f;
//	
//	/**
//	 * 加密
//	 * @param str 明文字符串
//	 * @return 加密后的字符串
//	 */
//	public static String simpleEncrypt(String str){
//		if(str == null){
//			return null;
//		}
//		if(str.length() == 0){
//			return str;
//		}
//		str = "s" + str;
//		try {
//			byte[] bs = str.getBytes("GBK");			
//			byte firstByte = bs[0];
//
//			for (int i = 0; i < bs.length - 1 ; i++) {
//				byte fir3 = (byte) (bs[i] & 0xE0); // 前面3个bit
//				byte end5 = (byte) (bs[i+1] & 0x1F); // 最后5个bit				
//				end5 = (byte) (end5 ^ key);
//				bs[i] = (byte) (fir3 | (end5 & 0x1f));
//			}
//			
//			byte fir3 = (byte) (bs[bs.length - 1] & 0xE0); // 前面3个bit
//			byte end5 = (byte) (firstByte & 0x1F); // 最后5个bit
//			end5 = (byte) (end5 ^ key);
//			bs[bs.length - 1] = (byte) (fir3 | (end5 & 0x1f));		
//			
//			return new String(bs, "GBK");
//		}
//		catch(Exception e){
//			throw new RuntimeException(e);
//		}		 
//	}
//	
//	
//	/**
//	 * 解密
//	 * @param enStr 用简单加密加密后的字符串
//	 * @return 明文串
//	 */
//	public static String  simpleDecrypt(String enStr) {
//		if (enStr == null) {
//			return null;
//		}
//		if (enStr.length() == 0) {
//			return enStr;
//		}
//		
//		try {
//			byte[] bs = enStr.getBytes("GBK");			
//			byte lastByte = bs[bs.length - 1];
//
//			for (int i = bs.length - 1; i > 0 ; i--) {
//				byte fir3 = (byte) (bs[i] & 0xE0); // 前面3个bit
//				byte last5 = (byte) (bs[i-1] & 0x1F); // 最后5个bit
//				last5 = (byte) (last5 ^ key);							
//				bs[i] = (byte) (fir3 | (last5 & 0x1f));					
//			}
//			
//			byte fir = (byte) (bs[0] & 0xE0); // 前面3个bit
//			byte last5 = (byte) (lastByte & 0x1F); // 最后5个bit
//			last5 = (byte) (last5 ^ key);							
//			bs[0] = (byte) (fir | (last5 & 0x1f));			
//			
//			byte[] factBs = new byte[bs.length - 1];
//			System.arraycopy(bs, 1, factBs, 0, factBs.length);
//			
//			return new String(factBs, "GBK");
//		}
//		catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//	/**
//	 * 
//	 * @param hash
//	 * @return
//	 */
//	public static String toHex(byte[] hash) {
//		StringBuffer buf = new StringBuffer(hash.length * 2);
//		int i;
//
//		for (i = 0; i < hash.length; i++) {
//			if(((int)hash[i] & 0xff) < 0x10) {
//				buf.append("0");
//			}
//			buf.append(Long.toString((int)hash[i] & 0xff, 16));
//		}
//		return buf.toString();
//	}	
//}
