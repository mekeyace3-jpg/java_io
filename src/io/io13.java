package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
http://mekeyace.kbsn.or.kr/images.zip
응용문제2
해당 경로에 images라는 디렉토리가 있습니다.
해당 디렉토리에 있는 이미지를 활용하여 다음과 같이 c:\travel에
정상적으로 이미지가 반영 되도록 코드를 작성해 주시면 됩니다.
[실행] - c:\travel 디렉토리 안에 생성
호텔 이미지를 등록할 디렉토리명을 입력하세요 : 
펜션 이미지를 등록할 디렉토리명을 입력하세요 :

hotel로 시작하는 파일은 => 호텔 이미지를 저장하는 디렉토리에 복사되며
vectors로 시작하는 파일은 => 펜션 이미지를 저장하는 디렉토리에 복사 되어야 합니다.

단, 저장시 년월일 형태의 중복되지 않은 파일명으로 다음과 같이 파일명을 설정하십시오.
예시) hotel_20251209155506.jpg 입니다.
*/
public class io13 {
	public static void main(String[] args) throws Exception {
		new io13().file_search();
	}
	
	io13_box ib = new io13_box();
	Scanner sc = null;
	String ori_url = "d:\\java_io\\images";	//원본이 있는 경로
	String dir = "c:\\";	//사본이 만들어지는 경로
	FileInputStream fs = null;
	FileOutputStream os = null;
	String user1,user2;		//호텔 및 펜션 디렉토리 이름이 저장되는 변수
	
	public void file_search() throws Exception {
		this.sc = new Scanner(System.in);
		File f = new File(ori_url);
		//ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
		List<File> files = Arrays.asList(f.listFiles());
		File f2 = null;
		try {
		
			System.out.println("호텔 이미지를 등록할 디렉토리명을 입력하세요 : ");
			this.user1 = this.sc.nextLine();
			f2 = new File(dir + this.user1);
			f2.mkdir();
				
			System.out.println("펜션 이미지를 등록할 디렉토리명을 입력하세요 : ");
			this.user2 = this.sc.nextLine();
			f2 = new File(dir + this.user2);
			f2.mkdir();
	//toLowerCase() : 대소문자 구분 안함
			for(int a=0; a<files.size(); a++) {
				
				this.fs = new FileInputStream(files.get(a));
				byte temp[] = new byte[this.fs.available()];
				this.fs.read(temp);
				
				//int ck = files.get(a).toString().toLowerCase().indexOf("hotel");
				boolean ck = files.get(a).toString().toLowerCase().contains("hotel");
				String url2 = dir;
				
				//파일이름 변경값 받기
				int aa = files.get(a).toString().lastIndexOf("\\");
				String names = files.get(a).toString().substring(aa);
				String rename = this.ib.renames(names);
				//파일이름 최종 변경사항 확인
				System.out.println(rename);		
				
				if(ck==true) {	//호텔 이미지
					url2 = url2 + this.user1;	//복사할 경로 + 사용자가 생성 디렉토리
					
				}
				else {	//펜션 이미지
					url2 = url2 + this.user2;
					
				}
				
				
				/*
				String url2 = "c:\\aaa\\";
				this.os = new FileOutputStream(url2 + "111.jpg");
				this.os.write(temp);
				this.os.close();
				*/
				System.out.println(files.get(a));
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			if(this.fs != null) {
				this.fs.close();
			}
			this.sc.close();
		}
	}
}

