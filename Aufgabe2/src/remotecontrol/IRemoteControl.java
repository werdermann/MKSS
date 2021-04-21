package remotecontrol;

/**
 *  Interface for a generic remote control.
 */
public interface IRemoteControl 
{
	/**
	 *  The on button was pressed.
	 *  @param no The number of the button.
	 */
	void onButtonPressed(int no);
	
	/**
	 *  The off button was pressed.
	 *  @param no The number of the button.
	 */
	void offButtonPressed(int no);
	
	/**
	 *  The undo button was pressed.
	 */
	void undoButtonPressed();
}
