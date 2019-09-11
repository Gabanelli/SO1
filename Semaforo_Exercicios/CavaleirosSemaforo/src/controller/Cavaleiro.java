/* 
 * 4 cavaleiros caminham por um corredor, simultaneamente, de 2 a 4 m por 50 ms. O corredor é 
escuro, tem 2000 m e em 500 m, há uma única tocha. O cavaleiro que pegar a tocha, aumenta sua 
velocidade, somando mais 2 m  por 50 ms ao valor que já fazia. Em 1500 m, existe uma pedra 
brilhante. O cavaleiro que pegar a pedra, aumenta sua velocidade, somando mais 2 m  por 
50  ms  ao  valor  que  já  fazia.  Ao  final  dos  2  km,  os  cavaleiros  se  separam  em 4
corredores cada um com uma porta e,  um  por vez  pega  uma  porta aleatória  (que  não  pode 
repetir)  e  entra  nela.  Apenas  uma  porta  leva  à  saída.  As  outras  3  tem  monstros  que  os 
devoram. 
*/

package controller;

import java.util.concurrent.Semaphore;

import view.Corredor;

public class Cavaleiro extends Thread {
	
	int idCavaleiro;
	int velocidadeAdicional = 0;
	int posicao = 0;
	boolean finalizou = false;
	
	Semaphore semaforo;

	public Cavaleiro(int idCavaleiro, Semaphore semaforo) {
		this.idCavaleiro = idCavaleiro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		correr();
		try {
			semaforo.acquire();
			entrarNaPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		semaforo.release();
	}
	
	public void correr() {
		while(posicao <= 2000) {
			int velocidade = (int) ((Math.random() * 3) + 2) + velocidadeAdicional;
			posicao += velocidade;
			if(Corredor.haTocha && posicao >= 500) {
				velocidadeAdicional += 2;
				Corredor.haTocha = false;
				System.out.println("Cavaleiro " + idCavaleiro + " pegou a tocha");
			}
			if(Corredor.haPedra && posicao >= 1500) {
				velocidadeAdicional += 2;
				Corredor.haPedra = false;
				System.out.println("Cavaleiro " + idCavaleiro + " pegou a pedra");
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void entrarNaPorta() {
		while(!finalizou) {
			int porta = (int) ((Math.random() * 4));
			if(!Corredor.portas[porta][0]) {
				if(Corredor.portas[porta][1]) {
					System.out.println("Cavaleiro " + idCavaleiro + " saiu da caverna");
				}else {
					System.out.println("Cavaleiro " + idCavaleiro + " foi DEVORADO VIVO E SEM PIEDADE pelo monstro");
				}
				Corredor.portas[porta][0] = true;
				finalizou = true;
			}
		}
	}

}
