package remotecontrol;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

/**
 *  Base implementation for the remote control.
 */
public class RemoteControl implements IRemoteControl {
	private final List<SimpleEntry<Command, Integer>> history;
	private final Command firstCommand;
	private final Command secondCommand;

	RemoteControl(Command firstCommand, Command secondCommand) {
		this.firstCommand = firstCommand;
		this.secondCommand = secondCommand;
		history = new ArrayList<>();
	}

	/**
	 *  The on button was pressed.
	 *  @param no The number of the button.
	 */
	@Override
	public void onButtonPressed(int no) {
		System.out.println("On button pressed: "+no);

		firstCommand.execute(no);
		history.add(new SimpleEntry(firstCommand, no));
	}

	/**
	 *  The off button was pressed.
	 *  @param no The number of the button.
	 */
	@Override
	public void offButtonPressed(int no) {
		System.out.println("Off button pressed: "+no);

		secondCommand.execute(no);
		history.add(new SimpleEntry(secondCommand, no) {
		});
	}
	
	/**
	 *  The undo button was pressed.
	 */
	@Override
	public void undoButtonPressed() {
		System.out.println("Undo button pressed");
		history.remove(history.size() - 1);
		SimpleEntry<Command, Integer> lastMove = history.get(history.size() - 1);
		lastMove.getKey().execute(lastMove.getValue());
	}

}
