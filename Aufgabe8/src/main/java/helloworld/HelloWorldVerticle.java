package helloworld;

public class HelloWorldVerticle extends AbstractVerticle {

    @Override
    void start() {
        System.out.println("Hello World");
    }
}
