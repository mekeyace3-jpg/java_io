package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//Stream => 이미지
public class io9 {

	public static void main(String[] args) {
		String url = "d:\\java_io\\apink_love.jpg";
		try {
			/*  //일반 복사 형태 
			FileInputStream fs = new FileInputStream(url);
			byte[] by = new byte[fs.available()];
			fs.read(by);
			
			String url2 = "d:\\java_io\\apink.jpg";
			FileOutputStream os = new FileOutputStream(url2);
			os.write(by);
			os.flush();
			os.close();
			fs.close();
			*/
			//반복문으로 활용하여 progress를 구현
			FileInputStream fs = new FileInputStream(url);
			//전체 파일의 총 욜양을 100으로 나누어서 용량을 읽어들임
			byte[] by = new byte[fs.available()/100];	
			
			//신규 이름으로 해당 파일을 생성 및 저장 코드
			String url2 = "d:\\java_io\\apink.jpg";
			FileOutputStream os = new FileOutputStream(url2);
			
			int i = 0;	//읽은 바이트 수
			int check = 0;	//읽은 횟수
			while(true) {	//무한루프를 이용하여 전체 용량을 모두 읽어들일 수 있도록 함
				i = fs.read(by);  //byte 숫자(전체용량을/100) => 분해해서 용량을 읽음
				if(i == -1) {
					break;
				}
				else {
					//해당 byte만큼 지속적으로 이미지 용량을 조합 
					os.write(by,0,i); //(byte객체명,시작하는 시작 byte숫자, 끝나는 byte숫자)
				}
				
				//다운로드에 대한 이미지 결합에 대한 진행율을 확인하는 코드
				check++;
				if(check % 2 == 0) {
					System.out.println("현재 다운로드 진행율 : " + check + "%");
				}
			}
			os.flush();
			os.close();
			fs.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
