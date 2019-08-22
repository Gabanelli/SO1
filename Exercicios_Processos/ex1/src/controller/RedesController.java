package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	public String ip(String os) {
		String textoAdaptadores = "";
		try {
			Process processo = Runtime.getRuntime().exec(os.contains("Windows")? "ipconfig" : "ifconfig");
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			String nomeAdaptador = "";
			
			while(linha != null) {
				if(linha.contains("Adaptador")) {
					nomeAdaptador = linha.toString();
				}
				if(linha.contains("IPv4")) {
					textoAdaptadores += nomeAdaptador + "\n" + linha.toString() + "\n";
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textoAdaptadores;
	}
	
}
