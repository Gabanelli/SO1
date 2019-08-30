package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ExecuteController implements ActionListener{
	private JTextField txtProcedimento;
	
	public ExecuteController(JTextField txtProcedimento) {
		this.txtProcedimento = txtProcedimento;
	}
	
	public void executarProcedimento() {
		try {	
			Runtime.getRuntime().exec(this.txtProcedimento.getText());
			System.exit(0);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "O processo não pôde ser encontrado");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Insira um processo valido");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		executarProcedimento();
	}
	
}
