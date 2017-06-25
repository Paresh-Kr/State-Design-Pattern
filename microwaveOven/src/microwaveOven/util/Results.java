package microwaveOven.util;



public class Results implements FileDisplayInterface ,StdoutDisplayInterface {
	
	
	public void writeToScreen(String s)
	{
       System.out.println("From :: -Write to Screen  :----"+ s.toString());
	}
	
	public void storeNewResult(String s){
		//do std out display

		StdoutDisplayInterface.writeToStdout(s);

		//do write to file 
		FileDisplayInterface.writeToFile(s);
	}
	

}
