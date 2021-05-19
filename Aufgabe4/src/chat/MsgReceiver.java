package chat;

import javax.swing.*;
import java.io.BufferedReader;

public class MsgReceiver extends Thread {
    private final BufferedReader reader;
    private final JTextArea textArea;

    public MsgReceiver(BufferedReader reader, JTextArea textArea) {
        this.reader = reader;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        super.run();
        try {
            while (true) textArea.append(reader.readLine() + "\n");
        } catch (Exception ignored) { }
    }

}