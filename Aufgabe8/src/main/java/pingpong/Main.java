package pingpong;

import io.vertx.core.Vertx;

public class Main {

    public static void main(String[] args){
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new PongVerticle());
        vertx.deployVerticle(new PongVerticle());
        vertx.deployVerticle(new PongVerticle());
        vertx.deployVerticle(new PingVerticle());
    }

}
