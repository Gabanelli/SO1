package controller;

import java.util.concurrent.Semaphore;

public class Escuderia extends Thread {

	private int idEscuderia;
	public Semaphore semaforo;
	
	public Escuderia(int idEscuderia) {
		this.idEscuderia = idEscuderia;
		semaforo = new Semaphore(1);
	}
	
	@Override
	public void run() {
		comecarCorrida();
	}
	
	public void comecarCorrida() {
		int qntCarros = 2;
		for(int i = 0; i < qntCarros; i++) {
			Thread c = new Carro(i + 1, idEscuderia, semaforo);
			c.start();
		}
	}

}
