package aufgabeasync;

import java.util.function.Consumer;

public class BreakfastSync {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		BreakfastListener<String> listener = new BreakfastListener<>();
		Consumer<String> sequentialListener = s -> {
			synchronized (s) {
				try {
					s.wait(10000);
					System.out.println(s);
				} catch (Exception ignored) {
				}
			}
		};

		// Runs sequential
		sequentialListener.accept("Lecker Brötchen sind da");

		// Runs parallel
		listener.accept("Eier fertig");
		listener.accept("Toast fertig");
		listener.accept("Orangensaft ist frisch gepresst");

		// Runs sequential
		sequentialListener.accept("Tisch ist gedeckt");

		long end = System.currentTimeMillis();

		System.out.println("Preparation needed: " + (end - start) / 1000.d + " s");
	}

}
