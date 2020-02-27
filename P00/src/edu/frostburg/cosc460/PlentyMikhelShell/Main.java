package edu.frostburg.cosc460.PlentyMikhelShell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ShellMethods shell = new ShellMethods();	//variable to call interface methods
		String input = null;
		int exit = 0;
		
		while(exit == 0) {
			System.out.print("PlentySh-" + System.getProperty("user.dir") + ">");
			try {
				input = br.readLine();
				input = input.toLowerCase(); //allows for any case input string
				switch(input) {  //switch statements for commands
				case "mpls":
					shell.myls();
					break;
				case "mppwd":
					shell.mypwd();
					break;
					
				case "exit":
					shell.exit();
					break;
					
				case "?":
					shell.help();
					break;
				
				default:
						/*OS commands set under default to essentially accept any command already designed by the os
						*mpcp also under default due to switch statement restrictions
						*aka couldnt figure out how to get the switch statement to accept any source/dest string
						*/
					if(input.contains("mpcp")) {
						String[] phrase = input.split("\\s+");
						shell.mycp(phrase[1], phrase[2]);
					}
					else {
						//created a thread to allow for concurrent tasking... or at least that was the idea
						//with my limited knowledge on threads, im not sure if this was useful or i just did more work...
					Thread t1 = new Thread(new OSCommandThread(input));
					t1.start();
					try {
						t1.join();			//current thread waits for t1 to finish before continuing
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	


}
