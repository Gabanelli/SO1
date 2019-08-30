package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;


public class ButtonController implements ActionListener {
	
	private JTextField txtNumero1, txtNumero2, txtNumero3;
	
	public ButtonController(JTextField txtNumero1, JTextField txtNumero2, JTextField txtNumero3) {
		this.txtNumero1 = txtNumero1;
		this.txtNumero2 = txtNumero2;
		this.txtNumero3 = txtNumero3;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		chamarThreads();
	}
	
	public void chamarThreads() {
		ThreadNumero.confirmacao = 0;
		Thread n1 = new ThreadNumero(txtNumero1);
		Thread n2 = new ThreadNumero(txtNumero2);
		Thread n3 = new ThreadNumero(txtNumero3);
		n1.start();
		n2.start();
		n3.start();
	}
}
