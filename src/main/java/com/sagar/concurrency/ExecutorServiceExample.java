package com.sagar.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * submit() , execute() are asynchronous
 * 
 * invokeAll, invokeAny are synchronous
 * 
 * @author sitapsha
 *
 */
public class ExecutorServiceExample {

//	public static void r1() throws RuntimeException {
//		try {
//			System.out.println("Sleeping");
//			Thread.sleep(15000);
//			System.out.println("Sleeping Done");
//
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new RuntimeException("adadadad"); // can throw cehcked exception in Callable
//		}
//	};

	public static void main(String[] args) throws Exception {

		try {
			ExecutorService service = null;
			service = Executors.newFixedThreadPool(5);
			List<Callable<Boolean>> tasks = new ArrayList<>();
			tasks.add(getC(2000));
			tasks.add(getC(3000));
			tasks.add(getC(4000));
			tasks.add(getC(5000));
			tasks.add(getC(10000));

			service.invokeAll(tasks);

		} finally {
			System.out.println("==========");
		}

	}

	private static Callable<Boolean> getC(int sleep) {
		return () -> {
			System.out.println("Sleeping : " + sleep);
			Thread.sleep(sleep);
			return true;
		};
	}
//	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ExecutorService service = null;
//		try {
//			service = Executors.newSingleThreadExecutor();
//			Callable<String> r1 = () -> {
//				try {
//					System.out.println("Sleeping");
//					Thread.sleep(15000);
//					System.out.println("Sleeping Done");
//
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					throw new Exception("adadadad"); // can throw cehcked exception in Callable
//				}
//				return "Done";
//			};
//			
//			Runnable r2 = () -> {
//				try {
//					System.out.println("Sleeping");
//					Thread.sleep(15000);
//					System.out.println("Sleeping Done");
//
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
////					throw new Exception("adadadad"); cannot throw checked execption in runnable
//				}
//			};
//
////			List<Callable> ls = new ArrayList<>();
////			ls.add(r1);
////			service.invokeAll((Collection<? extends Callable<T>>) ls);
//			service.submit(r1);
//			System.out.println("Reached!");
//		} catch (Exception e) {
//			System.out.println("Not reached in time");
//			e.printStackTrace();
//		} finally {
//			if (service != null)
//				service.shutdown();
//		}
//	}

}
