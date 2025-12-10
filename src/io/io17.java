package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
/*
 InputStream > InputStreamreader > BufferedReader (O)
 InputStream > BufferedInputStream (O)
 InputStream > BufferedReader(X)
 FileWriter > OutputStream (X) 
 */

//Stream => Reader
public class io17 {
	public static void main(String[] args) {
		
		String url = "d:\\java_io\\home.svg";
		try {
		InputStream is = new FileInputStream(url);	//byte
		//Stream -> Reader (언어셋 변경가능)
		InputStreamReader isr = new InputStreamReader(is,"EUC-KR");
		//InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr); //String
		//System.out.println(br.readLine());
		
		br.close();
		isr.close();
		is.close();
		
		//Reader => Stream	
		FileReader fr = new FileReader(url);	//파일 로드
		BufferedReader br2 = new BufferedReader(fr);	//메모리 저장
		
		byte[] by = null;	//빈 원시 배열 => Stream 전달
		String a = "";	//BufferedReader의 값을 받는 변수
		String b = "";	//a의 데이터값을 누적시킴
		while((a = br2.readLine())!=null) {
			b += a;
		}
		by = b.getBytes(); //문자 => byte
		
		//ByteArrayInputStream : byte[] 원시 형태를 가져오는 Stream
		InputStream is2 = new ByteArrayInputStream(by); //byte
		BufferedInputStream bis = new BufferedInputStream(is2);
		byte file[] = new byte[bis.available()];
		//bis.read(file);
		String copy_url = "c:\\io\\1111.txt"; //복사할 위치
		OutputStream os = new FileOutputStream(copy_url);
		BufferedOutputStream bos = new BufferedOutputStream(os);
		int read;
		while((read=bis.read(file)) != -1) {
			bos.write(by,0,read);
		}
		bos.close();
		os.close();
		is2.close();
		br2.close();
		fr.close();
		}catch (Exception e) {
			System.out.println("해당 파일이 올바르지 않습니다.");
		}
	}
}
