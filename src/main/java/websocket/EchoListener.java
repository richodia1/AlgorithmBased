package websocket;

import static java.lang.System.getLogger;

import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;


public class EchoListener  implements WebSocket.Listener{

    private ExecutorService executor;

    public EchoListener(ExecutorService executor) {
        this.executor = executor;
    }

    @Override
    public void onOpen(WebSocket webSocket) {


        webSocket.sendText("This is a message", true);

        WebSocket.Listener.super.onOpen(webSocket);
    }

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
       // System.out.println("Receiving Message -->");

        System.out.println(String.format("data: %s", data));

        if (!webSocket.isOutputClosed()) {
            webSocket.sendText("This message should echoed back..", true);
        }

        return WebSocket.Listener.super.onText(webSocket, data, last);
    }

    @Override
    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
        System.out.println("CLOSING");

        System.out.println(String.format("Closed with status %d, and reason: %s", statusCode, reason));

        executor.shutdown();

        return WebSocket.Listener.super.onClose(webSocket, statusCode, reason);
    }

}
