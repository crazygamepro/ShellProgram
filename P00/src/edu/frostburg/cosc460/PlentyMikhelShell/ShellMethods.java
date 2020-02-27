package edu.frostburg.cosc460.PlentyMikhelShell;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ShellMethods implements OSShellProject {
	String dir = System.getProperty("user.dir"); //user.dir saved my life.. gives me the absolute (i think) path
	
	Path path = Paths.get(dir); 
	
	@Override
	public void mypwd() {
		System.out.println("Current Directory: " + dir);
		
	}


/*	simple list method. Used directorystream to pull all file info
 * for loop to print out each filename as the stream iterates through the path
 */
	@Override
	public void myls() {
		System.out.println("____________\n");
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
			for(Path file: stream) {
				System.out.println(file.getFileName());
			}
			System.out.println("____________");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
		
/* Hardest method in my opinion. Created a thread to have all copy/pasting on a different thread
*	Again, not sure if how im implementing it is helpful in any way.
*/
	@Override
	public boolean mycp(String source, String dest) {
		Thread t2 = new Thread(new CopyPasteThread(source, dest));
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}

//	Self explanatory exit method. Calls system exit
	@Override
	public void exit() {
		System.out.println("The system will exit now.");
		System.exit(0);
		
	}

//	Prints all commands
	@Override
	public void help() {
		System.out.println("Hello! This is " + myName());
		System.out.println("\nCommand List: \n" + 
		"____________\n\n" +
		"MPpwd\n" + "MPls \n" + "MPcp S D");
		System.out.println("Notepad\n" + "Calc\n"  + "Exit\n" +
		"____________");
		
	}

	@Override
	public String myName() {
		
		return "Mikhel Plenty";
	}

}
