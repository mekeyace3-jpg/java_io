package io;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

//io13.java 와 연계
public class io13_box {

	Date today = null;
	SimpleDateFormat sf = null;
	Random rd = null;
	
	//이름 변경
	public String renames(String filenm) {
		this.today = new Date();
		this.sf = new SimpleDateFormat("yyyyMMdd");
		this.rd = new Random();
		int no = this.rd.nextInt();
		if(no < 0) {
			no = -no;
		}
		int idx = filenm.lastIndexOf(".");
		String type = filenm.substring(idx); 
		
		String renames = this.sf.format(today) + no + type;
		
		return renames;
	}
	
}
