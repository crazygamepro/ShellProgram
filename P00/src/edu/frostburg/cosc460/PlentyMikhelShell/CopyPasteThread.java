package edu.frostburg.cosc460.PlentyMikhelShell;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyPasteThread implements Runnable{
	String source, dest;
	Path inFile;
	Path outFile;
	byte[] sourceArray;
	
	public CopyPasteThread(String source, String dest) {
		this.source = source;
		this.dest = dest;
		inFile = Paths.get(source);
		outFile = Paths.get(dest);
	}
	
	@Override
	public void run() {
		try {
			System.out.println("attempting...");
			sourceArray = Files.readAllBytes(inFile);
			Files.write(outFile, sourceArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
