package view;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController rede = new RedesController();
		System.out.println(rede.ip(System.getProperty("os.name")));
	}

}
