package edu.frostburg.cosc460.PlentyMikhelShell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSCommand implements Runnable{
	String input;
	Process pc;
	
	public OSCommand(String input) {
		this.input = input;
	}


		@Override
		public void run() {
			try {
				pc = Runtime.getRuntime().exec(input);
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(pc.getInputStream()));
			    String line;
			    while ((line = reader.readLine()) != null) {
			        System.out.println(line);
			    }
			 
			    reader.close();
			    Thread.sleep(100);
			}
			catch(IOException | InterruptedException e) {
				
			}
			
		}
}

