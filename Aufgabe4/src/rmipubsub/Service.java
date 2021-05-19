package rmipubsub;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class Service extends UnicastRemoteObject implements ISubscribeService {
    private final HashMap<String, ArrayList<ISubscribeClient>> topics = new HashMap<>();

    protected Service() throws RemoteException {
    }

    protected Service(int port) throws RemoteException {
        super(port);
    }

    protected Service(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public void subscribe(ISubscribeClient cl, String topic) {
        if(topics.containsKey(topic)) {
            topics.get(topic).add(cl);
        } else {
            ArrayList<ISubscribeClient> newList = new ArrayList<>();
            newList.add(cl);
            topics.put(topic, newList);
        }
    }

    @Override
    public void unsubscribe(ISubscribeClient cl, String topic) {
        topics.get(topic).remove(cl);
    }

    @Override
    public void publish(String topic, String content) {
        System.out.println("### SERVICE PUBLISHES ###");
        topics.get(topic).forEach(client -> {
            try {
                client.postMessage(topic, content);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }
}
