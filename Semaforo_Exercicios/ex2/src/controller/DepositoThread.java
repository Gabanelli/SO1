package controller;

import java.util.concurrent.Semaphore;

public class DepositoThread extends Thread{

	private Semaphore semaforo;
	private int codigoConta, saldoConta, valorTransicionado;

	public DepositoThread(Semaphore semaforo, int codigoConta, int saldoConta, int valorTransicionado) {
		this.semaforo = semaforo;
		this.codigoConta = codigoConta;
		this.saldoConta = saldoConta;
		this.valorTransicionado = valorTransicionado;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			deposito();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	public void deposito() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int saldoAnterior = saldoConta;
		saldoConta += valorTransicionado;
		System.out.println("Foi depositado na conta " + codigoConta + " R$" + valorTransicionado 
				+ ",00 | Saldo anterior: R$" + saldoAnterior + ",00 | Saldo atual: R$" 
				+ saldoConta + ",00");
	}

}
