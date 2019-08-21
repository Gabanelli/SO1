package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcController {
	
	public ProcController() {
		super();
	}
	
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void chamaProcesso(String processo) {
		try {
			Runtime.getRuntime().exec(processo);
		} catch (Exception e) {
			if(e.getMessage().contains("740")) {
				//cmd /c processo
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(processo);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else {
				e.printStackTrace();
			}
		}
	}
	
	public void leProcesso(String nomeProcesso) {
		try {
			Process processo = Runtime.getRuntime().exec(nomeProcesso);
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
	
	public void mataProcesso(String param) {
		String cmdPid = "TASKKILL /PID ";
		String cmdNome = "TASKKILL /IM ";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		try {
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(pid);
		}catch(NumberFormatException e) {
			buffer.append(cmdNome);
			buffer.append(param);
		}
		chamaProcesso(buffer.toString());
	}
}
