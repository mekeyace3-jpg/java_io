package io;
import java.io.File;
//io 및 nio의 추가 클래스 형태
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Scanner;

//파일의 권한 속성을 설정하는 형태
//퍼미션 : r(read)-4 : 읽기, w(write)-2 : 쓰기,  x(excute)-1 : 실행 => 7
//r-x => 5,  r-- => 4 , -wx => 3 , rwx => 7

public class io20 {

	public static void main(String[] args) {
		String ori_file = "d:\\java_io\\array.csv";
		String cp = "c:\\io\\array.csv";
		try {
		//=> 큰 파일 위주로 사용할 경우
		//RandomAccess : 개발자가 해당 파일 속성 권한을 설정할 수 있음	
		RandomAccessFile file = new RandomAccessFile(ori_file, "r");
		RandomAccessFile file2 = new RandomAccessFile(cp, "rw");
		
		//FileChannel(nio) : IO(FileInputStrem + FileOutputStream) 결합
		FileChannel fc = file.getChannel();  // => RandomAccessFile 가져오는 역활
		FileChannel target = file2.getChannel();
		//transferFrom(2GB 이상의 API) => write기능을 향상시킴 
		target.transferFrom(fc, 0, fc.size());	//복사할 파일, 0, 파일전체사이즈 
		
		target.close();
		fc.close();
		file2.close();
		file.close();
		}
		catch (Exception e) {
			
		}
		
		new io20_box().abc();
	}
	
}

//Scanner => io 형태로 구현 => .log 같은것을 처리 할 때 사용
class io20_box{
	Scanner sc = null;
	
	public void abc() {
		try {
			String url = "c:\\io\\";
			this.sc = new Scanner(new File(url + "game.log"));
			while(this.sc.hasNext()) {
				System.out.println(this.sc.nextLine());
			}
			
		} catch (Exception e) {
			
		}finally {
			this.sc.close();
		}
	}
}



