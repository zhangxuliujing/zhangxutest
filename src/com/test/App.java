package com.test;

import com.test.thread.PrintThread;

public class App {
	private PrintThread printThread;
	
	public PrintThread getPrintThread() {
		return printThread;
	}
	public void setPrintThread(PrintThread printThread) {
		this.printThread = printThread;
	}

	public void execute(){
		printThread.start();
	}

}
