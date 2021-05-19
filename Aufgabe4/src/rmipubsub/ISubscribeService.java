package rmipubsub;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISubscribeService extends Remote {
	void subscribe(ISubscribeClient cl, String topic) throws RemoteException;
	void unsubscribe(ISubscribeClient cl, String topic) throws RemoteException;
	void publish(String topic, String content) throws RemoteException;
}
