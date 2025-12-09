package io;
//멀티 쓰레드 응용편
public class th4 {
	public static void main(String[] args) {
		Integer data1[] = {10,20,30,40,50,60,70,80,90};
		Integer data2[] = {5,10,15,20,25,30,35,40,45,null};
		Integer data3[] = {7,14,21,28,35,42,49,56,63};
		
		//각각의 Thread를 활용하여 배열값을 처리하는 코드 단, 실행할 때 마다 다른 결과가 출력됨
		th4_box tb1 = new th4_box(data1);
		Thread tr1 = new Thread(tb1);
		
		th4_box tb2 = new th4_box(data2);
		Thread tr2 = new Thread(tb2);
		
		th4_box tb3 = new th4_box(data3);
		Thread tr3 = new Thread(tb3);
		
		//Multi Thread 로 가동
		tr1.start();
		tr2.start();
		tr3.start();
		/*
		tb1.start();
		tb2.start();
		tb3.start();
		*/
	}
}

class th4_box extends Thread{
	int sum = 0;
	private Integer datas[] = null; 
	public th4_box(Integer data[]) {
		this.datas = data;
	}
		
	@Override
	public void run() {
		try {
			Integer f;
			for(f=0; f<this.datas.length; f++) {
				this.sum += this.datas[f];
			}
			System.out.println("배열의 전체 값 : " + this.sum);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
