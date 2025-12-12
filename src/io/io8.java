package io;

import java.io.File;
import java.io.FileOutputStream;

//Stream 응용문제 [필수조건 => FileOutputStream] => byte
/*
 d:\java_io 디렉토리에 dan.txt를 생성합니다. 단, 자바 코드에서 생성 되어야 합니다.
 구구단 8단의 대한 내용이 dan.txt에 저장 되도록 합니다. 
  
 dan.txt 파일을 열었을 경우 메모장에 해당 내용이 저장 되어 있어야 합니다. 
 */
public class io8 {
	private String url = "d:\\java_io\\dan.txt";
	String message = "";
	FileOutputStream fs = null;
	
	public static void main(String[] args) {
		 String result = new io8().gugu();
		 System.out.println(result);
	}
	public String gugu() {
			
		try {
			File f = new File(this.url);
			
			//구구단 정보를 모두 저장하는 문자열
			StringBuffer sb = new StringBuffer(); 
			//StringBuffer, StringBuild => toString => getBytes => 저장
			for(int a=1; a<10; a++) {
				int sum = 8 * a;
				sb.append("8 * " + a + " = " + sum + "\n");
			}
			this.fs = new FileOutputStream(f);
			/*
			String gugus = sb.toString();
			byte by[] = gugus.getBytes();
			*/
			this.fs.write(sb.toString().getBytes());
			this.fs.close();
			
			this.message = "정상적으로 구구단 파일이 완성 되었습니다.";
		} catch (Exception e) {
			this.message = "error: "+e.getMessage();
		}
		return this.message;
	}
}
