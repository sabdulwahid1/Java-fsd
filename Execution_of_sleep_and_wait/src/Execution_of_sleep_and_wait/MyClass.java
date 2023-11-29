package Execution_of_sleep_and_wait;

public class MyClass {
	private static Object Lock =new Object();
	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		System.out.println("Thread '" + Thread.currentThread().getName() + "' is woken after sleeping for 1 second");
		synchronized(Lock) {
			Lock.wait(1000);
			System.out.println("Object '" + Lock + "' is woken after" + " waiting for 1 second");;
		}
	}

}
