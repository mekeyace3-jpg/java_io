package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//Stream : byte 자료형 (txt.jpg,png,mp3,mp4...)
public class io7 {

	public static void main(String[] args) {
		try {
			String url = "d:\\java_io\\array.txt";
			FileInputStream fs = new FileInputStream(url);		
			System.out.println(fs.available());	//파일의 저장 총 용량
			byte temp[] = new byte[fs.available()];
			fs.read(temp);	//=> stream에서는 read를 사용하지 않을 경우 로드
			String word = new String(temp);	//문자열로 반영
			System.out.println(word);	//데이터를 출력
			fs.close();	//IO 종료
			
			new io7_box().abc();
			
		}catch (Exception e) {
			e.getMessage();
		}
	}
}


/*
InputStream : 파일을 읽어들임 (read)
OuputStream : 파일을 저장함 (write)
*/
class io7_box{
	
	public void abc() {
			try {
				String url = "d:\\java_io\\product.txt";
				String data = "자바 스트림 연습 중입니다.";
				FileOutputStream os = new FileOutputStream(url,true);
				byte[] by = data.getBytes();
				os.write(by);
				os.flush();	//Stream에 있는 잔류 byte를 모두 출력 후 빈공간으로 변경하는 역활
				os.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
}


