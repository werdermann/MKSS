package rmipubsub;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class SubscriberClient extends UnicastRemoteObject implements ISubscribeClient {


    protected SubscriberClient() throws RemoteException {
    }

    protected SubscriberClient(int port) throws RemoteException {
        super(port);
    }

    protected SubscriberClient(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
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
