package io;

import java.io.BufferedReader;
import java.io.FileReader;
//csv 파일을 load하여 buffer로 출력시키는 형태
public class io16 {
	
	public static void main(String[] args) {
		String url = "d:\\java_io\\user.csv";
		try {
			FileReader fr = new FileReader(url);
			BufferedReader br = new BufferedReader(fr);
			String data = "";
			while((data = br.readLine()) != null) {
				System.out.println(data);
			}
			br.close();
			fr.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
