package io;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
응용문제1
data.txt라는 파일을 생성 후 다음 결과에 대한 내용이 data.txt에 저장 되도록 코드를 작성하시오.
[실행]
"댓글 내용을 입력하세요 : "
[결과]
data.txt 파일을 열었을 경우 해당 댓글 내용이 저장 되어 있어야 합니다.  
*/
public class io4 {
	private String url = "c:\\io\\data.txt";
	String message = "";	//결과 정보를 담는 변수
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String result = new io4().file_save();
		System.out.println(result);
	}
	public String file_save() {
		//해당 경로를 지정
		File f = new File(this.url);
		try {
			System.out.println("댓글 내용을 입력하세요 : ");
			String txt = this.sc.nextLine();
			FileWriter fw = new FileWriter(f,true);
			BufferedWriter bw = new BufferedWriter(fw);
			/*
			FileOutputStream fw = new FileOutputStream(f,true); 
			OutputStreamWriter osw = new OutputStreamWriter(fw,StandardCharsets.UTF_8);
			BufferedWriter bw = new BufferedWriter(osw);
			*/
			bw.write(txt);
			bw.newLine();   //새로운 줄바꿈으로 데이터를 저장함
			bw.flush();
			bw.close();
			this.message = "올바르게 댓글이 저장 되었습니다.";
		} catch (Exception e) {
			this.message = "경로 오류로 인하여 정상적으로 저장되지 않았습니다.";
			e.getMessage();
			//System.out.println(e);
		} finally {
			this.sc.close();
		}
		
		return this.message;
	}
}
