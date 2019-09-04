package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{
	
	/*	0 - Norte
	 *  1 - Sul
	 *  2 - Leste
	 *  3 - Oeste
	*/

	private int idCarro;
	private Semaphore semaforo;
	private int origem;
	
	public ThreadCarro(int idCarro, Semaphore semaforo, int origem) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
		this.origem = origem;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			cruzar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	private void cruzar() {
		int destino;
		do {
			destino = (int) ((Math.random() * 4));
		}while(destino == origem);
		
		String origemS = null, destinoS = null;
		
		switch(origem) {
		case 0:
			origemS = "Norte";
			break;
		case 1:
			origemS = "Sul";
			break;
		case 2:
			origemS = "Leste";
			break;
		case 3:
			origemS = "Oeste";
			break;
		}
		
		switch(destino) {
		case 0:
			destinoS = "Norte";
			break;
		case 1:
			destinoS = "Sul";
			break;
		case 2:
			destinoS = "Leste";
			break;
		case 3:
			destinoS = "Oeste";
			break;
		}
		
		System.out.println("Carro " + idCarro + " foi de " + origemS + " ate " + destinoS);
	}

}
