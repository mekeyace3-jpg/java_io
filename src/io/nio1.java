package io;

import java.io.IOError;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

//nio로 모든 파일 및 디렉토리를 핸들링
public class nio1 {
	//외부서버 nio => Empty ???
	public static void main(String[] args) throws Exception {
		try {
			Path url1 = Paths.get("c:\\");	//1순위 셋팅 절대경로
			//디렉토리 생성
			Files.createDirectories(Paths.get(url1+"test"));
			
			/* 파일복사 */
		
			Path data1 = Paths.get("d:\\java_io\\123.jpg");
			Path data2 = Paths.get("c:\\test\\123.jpg");
			/* Files.copy : 복사를 적용하고 읽기전용 해당 복사파일 삭제할 수 없음
			   StandardCopyOption.REPLACE_EXISTING (덮어쓰기 기능을 활성화) 사용시
			   복사하는 파일 즉시 삭제 가능함
			 */
			Files.copy(data1, data2,StandardCopyOption.REPLACE_EXISTING);
		
			/* 파일 삭제 */
			Path data3 = Paths.get("c:\\test\\123.jpg");
			Files.delete(data3);
			
			//빈 파일을 강제생성
			/*
			Path data4 = Paths.get("c:\\test\\aaa.jpg");
			Files.createFile(data4);
			*/
			/*		
			Path data5 = Paths.get("c:\\test\\"); //=>정상적인 디렉토리 전체경로
			Files.delete(data5); //***파일이 있을 경우 삭제처리가 안됨
			*/
			
			Path data5 = Paths.get("c:\\test\\");
			//Stream란 : nio 전용 클래스 배열
			Stream<Path> st = Files.list(data5);
			
			//forEach : 배열의 기본으로 하는 반복문
			st.forEach(aaa -> {	//aaa : String(X)
				System.out.println(aaa);
				/* //파일명 출력
				String fileurl = aaa.toString();
				int n = fileurl.lastIndexOf("\\");
				System.out.println(fileurl.substring(n+1));
				String orifile = fileurl.substring(n+1);
				*/
				try {
					//Files.delete(aaa);
				}catch (Exception e) {
					System.out.println("해당 파일은 권한이 없어서 삭제하지 못함");
				}
				/*// java.nio.file.api 
				//relativize : 절대 => 상대경로를 기능으로 설정 메소드
				Path filenm = data5.relativize(path);   
				System.out.println(filenm);
				*/				
			});
			
			
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
