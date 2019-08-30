package controller;

public class ThreadSeq extends Thread{
	int n;
	
	public ThreadSeq(int n) {
		this.n = n;
	}
	
	@Override
	public void run() {
		calcSeq();
	}
	
	public void calcSeq() {
		float resultado = 0;
		boolean signal = true;
		double calcParcial = 0;
		
		if(n%2 == 0) {
			n--;
		}
		
		for(int i = 1; i <= n; i = i + 2) {
			if(signal) {
				calcParcial = 1.0 / i;
			}else {
				calcParcial = - 1.0 / i;
			}
			resultado += calcParcial;
			signal = !signal;
		}
		resultado = 4 * resultado;
		System.out.println("N = " + n + " - Resultado = " + resultado);
	}
}
