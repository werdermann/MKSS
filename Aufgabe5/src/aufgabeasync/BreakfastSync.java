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
