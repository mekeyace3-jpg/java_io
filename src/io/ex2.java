package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/*
  응용문제2
  user.csv 파일을 로드하여 해당 사용자 통신사별로 각각의 파일로 저장 되도록 해야합니다.
  skt_user.csv
  kt_user.csv
  lgt_user.csv
  etc_user.csv 
 */
public class ex2 {
	String filenm[] = {"skt_user.csv","kt_user.csv","lgt_user.csv","etc_user.csv"};
	private String ori_data = "d:\\java_io\\user.csv";
	private String save_data = "d:\\java_io\\";
	InputStream is = null;
	InputStreamReader isr = null;
	BufferedReader br = null;
	OutputStream os = null;
	OutputStreamWriter osw = null;
	BufferedWriter bw = null;
	
	public static void main(String[] args) {
		new ex2().part_corp();
	}
	
	public void part_corp() {
			File f = new File(this.ori_data);	//원본 데이터 경로
			try {
				for(String mkfile : filenm) {	//배열값에 맞는 파일명으로 생성
					File f2 = new File(this.save_data + mkfile);	//신규 파일 생성 경로
					f2.createNewFile();	//신규 파일 생성
				}
				//해당 파일의 데이터를 로드하여 구분				
				this.is = new FileInputStream(f);
				this.isr = new InputStreamReader(this.is,Charset.forName("EUC-KR"));
				this.br = new BufferedReader(this.isr);
				String data = "";
				int ff = 0;
				
				while((data=this.br.readLine()) != null) {
				String ck[] = data.split(",");	//문자열 , 기준으로 원시배열 생성 하여 switch 반영
					switch(ck[1]) {
						case "SKT":
							ff = 0;	//filenm 해당 원시배열 변수에 맞는 배열 노드번호를 적용하기 위함
						break;
						case "KT":
							ff = 1;
						break;
						case "LGT":
							ff = 2;
						break;
						default:	//etc (알뜰폰)
							ff = 3;
						break;
					}
					
					this.os = new FileOutputStream(this.save_data + filenm[ff],true);
					this.osw = new OutputStreamWriter(this.os,Charset.forName("EUC-KR"));
					this.bw = new BufferedWriter(this.osw);
					this.bw.write(data);
					this.bw.newLine();
					this.bw.flush();
				}
				
				this.bw.close();
				this.br.close();
				
			} catch (Exception e) {
				e.getMessage();
			}
	}
}



