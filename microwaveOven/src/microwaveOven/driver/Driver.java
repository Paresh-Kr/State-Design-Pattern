package microwaveOven.driver;

import microwaveOven.service.SetStartStateImpl;
import microwaveOven.util.FileProcessor;

public class Driver 
{

	public static void main(String[] args) 
	{
		System.out.println(" ----------Assignment-2 ------  ");

		System.out.println("##########Microwave Oven ############");
		if(args.length <1)
		{
			System.out.println("Please provide Input file");
			System.exit(1);
		}else if(args.length >2)
		{
			System.out.println("Entered More than two file");
			System.exit(1);
		}else if(args.length ==1 || args.length==2)
		{
			// fp= new FileProcessor(args[0],args[1]);
			SetStartStateImpl sssi= new SetStartStateImpl(args[0],args[1]);
			sssi.ReadValue();

		}
		 
		
		
		
		//
		//
	}
	
}
