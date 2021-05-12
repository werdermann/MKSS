package chat;

import java.io.BufferedReader;

public class MsgReceiver extends Thread {
    private final BufferedReader reader;

    public MsgReceiver(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        super.run();

        try {
            while (true) System.out.println(reader.readLine());
        } catch (Exception ignored) { }
    }

}