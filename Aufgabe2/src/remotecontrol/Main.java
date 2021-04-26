package remotecontrol;

/**
 *  Main for testing the functionality
 */
public class Main 
{
	/**
	 *  Main method for trying out the functionality.
	 */
	public static void main(String[] args) 
	{
		RemoteDecorator rc1 = new HomeDecorator(new RemoteControl());
		RemoteDecorator rc2 = new GarageDecorator(new RemoteControl());
		
		// todo: configure the remote controls for different houses
		
		// todo: test the functionality by pressing different buttons similar to below
		
		rc1.onButtonPressed(1);
		rc1.offButtonPressed(1);
		rc1.undoButtonPressed();

		System.out.println("###");
		
		rc2.onButtonPressed(1);
		rc2.undoButtonPressed();
	}
}
