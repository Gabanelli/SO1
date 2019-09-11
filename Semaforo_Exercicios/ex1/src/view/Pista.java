package view;

import controller.Escuderia;

public class Pista {
	
	public static int pilotosConclusores = 0;
	public static int[][] melhoresTempos = new int[14][3];

	public static void main(String[] args) {
		int qntEscuderias = 7;
		
		for(int i = 0; i < qntEscuderias; i++) {
			Thread e = new Escuderia(i + 1);
			e.start();
		}
	}

}
