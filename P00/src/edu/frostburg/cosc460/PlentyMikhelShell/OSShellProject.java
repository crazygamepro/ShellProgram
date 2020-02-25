package edu.frostburg.cosc460.PlentyMikhelShell;

/**
 * Interface for the Shell program.  Implement the following methods, following the specifications provided.
 * @author mplenty
 *
 */

public interface OSShellProject {

	/** Print working directory */
	void mypwd();
	
	/** List current directory */
	void myls(String[] args);
	
	/** Copy source file to destination.  If there are any problems, return false, otherwise true */
	boolean mycp(String source, String dest);
	
	/** Print an exit message and quit the program */
	void exit();
	
	/** Print instructions on how to use this program including all available commands */
	void help();
	
	/** Return your name as a String */
	String myName();	
}
