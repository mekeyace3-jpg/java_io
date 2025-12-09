package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//동영상 Stream으로 처리
public class io10 {
	public static void main(String[] args) {
		String url = "";
		Scanner sc = new Scanner(System.in);
		try {
		System.out.println("복사할 동영상 경로를 입력하세요 : ");
		url = sc.nextLine();
		FileInputStream fs = new FileInputStream(url);
		byte[] file = new byte[fs.available()];
		fs.read(file);
		/* 
		같은 파일명일 같을 경우 덮어쓰기가 적용됩니다.
		yyyyMMddHHmmss => 파일명  
		random() => yyyyMMdd_숫자 8자리   
		random() => yyyyMMddHHmmss_숫자 8자리  
		*/
		Date dt = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String rename = df.format(dt); 
		
		String copys = "c:\\io\\"+rename+".mpeg";
		FileOutputStream os = new FileOutputStream(copys);
		os.write(file);
		os.flush();
		os.close();
		fs.close();
		sc.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
