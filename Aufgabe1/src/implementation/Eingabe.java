package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Eingabe {

	public static int leseInt() {
		int ergebnis = 0;
		String v = null;
		try {
			v = leseString();
			ergebnis = Integer.decode(v);
		} catch(NumberFormatException e) {
			try {
				if(v!=null) {
					double val = Double.parseDouble(v);
					ergebnis = (int)val;
				}
			} catch(NumberFormatException ignored) { }
		}

		return ergebnis;
	}

	public static String leseString() {
		String ergebnis;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			ergebnis = in.readLine();
		} catch(IOException e) {
			ergebnis = "";
		}
		return ergebnis;
	}

}
