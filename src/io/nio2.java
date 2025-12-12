package io;
//nio의 필수조건 : Buffer,Channel,Selector
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//nio에 대한 Path에 경로 형태
public class nio2 {

	public static void main(String[] args) {
		//relativize : 현재 자신이 위치한 곳에서 다른 경로의 파일을 로드할 경우 정확한 위치파악
		Path path1 = Paths.get("c:\\test");
		Path path2 = Paths.get("c:\\test\\images\\123.jpg");
		Path relative = path1.relativize(path2);
		System.out.println(relative);
		
		Path path3 = Paths.get("/home/product");
		Path path4 = Paths.get("/home/admin/admin.jpg");
		Path relative2 = path3.relativize(path4);
		System.out.println(relative2);
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("이게 nio 입니다 ㅎㅎㅎㅎ1");
			sb.append("이게 nio 입니다 ㅎㅎㅎㅎ2");
			sb.append("이게 nio 입니다 ㅎㅎㅎㅎ3");
			Path pt = Paths.get("c:\\test\\123.txt");
			//Files.writeString : nio에 해당 파일 오픈하여 바로 저장기능
			Files.writeString(pt, sb);
			 //readString : 메모리에서 해당 경로의 파일을 가져와서 출력
			String word = Files.readString(pt); 
			System.out.println(word);
			//Files.deleteIfExists(pt);	//파일, 디렉토리도 삭제(파일이 있을 경우 불가능) 
		}catch (Exception e) {
			
		}
		new nio2_box().abc();
	}
}
class nio2_box{
	public void abc() {
		try {
			//FileSystem : 시스템 전반적인 정보를 확인 할 수 있는 클래스 
			FileSystem fs = FileSystems.getDefault();
			//getFileStores() : 모든 디스트의 정보를 가져옴 (배열)
			for(FileStore st : fs.getFileStores()) {
				System.out.println("드라이브명 : "  + st.name());
				System.out.println("파일시스템 : "  + st.type());
				System.out.println("전체공간 : "  + st.getTotalSpace());
				System.out.println("여유공간 : "  + st.getUsableSpace());
				System.out.println("사용중인 공간 : "  + (st.getTotalSpace() - st.getUsableSpace()));
			}
		} catch (Exception e) {
			
		}
	}
}


