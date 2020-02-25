package edu.frostburg.cosc460.PlentyMikhelShell;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ShellMethods implements OSShellProject {
	String dir = System.getProperty("user.dir");
	
	Path path = Paths.get(dir);
	
	@Override
	public void mypwd() {
		System.out.println("Current Directory: " + dir);
		
	}

	@Override
	public void myls(String[] args) {
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
			for(Path file: stream) {
				System.out.println(file.getFileName());
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
		

	@Override
	public boolean mycp(String source, String dest) {
		System.out.println(source);
		System.out.println(dest);
		Thread t2 = new Thread(new CopyPasteThread(source, dest));
		t2.start();
		return true;
	}

	@Override
	public void exit() {
		System.out.println("The system will exit now.");
		System.exit(0);
		
	}

	@Override
	public void help() {
		System.out.println("Hello! This is " + myName());
		System.out.println("\nCommand List: \n" + 
		"______________\n\n" +
		"MPpwd\n" + "MPls \n" + "MPcp S D");
		System.out.println("Notepad\n" + "Calc\n"  + "Exit\n" +
		"______________");
		
	}

	@Override
	public String myName() {
		
		return "Mikhel Plenty";
	}

}
