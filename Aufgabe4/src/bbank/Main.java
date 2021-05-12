package bbank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) throws Exception {
		Account a = new Account("213", 512);
		User u = new User("Hans", 12, a);
		
		FileOutputStream f = new FileOutputStream("data.ser");
		ObjectOutputStream s = new ObjectOutputStream(f);
		s.writeObject(u);
		s.close();
		System.out.println("wrote: "+u);
		
		FileInputStream fis = new FileInputStream("data.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object o = ois.readObject();
		ois.close();
		
		System.out.println("read: "+o);
	}
}
