package com.rev.web;

import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {

        //Create a new Javalin instance and start it on a port
        Javalin app = Javalin.create().start(8080);

        app.get("/", ctx -> ctx.result("Hello world!"));
        app.get("/hello", ctx -> ctx.json("Hello world again"));

        app.get("/user/{name}", ctx -> {
           String name = ctx.pathParam("name");
           ctx.result("Hello Again" + name.toUpperCase());
        });

        app.get("/user", ctx -> {
            String name = ctx.queryParam("name");
            String age = ctx.queryParam("age");
            ctx.result("Hello again "+ name.toUpperCase() + " " + age);
        });

    }


}
