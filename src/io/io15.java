package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

//Reader,Writer => Buffered
public class io15 {

	public static void main(String[] args) throws Exception {
	  String url = "d:\\java_io\\list1.txt";
	  FileReader fr = new FileReader(url);	//문자 => byte
	  BufferedReader br = new BufferedReader(fr);	//readLine
	  System.out.println(br.readLine());
	  /*
	  해당 조건문 또는 sysout에서
	  Buffered 사용시 무조건 메모리에서는 해당 데이터를 사용한 것으로 간주 데이터 삭제
	  */
	  /*	//해당 코드 작성시 Data는 loss 발생함
	  if(br.readLine() == null) {
		  System.out.println("값이 없습니다.");
	  }
	  else {
		  br.readLine();
		  System.out.println("---------");
	  }
	  */

	  String data = "";
	  while((data = br.readLine()) != null) {
		  System.out.println("반복문: " + data);
	  }
	  br.close();
	  fr.close();
	  
	  new io15_box().abc();
	}
}
//Writer + Buffered
class io15_box{
	String url = "d:\\java_io\\array.csv";
	
	public void abc() {
		try {
			FileWriter fw = new FileWriter(this.url,Charset.forName("EUC-KR"));
			BufferedWriter bw = new BufferedWriter(fw);
			ArrayList<String> mb = new ArrayList<String>();
			mb.add("권하민,ISFP");
			mb.add("김고운,ENFP");
			mb.add("김예빈,INTP");
			mb.add("신범석,ENTP");
			
			for(String m : mb) {
				bw.write(m+"\n");
				bw.flush();	//writer를 사용했으므로 flush 메모리를 초기화
			}
			bw.close();
			fw.close();
			
		}
		catch(Exception e) {
			System.out.println("파일 경로가 잘못 되었습니다.");
		}
	}
}
