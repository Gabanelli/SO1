package view;

import controller.ThreadSumController;

public class Principal {
	
	public static void main(String[] args) {
		int[][] matriz = new int[3][5];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				matriz[i][j] = (int) (Math.random() * 100 + 1);
			}
		}
		
		for(int i = 0; i < 3; i++) {
			String txt = "";
			for(int j = 0; j < 5; j++) {
				txt = txt + " " + matriz[i][j]; 
			}
			System.out.println(txt + "\n");
		}
		
		for(int i = 0; i < 3; i++) {
			Thread t = new ThreadSumController(matriz[i], i + 1);
			t.start();
		}
	}
}
