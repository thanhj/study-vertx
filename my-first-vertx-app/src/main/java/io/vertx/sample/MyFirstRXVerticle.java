package io.vertx.sample;


import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.http.HttpServer;

public class MyFirstRXVerticle extends AbstractVerticle {
    @Override
    public void start() {
        HttpServer server = vertx.createHttpServer();

        // We get the stream of request as Observable
        server.requestStream().toObservable()
                .subscribe(req ->
                        // for each HTTP request, this method is called
                        req.response().end(
                                "Hello from " + Thread.currentThread().getName()
                        )
                );

        server.rxListen(8080)
                .subscribe();

    }
}
