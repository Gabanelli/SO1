package view;

import controller.ProcController;

public class Principal {

	public static void main(String[] args) {
			ProcController proc = new ProcController();
			String os = proc.os();
			System.out.println(os);
	}

}
