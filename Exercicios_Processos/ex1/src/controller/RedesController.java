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
			
			if(os.contains("Windows")) {
				while(linha != null) {
					if(linha.contains("IPv4")) {
						textoAdaptadores += nomeAdaptador + "\n" + linha.toString() + "\n";
					}
					if(linha.contains("Adaptador")) {
						nomeAdaptador = linha.toString();
					}
					linha = buffer.readLine();
				}
			}else {
				while(linha != null) {
					if(linha.contains("inet ")) {			
						nomeAdaptador = linha.toString();
					}
					if(linha.contains("txqueuelen 1000")) {
						textoAdaptadores += linha.toString() + "\n" + nomeAdaptador + "\n";
					}
					linha = buffer.readLine();
				}
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textoAdaptadores;
	}

public String ping(String os) {
		String media = "";
		try {
			Process processo = Runtime.getRuntime().exec(os.contains("Windows")? "ping -n 10 www.google.com" : "ping -c 9 www.google.com");
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			int med = 0;
			
			if(os.contains("Windows")) {
				while(linha != null) {
					if(linha.contains("o=")) {
						String tempo = linha.substring(43, 45);
						med += Integer.parseInt(tempo);
					}else if(linha.contains("inacess�vel")){
						media = "Host inacess�vel";
					}
					linha = buffer.readLine();
				}
			}else {
				while(linha != null) {
					if(linha.contains("e=")) {
						String tempo = linha.substring(80, 82);
						System.out.println(tempo);
						med += Integer.parseInt(tempo);
					}else if(linha.contains("inacess�vel")){
						media = "Host inacess�vel";
					}
					linha = buffer.readLine();
				}
			}
			
			
			med = med / 10;
			if(med > 0) {
				media = "Media de ping = " + Integer.toString(med) + "ms";
			}else {
				media = "A conex�o n�o p�de ser realizada";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return media;
	}	

}
