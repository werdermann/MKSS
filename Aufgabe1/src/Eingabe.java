
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Eingabe
{

	public static boolean leseBoolean()
	{
		boolean ergebnis;
		try
		{
			ergebnis = Boolean.valueOf(leseString()).booleanValue();
		}
		catch(NumberFormatException e)
		{
			ergebnis = false;
		}

		return ergebnis;
	}

	public static double leseDouble()
	{
		double ergebnis;
		try
		{
			ergebnis = Double.valueOf(leseString()).doubleValue();
		}
		catch(NumberFormatException e)
		{
			ergebnis = 0d;
		}

		return ergebnis;
	}

	public static float leseFloat()
	{
		float ergebnis;
		try
		{
			ergebnis = Float.valueOf(leseString()).floatValue();
		}
		catch(NumberFormatException e)
		{
			ergebnis = 0f;
		}

		return ergebnis;
	}

	public static int leseInt()
	{
		int ergebnis = 0;
		String v = null;
		try
		{
			v = leseString();
			ergebnis = Integer.decode(v).intValue();
		}
		catch(NumberFormatException e)
		{
			try
			{
				if(v!=null)
				{
					double val = Double.valueOf(v).doubleValue();
					ergebnis = (int)val;
				}
			}
			catch(NumberFormatException e2)
			{
			}
		}

		return ergebnis;
	}

	public static String leseString()
	{
		String ergebnis;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			ergebnis = in.readLine();
		}
		catch(IOException e)
		{
			ergebnis = "";
		}
		return ergebnis;
	}

	// rein zu Testzwecken hier stehen gelassen, kann gel�scht werden
	public static void main(String[] s)
	{
		int eingabe = 0;
		while(eingabe != -1)
		{
			System.out.print("Text eingeben: ");
			System.out.println("Eingeben wurde:" + Eingabe.leseString());
			System.out.print("Float eingeben: ");
			System.out.println("Eingeben wurde:" + Eingabe.leseFloat());
			System.out.print("Double eingeben: ");
			System.out.println("Eingeben wurde:" + Eingabe.leseDouble());
			System.out.print("Boolean eingeben: ");
			System.out.println("Eingeben wurde:" + Eingabe.leseBoolean());
			System.out.print("Ganze Zahl eingeben (Abbruch mit -1): ");
			eingabe = Eingabe.leseInt();
			System.out.println("Eingeben wurde: " + eingabe);
		}
	}
}
