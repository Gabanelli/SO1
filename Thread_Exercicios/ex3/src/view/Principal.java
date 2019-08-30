package view;

import controller.ThreadSapo;

public class Principal {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			Thread t = new ThreadSapo(100, 10, i + 1);
			t.start();
		}
	}
}
