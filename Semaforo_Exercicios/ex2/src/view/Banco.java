package view;

import java.util.concurrent.Semaphore;

import controller.DepositoThread;
import controller.SaqueThread;

public class Banco {
	
	/*
	 * 1 - Saque
	 * 2 - Deposito
	 */
	
	public static Semaphore semaforoSaque, semaforoDeposito;

	public static void main(String[] args) {
		
		semaforoSaque = new Semaphore(1);
		semaforoDeposito = new Semaphore(1);
		
		for(int i = 0; i < 20; i++) {
			int codigoConta = (int) ((Math.random() * 89999) + 10000);
			int saldoConta = (int) ((Math.random() * 1000) + 1);
			int valorTransicionado;
			do {
				valorTransicionado = (int) ((Math.random() * 1000) + 1);
			}while(valorTransicionado > saldoConta);
			int tipoTransacao = (int) ((Math.random() * 2) + 1);
			
			if(tipoTransacao == 1) {
				Thread t = new SaqueThread(semaforoSaque, codigoConta, saldoConta, valorTransicionado);
				t.start();
			} else {
				Thread t = new DepositoThread(semaforoDeposito, codigoConta, saldoConta, valorTransicionado);
				t.start();
			}
		}
	}

}
