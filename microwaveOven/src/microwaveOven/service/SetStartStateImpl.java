package microwaveOven.service;

import java.util.concurrent.TimeUnit;

import microwaveOven.util.FileProcessor;



public class SetStartStateImpl 
{
	   private int previousTime=1;
	   private FileProcessor fp=null;	

	    int stop_count=0;
	    int  cooktime = 0;
		int clockkey=0;
		boolean setclock = false;
		boolean cooking=false;
		String Inputfile="";
		String Outputfile="";

	   
	   MicrowaveContext mcontext= new MicrowaveContext();
	   MicrowaveStateI CookingState= new CookingState(mcontext);
	   MicrowaveStateI PauseSate= new PauseSate(mcontext);
	   MicrowaveStateI InactiveState= new InactiveState(mcontext);
	   public SetStartStateImpl(String inputfile,String outputfile)
	   {
			Inputfile=inputfile;
			Outputfile=outputfile;

	   }

	void action(int keycode) {
		  //System.out.println(" Stop Count--"+stop_count +"Cook Time---"+cooktime);
		   switch(keycode)
		   {
		   case 0: case 1:  case 2: case 3: case 4: case 5: case 6:  case 7: case 8: case 9:
			   
			   
				   cooktime=keycode;
			  
			   break;
			   
		   case 10:  /* start/set*/
			   if(clockkey/100 >0 || clockkey /1000 >=1)
			   {
			    if(stop_count ==0)
			     {
			       InactiveState.cooking();
				   Cooktime(cooktime);
				   cooking=true;
				   stop_count=0;

			     }else if(stop_count ==1)
			     {
			    	 PauseSate.cooking(); 
					 cooking=true;
					 stop_count=0;


			     } else{
			    	 //nothing
			     }
				  
				   
			   }else
			   {
				   if(stop_count ==0)
				     {
					   InactiveState.cooking();
					   Cooktime(cooktime);
					   cooking=true;
					   stop_count=0;
					   
				     }else if(stop_count ==1)
				     {
				    	 PauseSate.cooking(); 
						   cooking=true;
						   stop_count=0;
				     } else{
				    	 //nothing
				     }
			   }
			   

	
			   break;
		   case 11:  /* Cancel/Stop*/
		    	 stop_count++; 
			     if(cooking)
			     {
			    	 if(stop_count ==0)
			    	 {
						   CookingState.cooking();
					}else if (stop_count ==1)
						   
					{
					  CookingState.pause();
						   
					}else
				     {
							   
							   PauseSate.inactive();
							   cooking=false;
				     }
			     }else{
			    	 //
			     }

			   break;
			
		   case 12: /*Set clock*/
			   setclock=true;
			   cooktime=0;
		       break;
		   default :
			   stop_count=0;
			   clockkey=keycode;
			   if(setclock)
			   {
			   if(clockkey /10000 >=1)
			   {
					System.out.println("BEEP ");
					break;
			   }
			   else if(clockkey/10 >0)
			   {
				   clockkey = Integer.parseInt(Integer.toString(clockkey) + Integer.toString(keycode));
			   }else{
				   clockkey  =Integer.parseInt(Integer.toString(keycode));
			   }
			 }
		    break;
		   }
		 

		 
		} // NOTE THAT the "appropriate actions" depend on the current state.

	 
	
	void Cooktime(int val)
	{
		int currentTime = val;	
		while(currentTime >0)
		 {
		int elapsedTime = (currentTime - previousTime);
		System.out.println("Time in seconds left for cooking: " + elapsedTime);
		currentTime= elapsedTime;
		cooktime--;
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	     }
		   CookingState.inactive();
		   cooking=false;
	}
	
	public void ReadValue(){
		 
		fp = new FileProcessor(Inputfile, Outputfile); 

	    String str;
		while ((str = fp.readLine()) != null)
		{ 
			int Number=0;
			
			try{
				Number = Integer.parseInt(str);
				
			}catch(NumberFormatException e){
				e.printStackTrace();
				System.exit(1);
			}
		System.out.println("Input value ---"+Number);
			action(Number);
		}
	}
	
}
