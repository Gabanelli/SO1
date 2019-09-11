/* 
 * 4 cavaleiros caminham por um corredor, simultaneamente, de 2 a 4 m por 50 ms. O corredor � 
escuro, tem 2 km e em 500 m, h� uma �nica tocha. O cavaleiro que pegar a tocha, aumenta sua 
velocidade, somando mais 2 m  por 50 ms ao valor que j� fazia. Em 1,5 km, existe uma pedra 
brilhante. O cavaleiro que pegar a pedra, aumenta sua velocidade, somando mais 2 m  por 
50  ms  ao  valor  que  j�  fazia.  Ao  final  dos  2  km,  os  cavaleiros  se  separam  em 4
corredores cada um com uma porta e,  um  por vez  pega  uma  porta aleat�ria  (que  n�o  pode 
repetir)  e  entra  nela.  Apenas  uma  porta  leva  �  sa�da.  As  outras  3  tem  monstros  que  os 
devoram. 
*/

package view;

import java.util.concurrent.Semaphore;

import controller.Cavaleiro;

public class Corredor {
	
	public static boolean haTocha = true;
	public static boolean haPedra = true;
	public static boolean[][] portas = new boolean[4][2];
	
	public static Semaphore semaforo = new Semaphore(1);

	public static void main(String[] args) {
		int sorteada = (int) ((Math.random() * 4));
		portas[sorteada][1] = true;
		
		for(int i = 0; i < 4; i++) {
			Thread c = new Cavaleiro(i, semaforo);
			c.start();
		}
	}

}
