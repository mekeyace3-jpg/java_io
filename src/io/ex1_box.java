package io;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

//MD5 암호화 인코딩 작업을 하는 class
public class ex1_box {
	String security = "";	//사용자가 입력한 내용을 암호화 하여 저장하는 변수
	
	//base64 (복호화)
	public String base64_decode(String word) {
		try {
			byte[] repw = word.getBytes();
			Decoder dc = Base64.getDecoder();
			byte[] bs64 = dc.decode(repw);
			this.security = new String(bs64);
		} catch (Exception e) {
			this.security = "올바른 데이터가 아닙니다.";
		}
		return this.security;
	}
	
	
	//base64 (암호화)
	public String base64_encode(String word) {
		try {
			byte[] repw = word.getBytes();
			Encoder ec = Base64.getEncoder();
			byte[] bs64 = ec.encode(repw);
			this.security = new String(bs64);
		} catch (Exception e) {
			this.security = "올바른 데이터가 아닙니다.";
		}
		return this.security;
	}
	
	
	//sha1 암호화 메소드
	public String sha1_encode(String word) {
		
		return null;
	}
	
	//md5 암호화 메소드
	public String md5_encode(String word) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] repw = word.getBytes();
			md.update(repw);
			byte md5_pw[] = md.digest();
			for(byte s : md5_pw) {
				this.security += String.format("%x", s);
			}
		} catch (Exception e) {
			this.security = "올바른 데이터가 아닙니다.";
		}
		return this.security;
	}
	
}
