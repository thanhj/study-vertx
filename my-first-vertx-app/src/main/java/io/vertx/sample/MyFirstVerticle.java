package io.vertx.sample;

import io.vertx.core.AbstractVerticle;

public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start() {
        System.out.println("My first verticle");
        // We create a HTTP server object
        vertx.createHttpServer()
                // The requestHandler is called for each incoming
                // HTTP request, we print the name of the thread
                .requestHandler(req -> {
                    req.response().end("Hello from AAA "
                            + Thread.currentThread().getName());
                })
                .listen(8080);
    }

}
