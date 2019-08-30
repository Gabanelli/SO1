package view;

import controller.ThreadSeq;

//import controller.ThreadCalc;

public class Principal {

	public static void main(String[] args) {
/*		int a = 10;
		int b = 2;
		int op = 2;

		for (int op = 0; op < 4; op++) {
			Thread t = new ThreadCalc(a, b, op);
			t.start();
		}*/
		
		for(int i = 0; i < 10; i++) {
			int random = (int) ((Math.random() * 100000000) + 100000000);
			Thread t = new ThreadSeq(random);
			t.run();
		}
	}

}
