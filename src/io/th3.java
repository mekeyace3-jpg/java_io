package io;
//멀티 쓰레드 interface
public class th3 {
	public static void main(String[] args) {
		th3_box tb = new th3_box();
		/*
		 tr.start(); :  JVM 스케줄러 새로운 쓰레드를 자동으로 호출 => (멀티 쓰레드)
		 tr.run();   : 개발자가 직접 해당 메소드를 호출 (단일 쓰레드)
		 */
		
		
		for(int f=0; f<100; f++) {	//start 반복문 안에 new Thread를 생성해야 합니다.
			tb.abc(f);
			Thread tr = new Thread(tb);	//멀티 쓰레드 활용함
			try {
				//tr.sleep(1000);
				tr.start();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}
/* 해당 Thread를 interface로 사용하는 방법 */
class th3_box implements Runnable{
	int n = 0;
	public void abc(int z) {
		this.n = z;
	}
	@Override
	public void run() {	//Multi Thread를 가동하는 메소드 (수정X)
		System.out.println(this.n);	
	}
}
