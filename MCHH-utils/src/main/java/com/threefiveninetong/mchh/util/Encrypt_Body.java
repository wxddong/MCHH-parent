package com.threefiveninetong.mchh.util;
public class Encrypt_Body {
	public static int M1 = 0xFAFBF9F8;
	public static int IA1 = 0xACABA5A1;
	public static int IC1 = 0xC2C7CACD;

	public static byte[] Encrypt(int KEY, byte[] buffer, int begin, int end) {
		byte[] Buf = new byte[end - begin];
		int idx = 0, i = 0;
		int sKey = 0;
		sKey = KEY;
		byte middle;
		if (sKey == 0) {
			sKey = 1;
		}
		for (idx = begin; idx < end; idx++) {
			sKey = (sKey % M1) * IA1 + IC1;
			middle = (byte) ((sKey >> 20) & 0xFF);
			Buf[i] = (byte) (buffer[idx] ^ middle);
			i++;
		}
		return Buf;
	}

	public static void main(String[] args) {
		Encrypt_Body a = new Encrypt_Body();
		int KEY = 24438733;
		byte[] buffer = { (byte) 0x01, (byte) 0x03 };
		byte[] sc = a.Encrypt(KEY, buffer, 0, buffer.length);
		System.out.println(sc);
		byte[] sa = a.Encrypt(KEY, sc, 0, sc.length);
		System.out.println(sa);
	}
}
