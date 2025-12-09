package io;
/*
 Thread란 기본으로 1Core => 1Thread로 작동합니다. 
 Java => Multi Thread를 이용하여 개발 환경에 다양한 작업을 구현할 수 있음
 단, WEB => 단일 쓰레드, API 구성 => Multi Thread (MSA) 
 */
public class th1 {
	public static void main(String[] args) {
		/*
		th1_box th = new th1_box();
		th.aaa();
		th.bbb();
		*/
		
		th1_box2 th2 = new th1_box2();
		th2.start();	//=>Thread 클래스를 활용하여 run() 메소드를 가동
		th1_box2 th3 = new th1_box2();
		th3.start();

/*		
		Thread tr = new Thread(th2);	=> Thread를 무조건 활용
		tr.start();
	*/
	}
}

class th1_box2 extends Thread{	//Thread(2) => Multi
	public void aaa() {
		int w = 0;
		do {
			System.out.println("aaa: " + w);
			w++;
		}while(w < 60);
	}
	public void bbb() {
		int w = 0;
		do {
			System.out.println("bbb: " + w);
			w++;
		}while(w < 60);
	}
	
	@Override
	public void run() {	//멀티쓰레드 클래스를 적용한 메소드 (기본 메소드)
		this.aaa();		//멀티쓰레드를 활용하여 작동
		this.bbb();
	}
}




class th1_box{	//단일 Thread
	public void aaa() {
		int w = 0;
		do {
			System.out.println("aaa: " + w);
			w++;
		}while(w < 41);
	}
	public void bbb() {
		int w = 0;
		do {
			System.out.println("bbb: " + w);
			w++;
		}while(w < 41);
	}
}

