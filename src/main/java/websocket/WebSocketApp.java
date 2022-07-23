package websocket;

import static java.lang.Thread.sleep;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebSocketApp {
    private static final ExecutorService executor = Executors.newFixedThreadPool(3);


    public static void main(String... args) throws InterruptedException {

        HttpClient httpClient = HttpClient.newBuilder().executor(executor).build();

        WebSocket webSocket = httpClient.newWebSocketBuilder()
                .buildAsync(URI.create("ws://localhost:8032/instruments"),
                        new EchoListener(executor))
                .join();

        //System.out.println("WebSocket created");

        sleep(800);

        webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok")
                .thenRun(() ->  System.out.println("Sent close"))
                .join();

    }
}
