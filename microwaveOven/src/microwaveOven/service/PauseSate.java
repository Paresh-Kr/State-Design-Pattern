package microwaveOven.service;

import java.util.Date;

//pause state 
public class PauseSate implements MicrowaveStateI {
	private MicrowaveContext mContext;
	
	 
	public PauseSate(MicrowaveContext microwaveContext) {
		// TODO Auto-generated constructor stub
		mContext=microwaveContext;
	}

	@Override
		public void cooking() {
			// TODO Auto-generated method stub
			System.out.println(" Microwave is resume cooking");
			mContext.setCurrentState(mContext.getCookingState());

		}

		@Override
		public void pause() {
			// TODO Auto-generated method stub
			System.out.println(" Microwave is paused");

			
		}
		@Override
		public void inactive() {
			// TODO Auto-generated method stub
			  Date date = new Date();
			    System.out.println(date.toString());
			    mContext.setCurrentState(mContext.getInActiveState());

			
		}
		
		//
}
