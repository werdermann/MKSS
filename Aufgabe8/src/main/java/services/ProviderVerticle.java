package services;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.serviceproxy.ProxyHelper;

public class ProviderVerticle extends AbstractVerticle implements IGreetService {

    @Override
    public void start() {
        ProxyHelper.registerService(IGreetService.class, vertx, this, "Service");
    }

    @Override
    public void greet(String name) {
        System.out.println("Hallo " + name);
    }

    @Override
    public void answer(String name, Handler<AsyncResult<String>> handler) {
        AsyncResult<String> response = new AsyncResult<String>() {
            @Override
            public String result() {
                return "Moin " + name;
            }

            @Override
            public Throwable cause() {
                return null;
            }

            @Override
            public boolean succeeded() {
                return false;
            }

            @Override
            public boolean failed() {
                return false;
            }
        };

        handler.handle(response);
    }
}
