package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//Buffered : byte의 내용을 temp 임시 실제 메모리에 저장
/*
 Buffering 사용전 => SSD,HDD => 외부 장치 접근시 성능저하 발생(파일로드)
 Buffered => 실제 메모리를 활용하여 미리 파일에 대한 전체 용량을 읽어옵니다.
 (오류발생시에도 메모리에 저장된 사항이므로 가능함)
 저장시에도 Buffered 모든 데이터를 순차적으로 저장할 수 있음.  
 
 - Stream(byte) => BufferedInputStream, BufferedOutputStream
 - Read/Write(문자) => BufferedReader, BufferedWriter
*/
public class io14 {
	public static void main(String[] args) {
		String ori = "d:\\java_io\\123.jpg";
		String copy_url = "c:\\io\\123.jpg";
		//CDN, Streaming  서버에 주로 활용 됩니다.
		try {
			//InputStream : 입력부모 Stream
			InputStream is = new FileInputStream(ori);
			//SSD,HDD => Memory에 할당
			BufferedInputStream bs = new BufferedInputStream(is);
			//OutputStream : 출력부모 Stream
			OutputStream os = new FileOutputStream(copy_url);
			//Memory => SSD,HDD 저장
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			if(bs.available() > 10485760) {
				System.out.println("이미지는 최대 10MB 이하의 파일만 업로드 가능");
			}
			else {
				//메모리 버퍼를 얼만큼 사용할 것인지 정함
				byte[] by = new byte[bs.available()];
				int read;
				
				//개발자가 설정한 메모리 규격에 맞게 파일을 핸들링
				while((read=bs.read(by)) != -1) {
					bos.write(by,0,read);
				}
				
				bos.flush();	//Buffered에서는 필수
				bos.close();
				os.close();
				bs.close();
				is.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
