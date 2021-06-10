package pingpong;

import io.vertx.core.AbstractVerticle;

public class PingVerticle extends AbstractVerticle {

    /**
     * Unterschied zwischen send und publish:
     * Bei publish() wird jeder zugehörige Listener benachrichtigt.
     * Bei send() wird ein einziger Listener benachrichtigt.
     */
    @Override
    public void start() {
        vertx.setPeriodic(1000L, value -> vertx.eventBus().publish("Channel", "Today will be a beautiful day!"));
        vertx.eventBus().consumer("Reply", (message) -> System.out.println("Reply: " + message.body()));
    }

}
