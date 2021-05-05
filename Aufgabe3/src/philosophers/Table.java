package philosophers;

import java.util.Arrays;

public class Table {

	/** The chop sticks */
	protected String[] sticks = new String[]{"Stick1", "Stick2", "Strick3", "Stick4", "Stick5"};
	
	/** The current owners of the sticks (who has stick 1, 2, ...). */
	protected Philosopher[] owners = new Philosopher[sticks.length];
	
	/** The philosopher that sit at the table. */
	protected Philosopher[] philosophers = new Philosopher[sticks.length];
	
	/** Wait for times or click events. */
	protected boolean waitforclicks;
	
	public Table(boolean waitforclicks) {
		this.waitforclicks = waitforclicks;
	}

	public void addPhilosopher(int no, Philosopher p) {
		philosophers[no] = p;
	}
	
	public Philosopher getPhilosopher(int no) {
		return philosophers[no];
	}
	
	public void getLeftStick(int no) {
		getStick(no);
	}
	
	public void getRightStick(int no) {
		getStick(no==0? sticks.length-1: no-1);
	}
	
	/**
	 *  Implement me
	 */
	public void getStick(int no) {

		try {
			synchronized (this.sticks[no]) {

				while (this.owners[no] != null) {
					this.sticks[no].wait();
				}

				this.owners[no] = this.getPhilosopherByThread(Thread.currentThread());
			}
		} catch (Exception ignored) { }


		// grab the stick (or wait for it if not available)
		// save the current owner in the owners array (use getPhilosopherByThread to fetch the philosopher of the invocation)
		// note: think about synchronization. Which object you should use to ensure funtioning if multiple philosophs call at the same time 
	}
	
	public void releaseLeftStick(int no) {
		releaseStick(no);
	}
	
	public void releaseRightStick(int no) {
		releaseStick(no==0? sticks.length-1: no-1);
	}
	
	/**
	 *  Implement me
	 */
	public void releaseStick(int no) {
		synchronized (this.sticks[no]) {
			/**
			 * Set current owner to null
			 */
			this.owners[no] = null;
			/**
			 * Notify sticks
			 */
			this.sticks[no].notify();
		}

		// release the stick if the calling thread (philosoph) is the owner of the stick
		// notify other philosoph possibly already waiting for the stick
		// note: think about synchronization. You should use the same synchronization object as in getStick()
	}
	
	public Philosopher getPhilosopherByThread(Thread t) {
		Philosopher ret = null;
		
		for(Philosopher p: philosophers) {
			if(p.getMyThread().equals(t)) {
				ret = p;
				break;
			}
		}
		if(ret == null) {
			throw new RuntimeException();
		}

		return ret;
	}
	
	public Philosopher getStickOwner(int no) {
		return owners[no];
	}
	
	public boolean isWaitForClicks() {
		return waitforclicks;
	}
	
	public void setWaitForClicks(boolean waitforclicks) {
		this.waitforclicks = waitforclicks;
	}
	
	public void notifyAllPhilosophers() {
		for(Philosopher p: philosophers) {
			p.notifyPhilosopher(100);
		}
	}

	public String toString() {
		return Arrays.toString(owners);
	}
}
