package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        MyServer server = new MyServer();
        server.startServer();
    }

    private void startServer() {
        try {
            ServerSocket socket = new ServerSocket(5000);

            while (true) {
                Socket client = socket.accept();

                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

                new MsgReceiver(reader).start();

                while (true) out.println(input.readLine());
            }
        } catch (Exception ignored) { }
    }
}