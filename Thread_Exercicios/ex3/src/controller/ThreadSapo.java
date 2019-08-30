package controller;

public class ThreadSapo extends Thread {
	private int distanciaCorrida, distanciaMaximaPulo, idSapo;
	public static int posicao = 1;
	
	public ThreadSapo(int distanciaCorrida, int distanciaMaximaPulo, int idSapo) {
		this.distanciaCorrida = distanciaCorrida;
		this.distanciaMaximaPulo = distanciaMaximaPulo;
		this.idSapo = idSapo;
	}
	
	@Override
	public void run() {
		correr();
	}
	
	private void correr() {
		int posicaoSapo = 0;
		while(posicaoSapo < distanciaCorrida) {
			int pulo = (int) (Math.random() * distanciaMaximaPulo + 1);
			posicaoSapo += pulo;
			System.out.println("Distancia percorrida do sapo " + idSapo + " :" + posicaoSapo);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Sapo " + idSapo + " chegou em " + posicao++ + " lugar");
	}
}
