package rmipubsub;

import java.rmi.registry.Registry;

public class Client {

    public Client(Registry registry, int port) throws Exception {
        ISubscribeService service = (ISubscribeService) registry.lookup("Service");

        SubscriberClient client1 = new SubscriberClient(port);
        SubscriberClient client2 = new SubscriberClient(port);
        SubscriberClient client3 = new SubscriberClient(port);

        service.subscribe(client1, "Dinosaurs!");
        service.subscribe(client2, "Cars!");
        service.subscribe(client1, "Cars!");
        service.subscribe(client3, "Computers!");
        service.subscribe(client1, "Computers!");

        service.publish("Dinosaurs!", "The T-Rex has returned!");
        service.publish("Computers!", "The first consumer-friendly quantum computer!");
        service.publish("Cars!", "Flying cars will be released next autumn!");

        service.unsubscribe(client1, "Cars!");

        service.publish("Cars!", "A new Tesla was just announced!");
    }

}
