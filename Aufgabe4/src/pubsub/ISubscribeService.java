package pubsub;

public interface ISubscribeService {
	void subscribe(ISubscribeClient cl, String topic);
	void unsubscribe(ISubscribeClient cl, String topic);
	void publish(String topic, String content);
}
