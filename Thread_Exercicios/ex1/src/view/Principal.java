package view;

import controller.ThreadNumberController;

public class Principal {

	public static void main(String[] args) {
		for(int i = 0; i < 5; i ++) {
			Thread t = new ThreadNumberController(i);
			t.start();
		}
	}

}
