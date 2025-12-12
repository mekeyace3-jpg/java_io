package io;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.*;  //Decoder(복호화), Encoder(암호화)

//encryption => 암호화
public class encry {
	public static void main(String[] args) {
		//Base64 => 기본 암호화
		//encoder => 문자를 암호화
		String password = "a123456";
		byte[] word = password.getBytes();
		Encoder bs = Base64.getEncoder();
		byte[] word2 = bs.encode(word);
		System.out.println(new String(word2));
		
		//decoder => 암호화 문자를 원본 문자로 복호화
		String password2 = "aG9uZ19hMTIzNDU2";
		byte[] word3 = password2.getBytes();
		Decoder bs2 = Base64.getDecoder();
		byte[] word4 = bs2.decode(word3);
		System.out.println(new String(word4,StandardCharsets.US_ASCII));
		
		new encry_box().abc();
	}
}
//개인정보 => 패스워드, 카드정보(Base64) => pg, 결제시 => sha-1, 로그기록, 계좌비밀번호
//비대칭키 암호화 => AES,DES,RSA,ECC
class encry_box{
	//MD5 ~ SHA => 복호화(X)
	//SHA-3 => JDK 10이상 추천
	//MD5,SHA(SHA-1, SHA-2(224,256,384,512), SHA-3(HASH) - (SHA3-256) 224~512) => byte
	public void abc() {
		String pw = "a1234";
		try {
			//MessageDigest => 해당 문자열을 암호화 형태로 구성하는 클래스
			MessageDigest md = MessageDigest.getInstance("SHA3-256");
			//byte[] repw = pw.getBytes();
			md.update(pw.getBytes());	//해당 문자열을 byte 단위로 변경
			byte md5_pw[] = md.digest();	//byte로 변화된 값을 return
			
			String sb = "";
			//어떤 형태로 암호화를 구성화 할 것인지를 정합니다.
			for(byte a : md5_pw) {
				//%x (소문자 영문), %X (대문자 영문) - a~f 까지만 조합
				//0123456789 10(a) 12(b) 13 14 15(f)
				//%01x => 1자리 문자 1234 => 1,2,3,4
				//%02x => 2자리 문자 1234 => 01,02,03,04
				sb += String.format("%02x", a); //%x => 영문+숫자 조합 (16진수 Hex)
			}
			System.out.println(sb);
			
		}catch (Exception e) {
			
		}
	}
}
