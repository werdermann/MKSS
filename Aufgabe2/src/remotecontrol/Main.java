package remotecontrol;

/**
 *  Main for testing the functionality
 */
public class Main {
	/**
	 *  Main method for trying out the functionality.
	 */
	public static void main(String[] args) 
	{
		RemoteControl rc1 = new RemoteControl(new OnBtnCmd1(), new OffBtnCmd1());
		RemoteControl rc2 = new RemoteControl(new OnBtnCmd2(), new OffBtnCmd2());

		rc1.onButtonPressed(1);
		rc1.offButtonPressed(1);
		rc1.undoButtonPressed();

		System.out.println("###");

		rc2.onButtonPressed(1);
		rc2.onButtonPressed(1);
		rc2.undoButtonPressed();
		rc2.onButtonPressed(3);
		rc2.onButtonPressed(4);
		rc2.undoButtonPressed();

	}
}
