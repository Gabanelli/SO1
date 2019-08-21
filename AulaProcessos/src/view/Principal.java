package view;

import controller.ProcController;

public class Principal {

	public static void main(String[] args) {
			ProcController proc = new ProcController();
			String os = proc.os();
			System.out.println(os);
			
			//String processo = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
			//proc.chamaProcesso(processo);
			
			String processo = "PING -t www.google.com.br";
			proc.leProcesso(processo);
	}

}
