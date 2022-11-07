package algorithm.slidingwindow;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.http.WebSocket;

public class ConsumeWebSocketCode {

    public static void main(String[] args) {
        // to be created, an IOException is thrown.
        try {
            Socket echoSocket = new Socket("localhost:",8080);        // 1st statement
            PrintWriter out =                                            // 2nd statement
                    new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =                                          // 3rd statement
                    new BufferedReader(
                            new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn =                                       // 4th statement
                    new BufferedReader(
                            new InputStreamReader(System.in));
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }



        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause().toString());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause().toString());
            e.printStackTrace();
        }
    }


}
