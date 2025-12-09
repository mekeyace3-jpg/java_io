package io;
/*
 I/O : inputStream, outputStream => try~catch
 입력 스트림 : 데이터를 입력하는 형태 (키보드, 마우스, load)
 출력 스트림 : 데이터를 출력하는 형태 (모니터, 프린터, save)
 File, FileReader (일반) => InputStream
 FileWrite => OutputStream
 */
import java.io.*;
import java.nio.charset.Charset;
//‪D:\java_io\list1.txt
public class io1 {
	public static void main(String[] args) {
		//FileReader : 해당 경록에서 파일을 load하는 역활
		FileReader fr = null;
		try {
			//Charset.forName : JAVA9 => EUC_KR or EUCKR (ANSI), UTF-8 or UTF8, UTF-16 or UTF16
			fr = new FileReader("D:\\java_io\\list1.txt",Charset.forName("UTF8"));
			System.out.println(fr.getEncoding());	//파일의 인코더 형식
			System.out.println(fr.read());	//파일에 데이터 크기
			
			while(true) {
					int m = fr.read();		
					System.out.println(m);	//2byte 를 읽어 들임
					System.out.println((char)m);	//char 자료형으로 byte를 변환
					if(m == -1) {
							break;
					}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				fr.close();
			}catch (Exception e) {
				System.out.println("파일 종료를 제대로 실행하지 못하였습니다.");
			}
		}
	}
}
