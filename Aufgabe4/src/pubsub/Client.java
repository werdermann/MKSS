package pubsub;

public class Client implements ISubscribeClient {

    @Override
    public void postMessage(String topic, String content) {
        System.out.println("Id: " + getId() + " " + topic + " " + content);
    }

    @Override
    public String getId() {
        return this.toString();
    }

}
