package helloworld;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class HelloWorldVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> future) {
        System.out.println("Hello World");
    }

}
