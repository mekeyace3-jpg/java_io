package io;

import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
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
	ArrayList<String[]> alldata = null;
	//ArrayList<String> al = null;
	//ArrayList<ArrayList<String>> alldata = new ArrayList<ArrayList<String>>();
	
	public void abc() throws Exception {
		//File f = new File(this.url);
		try {
			FileReader fr = new FileReader(this.url,Charset.forName("EUCKR"));
			Scanner sc = new Scanner(fr);
			this.alldata = new ArrayList<String[]>();
			while(sc.hasNext()) {
				String word[] = sc.nextLine().split(",");
				this.alldata.add(word);
				//this.al = new ArrayList<String>(Arrays.asList(word));
				//this.alldata.add(this.al);
				//this.alldata.add(word);
			}
			sc.close();
			fr.close();
			System.out.println(Arrays.deepToString(this.alldata.toArray()));
			//System.out.println(this.alldata.get(1).get(1));
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
}
