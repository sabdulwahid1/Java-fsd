package Threads_Creation;

public class MyRunnableThread implements Runnable {
	public static int myCount = 0;
	public MyRunnableThread() {
		
	}
		public void run() {
			while(MyRunnableThread.myCount<=10) {
				try {
					System.out.println("Expl Thread :"+ (++MyRunnableThread.myCount));
					Thread.sleep(100);
				}catch(InterruptedException ie) {
					System.out.println("Exception in thread: "+ ie.getMessage());
				}
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting Main Thread...");
		
		MyRunnableThread mrt = new MyRunnableThread();
		Thread t = new Thread();
		t.start();
		while(MyRunnableThread.myCount<=10) {
			try {
				System.out.println("Main Thread: "+ (++MyRunnableThread.myCount));
				Thread.sleep(100);
			}catch(InterruptedException ie) {
				System.out.println("Exception in main thread: "+ie.getMessage());
			}
		}
		System.out.println("End of Main Thread...");
	}

}
