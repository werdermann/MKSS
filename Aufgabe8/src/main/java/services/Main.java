package services;

import io.vertx.core.Vertx;

public class Main {

    public static void main(String[] args){
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new ProviderVerticle());
        vertx.deployVerticle(new ConsumerVerticle());
    }

}
