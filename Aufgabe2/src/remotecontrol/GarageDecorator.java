package remotecontrol;

import javafx.util.Pair;

public class GarageDecorator extends RemoteDecorator {
    private boolean gateZero = false;
    private boolean gateOne = false;
    private boolean gateTwo = false;
    private boolean gateThree = false;
    private boolean gateFour = false;
    private boolean gateFive = false;
    private boolean gateSix = false;
    private Pair<Actions, Integer> lastAction;

    public GarageDecorator(IRemoteControl remote) {
        super(remote);
    }

    @Override
    public void onButtonPressed(int no) {
        super.onButtonPressed(no);

        lastAction = new Pair(Actions.ON_BUTTON_PRESSED, no);

        switch (no) {
            case 0: {
                System.out.println("Open garage gateZero");
                gateZero = true;
                break;
            }
            case 1: {
                System.out.println("Open garage gateOne");
                gateOne = true;
                break;
            }
            case 2: {
                System.out.println("Open garage gateTwo");
                gateTwo = true;
                break;
            }
            case 3: {
                System.out.println("Open garage gateThree");
                gateThree = true;
                break;
            }
            case 4: {
                System.out.println("Open garage gateFour");
                gateFour = true;
                break;
            }
            case 5: {
                System.out.println("Open garage gateFive");
                gateFive = true;
                break;
            }
            case 6: {
                System.out.println("Open garage gateSix");
                gateSix = true;
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
                System.out.println("Close garage gateZero");
                gateZero = false;
                break;
            }
            case 1: {
                System.out.println("Close garage gateOne");
                gateOne = false;
                break;
            }
            case 2: {
                System.out.println("Close garage gateTwo");
                gateTwo = false;
                break;
            }
            case 3: {
                System.out.println("Close garage gateThree");
                gateThree = false;
                break;
            }
            case 4: {
                System.out.println("Close garage gateFour");
                gateFour = false;
                break;
            }
            case 5: {
                System.out.println("Close garage gateFive");
                gateFive = false;
                break;
            }
            case 6: {
                System.out.println("Close garage gateSix");
                gateSix = false;
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
