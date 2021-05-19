package rmipubsub;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISubscribeClient extends Remote {
	void postMessage(String topic, String content) throws RemoteException;
	String getId() throws RemoteException;
}
