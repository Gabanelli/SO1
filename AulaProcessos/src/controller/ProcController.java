package controller;

import java.io.IOException;

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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
