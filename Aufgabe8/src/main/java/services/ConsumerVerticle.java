package services;

import io.vertx.core.AbstractVerticle;
import io.vertx.serviceproxy.ProxyHelper;

public class ConsumerVerticle extends AbstractVerticle {

    @Override
    public void start() {
        ProviderVerticle service = ProxyHelper.createProxy(ProviderVerticle.class, vertx, "Service");
        service.greet("Hey");
        service.answer("Hey", (test) -> {

        });
    }
}
