package rmipubsub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SubscriberClient extends UnicastRemoteObject implements ISubscribeClient {

    protected SubscriberClient(int port) throws RemoteException {
        super(port);
    }

    @Override
    public void postMessage(String topic, String content) {
        System.out.println("Id: " + getId() + " " + topic + " " + content);
    }

    @Override
    public String getId() {
        return this.toString();
    }

}
