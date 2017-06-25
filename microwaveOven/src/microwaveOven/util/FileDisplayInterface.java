package microwaveOven.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface FileDisplayInterface 
{

	public static void writeToFile(String s)
	{
		try{
			File file=new File("ouput.txt");
			if(!file.exists()){
		    	   file.createNewFile();
		    	}
			FileWriter FW= new FileWriter(file,true);
			BufferedWriter BW= new BufferedWriter(FW);
			BW.append(s);
			BW.newLine();

			BW.close();
		}catch(IOException ie){
			System.out.println("Exception Happened in file  write");
			
		}
		
	}
}
