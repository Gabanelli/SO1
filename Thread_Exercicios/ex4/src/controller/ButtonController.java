package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import view.Principal;

public class ButtonController implements ActionListener {
	
	public JLabel carro1;
	public JLabel carro2;
	
	public ButtonController(JLabel carro1, JLabel carro2) {
		this.carro1 = carro1;
		this.carro2 = carro2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		iniciarThreads();
	}
	
	public void iniciarThreads() {
		carro1.setBounds(20, 59, 54, 22);
		carro2.setBounds(20, 105, 54, 22);
		
		Principal.txtVencedor.setText("");
		Principal.txtPerdedor.setText("");

		Thread carro1 = new ThreadCarro(this.carro1, 20, 482);
		Thread carro2 = new ThreadCarro(this.carro2, 20, 482);
		
		carro1.start();
		carro2.start();
	}

}
