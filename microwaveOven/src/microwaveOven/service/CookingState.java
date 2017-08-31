package microwaveOven.service;

import java.util.Date;

public class CookingState implements MicrowaveStateI {
		private MicrowaveContext mContext;

		
		public CookingState(MicrowaveContext microwaveContext) {
			// TODO Auto-generated constructor stub
			mContext=microwaveContext;

		}

		@Override
		public void cooking() {
			// TODO Auto-generated method stub
			System.out.println(" Microwave is already cooking");
			
		}

		@Override
		public void pause() {
			// TODO Auto-generated method stub
			System.out.println(" Microwave is paused");
			mContext.setCurrentState(mContext.getPauseSate());

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


