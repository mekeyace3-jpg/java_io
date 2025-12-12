package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//Stream 단축코드
public class io19 {

	public static void main(String[] args) {
		String file = "d:\\java_io\\222.jpg";
		try {
		//BufferedInputStream => new FileInputStream 바로 인스턴스를 로드하여 적용하는 방식	
		BufferedInputStream bs = new BufferedInputStream(new FileInputStream(file));
		byte filesize[] = new byte[bs.available()];
		bs.read(filesize);
		String refile = "c:\\io\\333.jpg";
		//BufferedOutputStream => new FileOutputStream 인스턴스를 로드하여 저장하는 방식
		BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(refile));
		bo.write(filesize);
		bo.flush();
		bo.close();
		bs.close();
		}catch (Exception e) {
			
		}
	}

}
