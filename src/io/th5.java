package io;
/*
 응용문제
 다음의 결과 처럼 나오도록 Multi Thread를 활용하여 처리 하시길 바랍니다.
 Integer data[] = {6,9,10,15,3,17};
 
 해당 배열의 데이터를 기준으로 다음과 같이 실행 됩니다.
 [결과]
 총 배열의 합산 결과 : 
 총 배열의 곱한 결과 :      
 */
public class th5 {

	public static void main(String[] args) {
		 Integer data[] = {6,9,10,15,3,17};
		 th5_box1 tb1 = new th5_box1(data,"+");
		 th5_box1 tb2 = new th5_box1(data,"*");
		 
		 Thread th1 = new Thread(tb1);
		 Thread th2 = new Thread(tb2);
		 
		 th1.start();
		 th2.start();
	}
}
class th5_box1 extends Thread{
	private Integer rdata[] = null;
	String part = "";
	public th5_box1(Integer data[],String munja) {
		this.rdata = data;
		this.part = munja;
	}
	@Override
	public void run() {
		Integer total = 0;
		Integer total2 = 1;
		for(Integer a : this.rdata) {
			if(this.part == "+") {
				total += a;
			}
			else {
				total2 *= a;
			}
		}
		if(this.part == "+") {
			System.out.println(total);
		}
		else {
			System.out.println(total2);
		}
	}
}


