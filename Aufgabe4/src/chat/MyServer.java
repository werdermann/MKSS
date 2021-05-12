package chat;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        JFrame f = new JFrame("Server");
        Container p = f.getContentPane();
        JTextField tf = new JTextField(10);
        JTextArea ta = new JTextArea(10, 30);
        p.add(new JLabel("Received Messages"), BorderLayout.NORTH);
        p.add(ta, BorderLayout.CENTER);
        JPanel ps = new JPanel(new BorderLayout());
        JButton send = new JButton("Send");
        ps.add(tf, BorderLayout.CENTER);
        ps.add(send, BorderLayout.EAST);
        p.add(ps, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);

        try {
            ServerSocket socket = new ServerSocket(5000);
            while (true) {
                Socket client = socket.accept();

                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                new MsgReceiver(reader, ta).start();

                send.addActionListener(e -> out.println(tf.getText()));
            }
        } catch (Exception ignored) { }
    }
}