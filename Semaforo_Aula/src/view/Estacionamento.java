package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Estacionamento {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for(int idCarro = 0; idCarro < 4; idCarro++) {
			Thread carro = new ThreadCarro(idCarro, semaforo, idCarro);
			carro.start();
		}
	}

}
