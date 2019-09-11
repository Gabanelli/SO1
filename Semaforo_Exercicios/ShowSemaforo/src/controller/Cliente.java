package controller;

import java.util.concurrent.Semaphore;

import view.Site;

public class Cliente extends Thread {
	
	int idCliente;
	boolean logado = false;
	Semaphore semaforo;

	public Cliente(int idCliente, Semaphore semaforo) {
		this.idCliente = idCliente;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		login();
		if(logado) {
			compra();
		}
	}
	
	public void login() {
		int tempoLogin = (int) ((Math.random() * 1950) + 50);
		try {
			Thread.sleep(tempoLogin);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tempoLogin >= 1000) {
			System.out.println("Tempo expirado do cliente " + idCliente);
			logado = true;
		}else {
			System.out.println("Login do cliente " + idCliente);		
		}
	}
	
	public void compra() {
		int tempoCompra = (int) ((Math.random() * 2000) + 1000);
		try {
			Thread.sleep(tempoCompra);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tempoCompra >= 2500) {
			System.out.println("Final de tempo de sessao do " + idCliente);
		}else {
			try {
				semaforo.acquire();
				validarCompra();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
	}
	
	public void validarCompra() {
		int qntIngressos = (int) ((Math.random() * 4) + 1);
		if(Site.qntIngressos > 0) {
			Site.qntIngressos -= qntIngressos;
			System.out.println("Cliente " + idCliente + " efetuou a compra de "+ qntIngressos + " ingressos com sucesso");
			
		}else {
			System.out.println("Ingressos esgotados ao cliente " + idCliente);
		}
	}
}