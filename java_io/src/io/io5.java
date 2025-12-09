package io;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.Scanner;

/*
응용문제2
interior_data.txt 에 저장되어 있는 값을 각 라인별로 배열처리 형태로 구성해야 합니다.

[결과]
[[1,3D 모델링 인테리어,3D,조나단],[3,2D 바위 mapping 이미지,2D,토마스]...]

배열 기준으로 제목만 출력 되어야함 (NODE => 1)

[결과예시]
3D 모델링 인테리어
2D 바위 mapping 이미지
2D 파스텔 종이 mapping 이미지
3D 외벽 인테리어
2D 패턴 mapping 이미지
*/
public class io5 {
	public static void main(String[] args) throws Exception {
		new io5_box().abc();
	}
}

class io5_box{
	String url = "D:\\java_io\\interior_data.txt";
	
	public void abc() throws Exception {
		FileReader fr = new FileReader(this.url,Charset.forName("EUCKR"));
		Scanner sc = new Scanner(fr);
		while(sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
		sc.close();
		fr.close();
	}
	
}
