package microwaveOven.service;

public class MicrowaveContext implements MicrowaveStateI {
	
	private MicrowaveStateI CookingState;
	private MicrowaveStateI PauseSate;
	private MicrowaveStateI InactiveState;
	
	private MicrowaveStateI CurrentState;
	MicrowaveContext()
	{
		CookingState=(new CookingState(this));
		PauseSate=(new PauseSate(this));
		InactiveState=(new InactiveState(this));
		
		CurrentState=InactiveState;
    }
	

	public MicrowaveStateI getCurrentState() {
		return CurrentState;
	}

	public void setCurrentState(MicrowaveStateI currentState) {
		 CurrentState = currentState;
	}


	@Override
	public void cooking() {
		// TODO Auto-generated method stub
		CurrentState.cooking();
	}


	@Override
	public void pause() {
		// TODO Auto-generated method stub
		CurrentState.pause();
		
	}

	@Override
	public void inactive() {
		// TODO Auto-generated method stub
		CurrentState.inactive();
	}

	public MicrowaveStateI getCookingState() {
		return CookingState;
	}


	public void setCookingState(MicrowaveStateI cookingState) {
		CookingState = cookingState;
	}


	public MicrowaveStateI getPauseSate() {
		return PauseSate;
	}


	public void setPauseSate(MicrowaveStateI pauseSate) {
		PauseSate = pauseSate;
	}
	
	public MicrowaveStateI getInActiveState() {
		return InactiveState;
	}


	public void setInActiveState(MicrowaveStateI inactiveState) {
		InactiveState = inactiveState;
	}

}
