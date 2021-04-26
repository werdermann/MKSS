package remotecontrol;


import javafx.util.Pair;

public class RemoteDecorator implements IRemoteControl {
    protected IRemoteControl remote;

    public RemoteDecorator(IRemoteControl remote) {
        this.remote = remote;
    }

    @Override
    public void onButtonPressed(int no) {
        remote.onButtonPressed(no);
    }

    @Override
    public void offButtonPressed(int no) {
        remote.offButtonPressed(no);
    }

    @Override
    public void undoButtonPressed() {
        remote.undoButtonPressed();
    }

}
