package microwaveOven.service;

//Inactive state
	public class InactiveState implements MicrowaveStateI {
		
		private MicrowaveContext mContext;
		public InactiveState(MicrowaveContext mC) {
			// TODO Auto-generated constructor stub
			 mContext=mC;

		}
		@Override
		public void cooking() {
			// TODO Auto-generated method stub
			System.out.println(" Microwave is cooking from inactive state ");
			mContext.setCurrentState(mContext.getCookingState());

		}

		@Override
		public void pause() {
			// TODO Auto-generated method stub
			System.out.println(" Microwave is not active,please start first");

			
		}
		
		@Override
		public void inactive() { // work like stop
			// TODO Auto-generated method stub
			System.out.println(" Microwave is already inactive state");

			
		}
		
		//
}