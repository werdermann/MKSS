package aufgabeasync;

public class BreakfastSync
{
	public static boolean randomsleep = false;

	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		System.out.println(getBread());
		System.out.println(cookEggs());
		System.out.println(toastToast());
		System.out.println(pressOrangeJuice());
		System.out.println(setTheTable());
		long end = System.currentTimeMillis();
		System.out.println("Preparation needed: "+(end-start)/1000.d+" s");
	}

	public static String getBread()
	{
		sleep(10, randomsleep);
		return "Lecker Br�tchen sind da";
	}

	public static String cookEggs()
	{
		sleep(3, randomsleep);
		return "Eier fertig";
	}

	public static String toastToast()
	{
		sleep(3, randomsleep);
		return "Toast fertig";
	}

	public static String pressOrangeJuice()
	{
		sleep(3, randomsleep);
		return "Orangensaft ist frisch gepresst";
	}

	public static String setTheTable()
	{
		sleep(2, randomsleep);
		return "Tisch ist gedeckt";
	}

	public static void sleep(long secs, boolean random)
	{
		long time = random? (long)(Math.random()*secs*1000): secs*1000;

		//System.out.println("time is: "+time);
		try
		{
			Thread.currentThread().sleep(time);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

/*
package aufgabeasync;

import java.util.function.Consumer;

public class BreakfastSync {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		BreakfastListener<String> parallelListener = new BreakfastListener<>();
		Consumer<String> sequentialListener = s -> {
			synchronized (s) {
				try {
					s.wait(10000);
					System.out.println(s);
				} catch (Exception ignored) {
				}
			}
		};

		getBread(sequentialListener);
		cookEggs(parallelListener);
		toastToast(parallelListener);
		pressOrangeJuice(parallelListener);
		setTheTable(sequentialListener);

		long end = System.currentTimeMillis();

		System.out.println("Preparation needed: " + (end - start) / 1000.d + " s");
	}


	public static void getBread(Consumer<String> consumer) {
		consumer.accept("Lecker Brötchen sind da");
	}

	public static void cookEggs(Consumer<String> consumer) {
		consumer.accept("Eier fertig");
	}

	public static void toastToast(Consumer<String> consumer) {
		consumer.accept("Toast fertig");
	}

	public static void pressOrangeJuice(Consumer<String> consumer) {
		consumer.accept("Orangensaft ist frisch gepresst");
	}

	public static void setTheTable(Consumer<String> consumer) {
		consumer.accept("Tisch ist gedeckt");
	}

}

 */
