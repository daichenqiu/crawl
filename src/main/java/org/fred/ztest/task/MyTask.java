package org.fred.ztest.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by fuhua on 15/10/9.
 */
public class MyTask implements Callable<String> {

	static ExecutorService exec = Executors.newCachedThreadPool();
	
	
    public String call() throws Exception {
        // 总计耗时约10秒
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10L; i++) {
            Thread.sleep(1000); // 睡眠0.1秒
            System.out.println("---" + System.currentTimeMillis());
        }
        long end = System.currentTimeMillis();
        return String.valueOf(end - start);
    }
    
    public static void main(String[] args) throws Exception {
//    	Thread t = new Thread(new Runnable(){
//    		public void run(){
//    			long start = System.currentTimeMillis();
//    	        for (int i = 0; i < 10L; i++) {
//    	        	try{
//    	        		Thread.sleep(1000); // 睡眠0.1秒
//    	        	}catch (Exception e){
//    	        		
//    	        	}
//    	            System.out.println("---" + System.currentTimeMillis());
//    	        }
//    	        long end = System.currentTimeMillis();
//    		}
//    	});
//    	t.start();
//    	t.join();
    	
    	Future<String> t = exec.submit(new MyTask());
    	System.out.println("GET " + t.get(200,TimeUnit.SECONDS)); // 阻塞
    	
        System.out.println("end");
    }
}
