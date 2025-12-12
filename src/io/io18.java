package io;
//http://mekeyace.kbsn.or.kr/user.csv
/*
 
 FileReader fr = new FileReader(url); 
 System.out.println(fr.getEncoding());  //해당 파일 저장 형태의 언어셋
 
 응용문제. 다음 프로세서를 실행하는 코드를 작성하시오. 고객데이터는 user.csv의 파일을
 이용하여 사용해야 합니다. 
 
 [실행]
 통신사를 선택해 주세요 [SKT,KT,LGT,알뜰폰] : 
 잘못 입력시 : "해당 메뉴에 맞는 단어만 입력하세요" 다시 메뉴가 출력
 
 [결과]
 통신사를 선택해 주세요 [SKT,KT,LGT,알뜰폰] : LGT
 [김준수,신유빈,윤하빈,조선경,황인호]
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class io18 {
	
	private ArrayList<String> userdata = null;
	private String url = "d:\\java_io\\user.csv";
	
	
	public static void main(String[] args) {
		String menu[] = {"SKT","KT","LGT","알뜰폰"};
		Scanner sc = new Scanner(System.in);
		String cp = "";
		boolean ck = false;
		while(true) {
		System.out.println("통신사를 선택해 주세요 "+ Arrays.toString(menu) + ": ");
			cp = sc.next();
			for(String m : menu) {
				if(cp.equals(m)) {
					ck = true;
				}
			}
			if(ck == true) {
				break;
			} 
			else {
				System.out.println("해당 메뉴에 맞는 단어만 입력하세요");
			}
		}
		
		ArrayList<String> data = new io18().corp(cp);
		System.out.println(data);
		
		sc.close();
	}
	
	//해당 파일을 로드 후 필요한 정보를 1차 클래스로 생성 후 return 하는 메소드
	public ArrayList<String> corp(String cp){
		//해당 통신사에 맞는 사용자만 정보를 저장하는 배열
		this.userdata = new ArrayList<String>();
		try {
			File f = new File(this.url);
			
			//byte로 로드 후 해당 문서파일에 문자내용을 확인하는 String으로 변환 코드
			//변환 동시에 언어셋을 적용하여 출력하는 형태
			InputStream is = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(is,Charset.forName("EUCKR"));
			BufferedReader br = new BufferedReader(isr);
						
			String user;
			while((user = br.readLine()) != null) {
				String ck[] = user.split(",");
				for(String c : ck) {
					if(c.equals(cp)) {
						this.userdata.add(ck[0]);
						break;
					}
				}
			}
			
			br.close();
		} catch (Exception e) {
			this.userdata = null;
		}
		return this.userdata;
	}
	
}
