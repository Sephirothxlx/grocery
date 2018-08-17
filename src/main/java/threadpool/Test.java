package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) {
		//Here my thread pool has Integer.Max_Value workers in linked blocking queue.
		ThreadPoolExecutor t = new ThreadPoolExecutor(5, 10, 1, TimeUnit.HOURS, new LinkedBlockingQueue<Runnable>(),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
		Test tt=new Test();
		t.execute(new Test.Task());
		t.execute(tt.new Task2());
	}
	
	static class Task implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			System.out.println("lalala!");
		}
		
	}
	class Task2 implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			System.out.println("hahaha!");
		}
		
	}
}
