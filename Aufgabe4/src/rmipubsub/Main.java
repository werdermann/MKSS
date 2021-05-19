package rmipubsub;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) throws Exception {
        int port = 9003;
        Registry registry = LocateRegistry.createRegistry(port);
        new Server(registry, port);
        new Client(registry, port);
    }

}
