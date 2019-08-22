package view;

import javax.swing.JOptionPane;

import controller.ProcessoController;

public class Main {

	public static void main(String[] args) {
		ProcessoController taskList = new ProcessoController();
		String os = System.getProperty("os.name");
		int opcao = 0;
		while(opcao != 9) {
			 opcao = Integer.parseInt(JOptionPane.showInputDialog("MENU\n"
						+ "1-Listar processos\n"
						+ "2-Matar processo\n"
						+ "9-Sair"));
			switch(opcao) {
			case 1:
				taskList.listarProcesso(os);
				break;
			case 2:
				String processo = JOptionPane.showInputDialog("Nome ou PID do processo:");
				taskList.matarProcesso(os, processo);
				break;
			case 9:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		}
	}

}
