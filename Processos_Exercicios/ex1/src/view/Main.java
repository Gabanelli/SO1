package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController rede = new RedesController();
		String os = System.getProperty("os.name");
		
		int opcao = 0;
		while(opcao != 9) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu\n"
					+ "1-Verificar redes com IPv4\n"
					+ "2-Teste de ping com Google\n"
					+ "9-Sair"));
			switch(opcao) {
			case 1:
				System.out.println(rede.ip(os));
				break;
			case 2:
				System.out.println(rede.ping(os));
				break;
			case 9:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcao invalida");
			}
		}
	}

}
