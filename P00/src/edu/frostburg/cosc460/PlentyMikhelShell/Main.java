package edu.frostburg.cosc460.PlentyMikhelShell;



public class Main {
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new RunLoopThread());
		
		t1.start();
	}
	


}
