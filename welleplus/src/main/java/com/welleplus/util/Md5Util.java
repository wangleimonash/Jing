package com.welleplus.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Md5Util{
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String str = "admin";
		System.out.println(md5String(str));
	}
	
	public static String md5String(String str){
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64 = new BASE64Encoder();
			str = base64.encode(md5.digest(str.getBytes("utf-8")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

}
