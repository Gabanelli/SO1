package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SelectController implements ActionListener{
	private JTextField txtProcedimento;
	
	public SelectController(JTextField txtProcedimento) {
		this.txtProcedimento = txtProcedimento;
	}

	public void abrirSeletor() {
		JFileChooser file = new JFileChooser();
		file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if(System.getProperty("os.name").contains("WIndows")) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter(".exe", "Run Files");
			file.setFileFilter(filter);
		}
		int returnVal = file.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			txtProcedimento.setText(file.getSelectedFile().getAbsolutePath());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		abrirSeletor();
	}
	
}
