package helloworld;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class HelloWorldVerticle extends AbstractVerticle {

    @Override
    public Vertx getVertx() {
        return null;
    }

    @Override
    public void init(Vertx vertx, Context context) { }

    @Override
    public void start(Future<Void> future) {
        System.out.println("Hello World");
    }

    @Override
    public void stop(Future<Void> future) { }
}
