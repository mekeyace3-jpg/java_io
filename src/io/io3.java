package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//io(Blocking) 라이브러리 : Stream (메모리) => 간단한 파일 입출력 (단일 Thread)
//nio(Non-Blocking) 라이브러리 : Buffer (메모리) => 네트워크 서버 및 클라우드에 연결처리(Multi Thread)

public class io3 {
	public static void main(String[] args) throws Exception {
		new io3_box().abc();
	}
}

class io3_box{
	String url = "\\java_io\\array.txt";
	public void abc() throws IOException {
		//Files : NIO 라이브러리 이며, readAllLines :메모리로 파일을 한번에 모두 읽어들임
		//Paths : 파일 경로 및 파일 생성등 다양한 형태로 구현가능 
		//Paths.get : 경로를 설정
		List<String> data = Files.readAllLines(Paths.get(this.url));
		System.out.println(data);
		
		//byte의 원시배열로 로드 후 new String() => 문자열 인스턴스로 출력
		byte[] data2 = Files.readAllBytes(Paths.get(this.url));
		System.out.println(new String(data2));
		
		//nio의 단점 : 메모리 할당 많아짐, 한글 언어패킷을 조정 해야함
	}
}


