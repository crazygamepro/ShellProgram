package edu.frostburg.cosc460.PlentyMikhelShell;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyPasteThread implements Runnable{
	String source, dest;
	Path inFile;
	Path outFile;
	byte[] sourceArray; //byte array to move bytes
	
	public CopyPasteThread(String source, String dest) {
		this.source = source;
		this.dest = dest;
		inFile = Paths.get(source);
		outFile = Paths.get(dest);
	}
	
	@Override
	public void run() {
		if(!Files.exists(outFile)) { //checks if file exists so it doesnt overwrite
			try {
				sourceArray = Files.readAllBytes(inFile); //adds bytes from infile to sourcearray
				Files.write(outFile, sourceArray); //writes all bytes from sourcearray to outfile
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("File already exists. Please try another filename.");
		}
	}

}
