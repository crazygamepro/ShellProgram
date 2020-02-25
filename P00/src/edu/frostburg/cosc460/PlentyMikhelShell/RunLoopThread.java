package edu.frostburg.cosc460.PlentyMikhelShell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sun.tools.javac.Main;

public class RunLoopThread implements Runnable{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	ShellMethods shell = new ShellMethods();
	String input = null;
	int exit = 0;

	public RunLoopThread() {
		
	}
	
	@Override
	public void run() {
		
		while(exit == 0) {

			try {
				System.out.print("PlentySh-" + System.getProperty("user.dir") + ">");
				input = br.readLine();
				input = input.toLowerCase(); //allows for any case input string
				switch(input) {
				case "mpls":
//					shell.myls(args);
					break;
				case "mppwd":
					shell.mypwd();
					break;
					
				case "mpcp":
//					shell.mycp(source, dest);
					break;
					
				case "exit":
					shell.exit();
					break;
					
				case "?":
					shell.help();
					break;
				
				default:
//					System.out.println("Incorrect input. Try again or enter '?' for more info.");
					Thread t2 = new Thread(new OSCommand(input));
					t2.start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
