package pubsub;

public interface ISubscribeClient {
	void postMessage(String topic, String content);
	String getId();
}
