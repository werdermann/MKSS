package services;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.serviceproxy.ProxyHelper;

public class ConsumerVerticle extends AbstractVerticle {

    @Override
    public void start() {
        IGreetService proxy = ProxyHelper.createProxy(IGreetService.class, vertx, "Service");

        proxy.greet("Lukas");

        Handler<AsyncResult<String>> handler = stringAsyncResult -> System.out.println(stringAsyncResult.result());

        proxy.answer("Computer", handler);
    }
}
