package pingpong;

import io.vertx.core.AbstractVerticle;

public class PongVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.eventBus().consumer("Channel", (message) -> {
            System.out.println("Message: " + message.body());
            vertx.eventBus().send("Reply", "Message arrived!");
        });
    }

}
