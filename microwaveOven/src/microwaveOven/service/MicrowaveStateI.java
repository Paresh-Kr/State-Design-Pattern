package microwaveOven.service;

public interface MicrowaveStateI
{
 //cooking state 
	public void cooking();
 //pause state when first time cancel pressed
	public void pause();

 //inactive state  i.e stop state.
	public void inactive();


}
