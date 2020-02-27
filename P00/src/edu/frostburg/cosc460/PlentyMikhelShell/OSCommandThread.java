package edu.frostburg.cosc460.PlentyMikhelShell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSCommandThread implements Runnable{
	String input;
	Process pc;
	
	public OSCommandThread(String input) {
		this.input = input;
	}


		@Override
		public void run() {
			try {
				pc = Runtime.getRuntime().exec(input); //executes user input as a potential command
				
/* Simple buffered reader that gets input from from the process.
 * My program needs to show the results that are sent from the process
 * so the bufferedreader captures it and i display it
 */
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
