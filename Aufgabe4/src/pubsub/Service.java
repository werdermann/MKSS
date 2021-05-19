package pubsub;

import java.util.ArrayList;
import java.util.HashMap;

public class Service implements ISubscribeService {
    private final HashMap<String, ArrayList<ISubscribeClient>> topics = new HashMap<>();

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
        topics.get(topic).forEach(client -> client.postMessage(topic, content));
    }
}
