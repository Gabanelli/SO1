package controller;

import javax.swing.JLabel;

import view.Principal;

public class ThreadCarro extends Thread{
	public JLabel carro;
	public int velocidadeMaxima;
	public int distanciaCorrida;
	
	public ThreadCarro(JLabel carro, int velocidadeMaxima, int distanciaCorrida) {
		this.carro = carro;
		this.velocidadeMaxima = velocidadeMaxima;
		this.distanciaCorrida = distanciaCorrida;
	}
	
	@Override
	public void run() {
		acelerar();
	}
	
	public void acelerar() {
		while(carro.getX() < distanciaCorrida) {
			int xCarro = carro.getX();
			int aceleracao = (int) (Math.random() * velocidadeMaxima + 1);
			carro.setBounds(xCarro + aceleracao, carro.getY(), carro.getWidth(), carro.getHeight());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(Principal.txtVencedor.getText().contains("O")) {
			Principal.txtPerdedor.setText(carro.getText());
		}else {
			Principal.txtVencedor.setText(carro.getText());
		}
		
	}
}
