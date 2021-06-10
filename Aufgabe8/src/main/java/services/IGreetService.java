package services;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

@ProxyGen
@VertxGen
public interface IGreetService
{
	 void greet(String name);
	 
	 void answer(String name, Handler<AsyncResult<String>> handler);
}

