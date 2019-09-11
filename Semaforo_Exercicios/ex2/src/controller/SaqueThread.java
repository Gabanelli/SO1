package controller;

import java.util.concurrent.Semaphore;

public class SaqueThread extends Thread {
	
	private Semaphore semaforo;
	private int codigoConta, saldoConta, valorTransicionado;

	public SaqueThread(Semaphore semaforo, int codigoConta, int saldoConta, int valorTransicionado) {
		this.semaforo = semaforo;
		this.codigoConta = codigoConta;
		this.saldoConta = saldoConta;
		this.valorTransicionado = valorTransicionado;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			saque();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	public void saque() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int saldoAnterior = saldoConta;
		saldoConta -= valorTransicionado;
		System.out.println("Foi sacado da conta " + codigoConta + " R$" + valorTransicionado 
				+ ",00 | Saldo anterior: R$" + saldoAnterior + ",00 | Saldo atual: R$" 
				+ saldoConta + ",00");
	}

}
