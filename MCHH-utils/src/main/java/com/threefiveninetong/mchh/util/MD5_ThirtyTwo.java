package com.threefiveninetong.mchh.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5_ThirtyTwo {
    public static final String MD5_DESC = "MD5";

    public MD5_ThirtyTwo() {
    }

    public static byte[] calcMD5Sum(InputStream is) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = null;
        int bufSize = 2048;
        byte[] buf = new byte[bufSize];
        int byteCount = 0;
        md = MessageDigest.getInstance(MD5_ThirtyTwo.MD5_DESC);
        do {
            byteCount = is.read(buf, 0, bufSize);
            md.update(buf, 0, byteCount);
        } while (byteCount == bufSize);
        buf = null;
        return md.digest();
    }

    public static String bytesToHexString(byte[] in) {
        StringBuffer sb = new StringBuffer();
        String temp = null;
        for (int i = 0; i < in.length; i++) {
            sb.append(byteToHexString(in[i]));
        }
        return sb.toString();
    }

    public static String byteToHexString(byte b) {
        StringBuffer result = new StringBuffer(2);
        String temp = Integer.toHexString(b >= 0 ? b : (b + 256));
        if (temp.length() == 1) {
            result.append("0");
        }
        result.append(temp);
        return result.toString();
    }

    /**
     * 
     * @param fn���ļ���
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static byte[] calcFileMD5Sum(String fn) throws IOException, NoSuchAlgorithmException {
        return MD5_ThirtyTwo.calcMD5Sum(new FileInputStream(fn));
    }

    public static String getFileMD5Sum(String fn) {
        String result = null;
        try {
            result = MD5_ThirtyTwo.bytesToHexString(MD5_ThirtyTwo.calcFileMD5Sum(fn));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    // MD5�ַ������� (32λ)
    public static String getMD5Message(String ms) {
        try {
            java.security.MessageDigest alg = java.security.MessageDigest.getInstance(MD5_DESC);
            alg.update(ms.getBytes());
            byte[] digesta = alg.digest();
            return bytesToHexString(digesta);
        } catch (java.security.NoSuchAlgorithmException ex) {
            return null;
        }
    }
}
