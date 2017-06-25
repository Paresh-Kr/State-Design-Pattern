package microwaveOven.driver;

import microwaveOven.util.FileProcessor;

public class Driver 
{

	public static void main(String[] args) 
	{
		System.out.println(" Microwave Oven ");
		FileProcessor fp = null;
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
			 fp= new FileProcessor(args[0],args[1]);

		}
		//String st1 = "Hello";
		//String st2 = "Where there is will, there is a way";
		//Results rslt=new Results();
		//rslt.storeNewResult(st1);
		//rslt.storeNewResult(st2);
		//
		//
	}
	
}
