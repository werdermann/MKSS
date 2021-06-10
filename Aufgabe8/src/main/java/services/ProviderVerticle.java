package services;

import io.vertx.core.*;
import io.vertx.serviceproxy.ProxyHelper;

public class ProviderVerticle extends AbstractVerticle implements IGreetService {

    @Override
    public void start() {
        ProxyHelper.registerService(ProviderVerticle.class, vertx, this, "Service");
        ProxyHelper.registerService(ProviderVerticle.class, vertx, this, "Service");
    }

    @Override
    public void greet(String name) {

    }

    @Override
    public void answer(String name, Handler<AsyncResult<String>> handler) {

    }
}
