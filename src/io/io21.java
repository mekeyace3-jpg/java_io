package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.stream.Stream;

//io 및 nio의 추가 클래스 형태2 (WEB) -> JSP, JSTL, Thymeleaf (IO)
public class io21 {

	public static void main(String[] args) {
		String url = "c:\\io\\info.txt";
		try {
		//PrintWriter => web 전용 io (javascript 코드를 출력하는 형태)
		PrintWriter pw = new PrintWriter(url);
		//Writer => Web 전용 => PrintWriter
		pw.write("alert('올바른 접근이 아닙니다.'); self.close();");
		pw.close();
		}catch (Exception e) {
		
		}
		//new io21_box().abc();
		new io21_box().bbb();
	}
}

//InputStream, OutputStream 네트워크 기능 추가 (실시간 데이터 전송)
class io21_box{
	String url = "c:\\io\\chat.log";
	public void bbb() {
		String message = "java I/O를 배우는 중입니다.";

		try {
			//byte로 파일을 로드 => 메모리 문자 형태로 append를 이용하여
			OutputStream os = new FileOutputStream(url);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.append(message);
			bw.flush();
			bw.close();
			
			/*
			message = "java가 사람을 잡아요..ㅎㅎㅎ";
			FileWriter fw = new FileWriter(url);
			BufferedWriter bw = new BufferedWriter(fw);
			OutputStream os2 = new WriterOutputStream(bw);
			os2.write(message.getBytes());
			bw.flush();
			os2.close();
			bw.close();
			fw.close();
			*/
		}
		catch (Exception e) {
		
		}
	}
	
	public void abc() {
		try {
			//전송 역활
			//byte로 전송 => System.out 
			OutputStreamWriter os = new OutputStreamWriter(System.out);
			//사용자가 입력한 문자를 메모리에 탑재
			BufferedWriter bw = new BufferedWriter(os);
			bw.write("안녕하세요!!!");
			bw.flush();
			bw.close();
			
			//byte로 전송된 값을 System.in 받음
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			String msg = br.readLine();
			System.out.println(msg);
			
		} catch (Exception e) {
			
		}
	}
}
