package controller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.Principal;

public class ThreadNumero extends Thread{
	
	JTextField numero;
	public static int confirmacao = 0;

	public ThreadNumero(JTextField numero) {
		this.numero = numero;
	}
	
	@Override
	public void run() {
		rodarNumero();
		mostrarBotao();
		compararResultado();
	}
	
	public void rodarNumero() {
		Principal.btnJogar.setSize(0, 0);
		int qntRodadas = (int) (Math.random() * 150 + 1);
		for(int i = 0; i < qntRodadas; i++) {
			int n = (int) (Math.random() * 2 + 1);
			numero.setText(Integer.toString(n));
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		confirmacao++;
	}
	
	public void mostrarBotao() {
		if(confirmacao == 3) {
			Principal.btnJogar.setSize(89, 23);
		}
	}
	
	public void compararResultado() {
		if(ThreadNumero.confirmacao == 3) {
			if (Principal.txtNumero1.getText().contains(Principal.txtNumero2.getText()) 
					&& Principal.txtNumero2.getText().contains(Principal.txtNumero3.getText())) {
				JOptionPane.showMessageDialog(null, "Voce ganhou!");
			}else {
				JOptionPane.showMessageDialog(null, "Voce perdeu");
			}
		}
	}
	
}
