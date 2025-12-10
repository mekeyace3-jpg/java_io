package io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class io6 {

	public static void main(String[] args) {
			/*
			StringBuilder sb = new StringBuilder();
			sb.append("d:\\java_io\\");
			sb.append("agree2.txt");
			*/
			//String sb = "d:\\\\java_io\\\\agree2.txt";
			String sb = "d:\\java_io\\agree.txt";
			try {
				//File : 실제 경로에서 생성, 삭제, 다른경로 이동, 해당 파일명(속성변경)
				File f = new File(String.valueOf(sb));  //io
				//f.createNewFile();	//생성
				//f.delete();	//해당 경로에 있는 파일을 삭제
				Path data1 = f.toPath();	//io => nio 객체형 변환
				
				String url2 = "c:\\io\\agree.txt";
				File f1 = new File(url2);  //io
				Path data2 = f1.toPath();  //io => nio
				/* 
				   StandardCopyOption.REPLACE_EXISTING :
				   기존 파일을 대체 해서 해당 경로로 붙여넣기 하는 기능 
				 */
				Files.move(data1,data2);		//파일 이동
				//Files.copy(data2, data1);		//파일 복사
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				new io6_box().abc();
			}catch (Exception e) {
				
			}
	}
}

//nio 형태로 파일 및 디렉토리를 핸들링 하는 메소드
class io6_box{
	
	public void abc() throws Exception {
		
		//nio 형태로 디렉토리를 생성
		//Files.createDirectory(Paths.get("c:\\io"));
		
		//nio 형태로 Path(interface)를 이용하여 파일 복사
		/*
		Path data1 = Paths.get("d:\\java_io\\list1.txt");
		Path data2 = Paths.get("c:\\io\\list1.txt");
		Files.copy(data1, data2);	//copy(원본경로,사본경로)
		*/
		/*  //잘라내기 형태로 이동
		Path data3 = Paths.get("d:\\java_io\\agree2.txt");
		Path data4 = Paths.get("c:\\io\\agree2.txt");
		Files.move(data3, data4);
		*/
		//파일을 생성
		Path data5 = Paths.get("c:\\io\\agree3.txt");
		//Files.createFile(data5);
		Files.delete(data5);	//파일삭제
	}	
	
}


