package io;
/*
 응용문제1
 해당 정보를 입력시 사용자 개인정보를 클래스 배열에 저장하는 코드를 작성합니다.
 단, 다음과 같이 실행 되어야 합니다. 암호화는 (MD5) 입니다.
 
 [실행] - ship.txt 에 있는 질문사항을 순서대로 출력하여 사용자가 입력하는 프로세서 입니다.
 아이디를 입력하세요 : hong
 패스워드를 입력하세요 : a123456
 이메일을 입력하세요 : hong@nate.com
 연락처를 입력하세요 : 01012345678
 
 [결과]
 [hong,ef1023ab55687cd0133,hong@nate.com,01012345678]
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ex1 {
	ex1_box eb = new ex1_box();	//암호화 Model
	Scanner sc = null;
	ArrayList<String> userinfo = null;
	String url = "d:\\java_io\\ship.txt";
	
	public static void main(String[] args) {
		new ex1().member_ship();
	}
	public void member_ship() {
		File f = new File(this.url);
		this.sc = new Scanner(System.in);
		this.userinfo = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String qc = "[회원가입]";
			int w = 1;
			do {
				System.out.println(qc);
				if(!qc.equals("[회원가입]")) {
					String userdata = this.sc.nextLine();
					if(w == 2) {	//패스워드 입력단계
						userdata = this.eb.md5_encode(userdata);
					}
					this.userinfo.add(userdata);
					w++;
				}
			}while((qc = br.readLine()) != null);
			System.out.println(this.userinfo);
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





