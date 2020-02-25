<<<<<<< HEAD
package edu.frostburg.cosc460.PlentyMikhelShell;

import java.nio.file.Path;

public class ShellMethods implements OSShellProject {
	String dir = System.getProperty("user.dir");
	
	Path path;
	
	@Override
	public void mypwd() {
		System.out.println("Current Directory: " + dir);
		
	}

	@Override
	public void myls(String[] args) {
		
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
		// TODO Auto-generated method stub
		return "Mikhel Plenty";
	}

}
=======
package edu.frostburg.cosc460.PlentyMikhelShell;


public class ShellMethods implements OSShellProject {
	String dir = System.getProperty("user.dir");
	
	@Override
	public void mypwd() {
		System.out.println("Current Directory: " + dir);
		
	}

	@Override
	public void myls(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mycp(String source, String dest) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return "Mikhel Plenty";
	}

}
>>>>>>> 0335000a977c72ee85cf9bdea33bec569ab4bee4
