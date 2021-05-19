package pubsub;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();

        Service service = new Service();

        service.subscribe(client1, "Dinosaurs!");
        service.subscribe(client2, "Cars!");
        service.subscribe(client1, "Cars!");
        service.subscribe(client3, "Computers!");
        service.subscribe(client1, "Computers!");

        service.publish("Dinosaurs!", "The T-Rex has returned!");
        service.publish("Computers!", "The first consumer-friendly quantum computer!");
        service.publish("Cars!", "Flying cars will be released next autumn!");
    }
}
