package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

//Array + 파일생성
public class io11 {

	public static void main(String[] args) {
		String url = "d:\\java_io\\";
		String file_name[] = {"list1.txt","apink_love.jpg","blackdesert.webm"};
		
		for(int f = 0;  f < file_name.length; f++) {
		
		
		//. 기준으로 속성 타입을 가져오기 위한 문자의 위치 파악
		int n = file_name[f].lastIndexOf(".");	
		//substring => 해당 단어 기준의 노드 번호를 기점으로 문자를 가져옴
		String type = file_name[f].substring(n);
		
		//파일을 숫자화 하여 속성을 적용한 후 생성되도록 함
		String file_rename = "";
		Random rd = new Random();
		int w = 0;
		while(w < 6) {
		int nos = rd.nextInt(10);
			file_rename += nos;
			w++;
		}
		
		try {
			//파일 복사를 시작
			FileInputStream fs = new FileInputStream(url + file_name[f]);
			byte[] by = new byte[fs.available()];
			fs.read(by);
			
			//복사할 경로
			String copyurl = "c:\\io\\";
			//복사할 경로 + 새로운 파일명 + 파일속성
			FileOutputStream os = new FileOutputStream(copyurl+file_rename+type);
			os.write(by);	//파일 저장
			os.flush();		//캐쉬메모리 공간확보
			
			os.close();
			fs.close();
		}
		catch (Exception e) {
			System.out.println("파일 복사시 오류발생!!");
		}
		
		}
		
		System.out.println("해당 배열에 있는 모든 파일을 정상적으로 복사 하였습니다.");
		
	}

}
