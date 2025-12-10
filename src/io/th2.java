package io;
//단일, 멀티 쓰레드 활용
public class th2 {
	public static void main(String[] args) {
		/*//단일 쓰레드 코드
		int w = 0;
		do {
			th2_box tb = new th2_box(w);
			tb.zzz();
			w++;
		}while(w < 500);
		*/
		//멀티쓰레드 호출 방식 try ~ catch
		try {
			int w = 0;
			do {
				th2_box tb = new th2_box(w);
				Thread th = new Thread(tb);	//Thread를 new 사용시 쓰레드 추가
				th.start();	//run() 메소드를 호출해서 실행
				th.sleep(2000);	//sleep Thread가 휴식기를 거치는 상태 
				w++;
			}while(w < 10000);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
//Thread 클래스를 활용하여 적용한 방식
class th2_box extends Thread {
	int no = 0;
	public th2_box(Integer n) {
		this.no = n;
	}
	public void zzz() {
		System.out.println(this.no);
	}
	@Override
	public void run() {	//멀티 쓰레드 실행
		this.zzz();
	}
}

/*
class th2_box{
	int no = 0;
	public th2_box(Integer n) {
		this.no = n;
	}
	public void zzz() {
		System.out.println(this.no);
	}
}
*/