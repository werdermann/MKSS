package remotecontrol;

import javafx.util.Pair;

public class HomeDecorator extends RemoteDecorator {
    public HomeDecorator(IRemoteControl remote) {
        super(remote);
    }
    private Pair<Actions, Integer> lastAction;

    private boolean doorZero = false;
    private boolean doorOne = false;
    private boolean doorTwo = false;
    private boolean doorThree = false;
    private boolean doorFour = false;
    private boolean doorFive = false;
    private boolean doorSix = false;

    @Override
    public void onButtonPressed(int no) {
        super.onButtonPressed(no);

        lastAction = new Pair(Actions.ON_BUTTON_PRESSED, no);

        switch (no) {
            case 0: {
                System.out.println("Open door doorZero");
                doorZero = true;
                break;
            }
            case 1: {
                System.out.println("Open door doorOne");
                doorOne = true;
                break;
            }
            case 2: {
                System.out.println("Open door doorTwo");
                doorTwo = true;
                break;
            }
            case 3: {
                System.out.println("Open door doorThree");
                doorThree = true;
                break;
            }
            case 4: {
                System.out.println("Open door doorFour");
                doorFour = true;
                break;
            }
            case 5: {
                System.out.println("Open door doorFive");
                doorFive = true;
                break;
            }
            case 6: {
                System.out.println("Open door doorSix");
                doorSix = true;
                break;
            }
        }
    }

    @Override
    public void offButtonPressed(int no) {
        super.offButtonPressed(no);

        lastAction = new Pair(Actions.OFF_BUTTON_PRESSED, no);

        switch (no) {
            case 0: {
                System.out.println("Close door doorZero");
                doorZero = false;
                break;
            }
            case 1: {
                System.out.println("Close door doorOne");
                doorOne = false;
                break;
            }
            case 2: {
                System.out.println("Close door doorTwo");
                doorTwo = false;
                break;
            }
            case 3: {
                System.out.println("Close door doorThree");
                doorThree = false;
                break;
            }
            case 4: {
                System.out.println("Close door doorFour");
                doorFour = false;
                break;
            }
            case 5: {
                System.out.println("Close door doorFive");
                doorFive = false;
                break;
            }
            case 6: {
                System.out.println("Close door doorSix");
                doorSix = false;
                break;
            }
        }
    }

    @Override
    public void undoButtonPressed() {
        super.undoButtonPressed();

        if(lastAction.getKey() == Actions.OFF_BUTTON_PRESSED) {
            onButtonPressed(lastAction.getValue());
            lastAction = new Pair(Actions.ON_BUTTON_PRESSED, lastAction.getValue());
        } else {
            offButtonPressed(lastAction.getValue());
            lastAction = new Pair(Actions.OFF_BUTTON_PRESSED, lastAction.getValue());
        }
    }
}
