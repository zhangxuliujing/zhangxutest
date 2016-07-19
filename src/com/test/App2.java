package com.test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.test.thread.PrintTask2;

public class App2 {

	private ThreadPoolTaskExecutor taskExecutor ;
	private PrintTask2 printTask1 ;
	private PrintTask2 printTask2 ;
	
	public ThreadPoolTaskExecutor getTaskExecutor() {
		return taskExecutor;
	}
	public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	public PrintTask2 getPrintTask1() {
		return printTask1;
	}
	public void setPrintTask1(PrintTask2 printTask1) {
		this.printTask1 = printTask1;
	}
	public PrintTask2 getPrintTask2() {
		return printTask2;
	}
	public void setPrintTask2(PrintTask2 printTask2) {
		this.printTask2 = printTask2;
	}
	
	public void execute(){
		printTask1.setName("Thread 1");
		taskExecutor.execute(printTask1);
		
		printTask2.setName("Thread 2");
		taskExecutor.execute(printTask2);
		int a = 0;
		for(;;){
		System.out.println("测试开始");	
		int count = taskExecutor.getActiveCount();
		System.out.println("Active Threads : " + count);
		try{
			Thread.sleep(10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		if(count==0){
			taskExecutor.shutdown();
			break;
		}

	}
	}
	
}
