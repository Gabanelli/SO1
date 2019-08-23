package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelController implements ActionListener{
	
	public void encerrar() {
		System.exit(0);
	} 

	@Override
	public void actionPerformed(ActionEvent arg0) {
		encerrar();
	}
	
}
