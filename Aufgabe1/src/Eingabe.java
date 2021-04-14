
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Eingabe {

	public static boolean leseBoolean() {
		boolean ergebnis;
		try {
			ergebnis = Boolean.parseBoolean(leseString());
		} catch(NumberFormatException e) {
			ergebnis = false;
		}

		return ergebnis;
	}

	public static double leseDouble() {
		double ergebnis;
		try {
			ergebnis = Double.parseDouble(leseString());
		} catch(NumberFormatException e) {
			ergebnis = 0d;
		}

		return ergebnis;
	}

	public static float leseFloat() {
		float ergebnis;
		try {
			ergebnis = Float.parseFloat(leseString());
		} catch(NumberFormatException e) {
			ergebnis = 0f;
		}

		return ergebnis;
	}

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
