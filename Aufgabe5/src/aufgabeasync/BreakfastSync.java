package aufgabeasync;

import java.util.Timer;

public class BreakfastSync {

	public static boolean randomsleep = false;


	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		System.out.println(getBread());

		BreakfastListener listener = new BreakfastListener();

		listener.accept("Eier fertig");
		listener.accept("Toast fertig");
		listener.accept("Orangensaft ist frisch gepresst");

		System.out.println(setTheTable());

		long end = System.currentTimeMillis();


		System.out.println("Preparation needed: "+(end-start)/1000.d+" s");





	}

	// TODO: Sequenziell
	public static String getBread()
	{
		sleep(3, randomsleep);
		return "Lecker Brötchen sind da";
	}

	// TODO: Sequenziell
	public static String setTheTable()
	{
		sleep(3, randomsleep);
		return "Tisch ist gedeckt";
	}
	
	public static void sleep(long secs, boolean random)
	{
		long time = random? (long)(Math.random()*secs*1000): secs*1000;
		
		System.out.println("time is: "+time);
		try {
			Thread.sleep(time);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
