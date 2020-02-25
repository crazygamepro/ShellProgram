package edu.frostburg.cosc460.PlentyMikhelShell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ShellMethods shell = new ShellMethods();
		String input = null;
		int exit = 0;
//		String[] phrase = null;
		
		while(exit == 0) {
			System.out.print("PlentySh-" + System.getProperty("user.dir") + ">");
			try {
				input = br.readLine();
				input = input.toLowerCase(); //allows for any case input string
				switch(input) {
				case "mpls":
//					shell.myls(input);
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
					if(input.contains("mpcp")) {
						String[] phrase = input.split("\\s+");
						shell.mycp(phrase[1], phrase[2]);
					}
					else {
					Thread t1 = new Thread(new OSCommandThread(input));
					t1.start();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	


}
