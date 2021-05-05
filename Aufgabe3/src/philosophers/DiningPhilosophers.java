package philosophers;

public class DiningPhilosophers {
	public static void main(String[] args) {
		Table t = new Table(false);
		TableGui gui = new TableGui(t);
		
		for(int i=0; i<5; i++) {
			Thread p = new Thread(new Philosopher(i, t));
			p.start();
		}
	}
}
