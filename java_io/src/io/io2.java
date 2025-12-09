package io;

import java.io.*;
import java.util.Scanner;

//throws 사용시 try~catch 없이도 파일 읽기, 쓰기가 가능합니다.
//String 문자열을 이용하여 경로를 설정 후 FileReader 적용하는 방식
public class io2 {
	public static void main(String[] args) throws IOException,Exception {
			String url = "d:\\java_io\\list2.ini";
			FileReader fr = new FileReader(url);	
			
			//System.in : 사용자 입력(input)
			//System.out : 사용자 입력값을 출력(output)
			Scanner sc = new Scanner(fr);
			while(sc.hasNext()) {	//hasNext() : true, false
				String word = sc.nextLine();
				System.out.println(word);
			}
			sc.close();	//라이브러리를 종료시 open한 상황의 역순으로 무조건 종료
			fr.close();
			
			io2_box ib = new io2_box();
			ib.fw();
	}
}
//FileWriter : 저장 기능이며, 경로가 필요하며 파일명도 사용해야 합니다.
//단, new FileWriter(경로,true) 사용시 기존에 작성된 내용 포함하여 신규 내용을 추가
class io2_box{
	String url = "‪D:\\java_io\\array.txt";
	String data[] = {"2025","APINK","PINKNEWYEAR","콘서트","13TH(Pink Vibes)"};
	public void fw() throws Exception {
		//FileWriter fw = new FileWriter(this.url);
		FileWriter fw = new FileWriter(this.url,true);
		for(int f = 0; f < this.data.length; f++) {
			fw.write(this.data[f]+"\n");
		}
		fw.close();	//파일이 오픈상황이므로 close를 하지 않을 경우 저장이 안됨
	}
}


