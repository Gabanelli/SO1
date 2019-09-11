package view;

import java.util.concurrent.Semaphore;

import controller.Cliente;

public class Site {
	
	public static Semaphore semaforo;
	public static int qntIngressos = 100;

	public static void main(String[] args) {
		semaforo = new Semaphore(1);
		for(int i = 0; i < 300; i++) {
			Thread c = new Cliente(i, semaforo);
			c.start();
		}
	}

}
