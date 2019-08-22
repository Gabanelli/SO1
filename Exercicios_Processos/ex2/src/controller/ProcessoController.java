package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessoController {
	public ProcessoController(){
		super();
	}
	
	public void listarProcesso(String os) {
		try{
			Process processo = Runtime.getRuntime().exec(os.contains("Windows") ? "TASKLIST /FO TABLE" : "ps -a");
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void matarProcesso(String os, String processo) {
		try {
			try {
				int PID = Integer.parseInt(processo);
				Runtime.getRuntime().exec("TASKKILL /PID " + PID);
				System.out.println("TASKKILL /PID " + PID);
			}catch(NumberFormatException e1) {
				processo = processo.contains(".exe") ? processo : processo + ".exe";
				Runtime.getRuntime().exec("TASKKILL /IM " + processo);
				System.out.println("TASKKILL /IM " + processo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
