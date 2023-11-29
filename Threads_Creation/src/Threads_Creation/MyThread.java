package Threads_Creation;

public class MyThread extends Thread{
	public void run() {
		System.out.println("Concurrent thread Started Running...");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mt = new MyThread ();
		mt.start();
	}
}

