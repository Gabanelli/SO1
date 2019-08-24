package view;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController rede = new RedesController();
		String os = System.getProperty("os.name");
		
		System.out.println(rede.ip(os));
		System.out.println(rede.ping(os));
	}

}
