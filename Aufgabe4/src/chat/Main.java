package chat;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		createGui("Client");
		createGui("Server");
	}
	
	public static JFrame createGui(String title) {
		JFrame f = new JFrame(title);
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
		return f;
	}
}
