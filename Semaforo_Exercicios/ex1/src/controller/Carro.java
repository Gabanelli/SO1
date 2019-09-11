package controller;

import java.util.concurrent.Semaphore;

import view.Pista;

public class Carro extends Thread{

	private int idCarro;
	private int idEscuderia;
	private int melhorTempoVolta;
	private Semaphore semaforo;
	
	public Carro(int idCarro, int idEscuderia, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.idEscuderia = idEscuderia;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			partir();			
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	public void partir() {
		System.out.println("Escuderia: " + idEscuderia + " Carro: " + idCarro + " iniciou");
		correr();
		completou();
		exibirResultado();
	}
	
	public void correr() {
		
		for(int i = 0; i < 3; i++) {
			int tempoVolta = (int) ((Math.random() + 1) * 2000);
			if(i == 0) {
				melhorTempoVolta = tempoVolta;
			}else {
				if(tempoVolta < melhorTempoVolta) {
					melhorTempoVolta = tempoVolta;
				}
			}
			try {
				Thread.sleep(tempoVolta);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Escuderia: " + idEscuderia + " Carro: " + idCarro 
					+ " Volta: " + (i + 1) + " Tempo: " + tempoVolta);
		}
	}
	
	public void completou() {
		Pista.melhoresTempos[Pista.pilotosConclusores][0] = idEscuderia;
		Pista.melhoresTempos[Pista.pilotosConclusores][1] = idCarro;
		Pista.melhoresTempos[Pista.pilotosConclusores][2] = melhorTempoVolta;
		Pista.pilotosConclusores++;
		System.out.println("Escuderia: " + idEscuderia + " Carro: " + idCarro + " finalizou");
	}
	
	public void exibirResultado() {
		if(Pista.pilotosConclusores == 14) {
			Pista.melhoresTempos = ordenarGrid(Pista.melhoresTempos, 14, 3);
			
			int classificacao = 1;
			System.out.println("\n------------CLASSIFICACAO------------");
			for(int[] i : Pista.melhoresTempos) {
				String temp = (classificacao < 10) ? "0" : "";
				System.out.println(temp + classificacao++ + "- Escuderia: " + 
				i[0] + " Carro: " + i[1] + " Tempo: " + i[2]);
			}
		}
	}
	
	public int [][] ordenarGrid(int[][] matriz, int l, int c) {
		for(int i=0; i < l;i++){
		       for(int j=0;j < l - 1;j++){
		           if(matriz[j][2] > matriz[j + 1][2]) {
		        	   int[] temp = matriz[j];
		        	   matriz[j] = matriz[j + 1];
		        	   matriz[j + 1] = temp;
		           }
		       }
		}
		return matriz;
	}
}

