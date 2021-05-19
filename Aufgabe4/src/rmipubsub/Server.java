package rmipubsub;

import java.rmi.registry.Registry;

public class Server {

    public Server(Registry registry, int port) throws Exception {
        registry.bind("Service", new Service(port));
    }
}