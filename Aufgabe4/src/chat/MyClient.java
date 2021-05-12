package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try {
            Socket server = new Socket("127.0.0.1", 5000);

            BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            new MsgReceiver(reader).start();

            while (true) out.println(input.readLine());

        } catch (Exception ignored) { }
    }
}
