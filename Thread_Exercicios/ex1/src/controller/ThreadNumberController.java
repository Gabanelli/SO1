package controller;

public class ThreadNumberController extends Thread {
	int n;
	
	public ThreadNumberController(int n) {
		this.n = n;
	}
	
	@Override
	public void run() {
		printNumber();
	}
	
	public void printNumber() {
		System.out.println(n);
	}
}
