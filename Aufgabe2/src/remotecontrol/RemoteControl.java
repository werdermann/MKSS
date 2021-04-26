package remotecontrol;

import javafx.util.Pair;

/**
 *  Base implementation for the remote control.
 */
public class RemoteControl implements IRemoteControl {

	/**
	 *  The on button was pressed.
	 *  @param no The number of the button.
	 */
	public void onButtonPressed(int no) {
		System.out.println("On button pressed: "+no);
	}
	
	/**
	 *  The off button was pressed.
	 *  @param no The number of the button.
	 */
	public void offButtonPressed(int no) {
		System.out.println("Off button pressed: "+no);
	}
	
	/**
	 *  The undo button was pressed.
	 */
	public void undoButtonPressed() {
		System.out.println("Undo button pressed");
	}
}
