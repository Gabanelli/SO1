package controller;

public class ThreadSumController extends Thread {
	int[] vetor = new int[5];
	int linha;
	
	public ThreadSumController(int[] vetor, int linha) {
		this.vetor = vetor;
		this.linha = linha;
	}
	
	@Override
	public void run() {
		printLineAndSum();
	}
	
	public void printLineAndSum() {
		int result = 0;
		for(int v : vetor) {
			result += v;
		}
		System.out.println("Linha: " + linha + " Resultado: " + result);
	}
}
