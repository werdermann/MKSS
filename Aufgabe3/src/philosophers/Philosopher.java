package philosophers;

import java.util.Random;

public class Philosopher implements Runnable {
	public enum State {
		THINKING,
		WAITING_FOR_LEFT,
		OWNING_LEFT,
		WAITING_FOR_RIGHT,
		EATING
	}
	
	protected State state;
	protected Random r = new Random();
	protected int no;
	protected Table t;
	protected int eatcnt;
	protected Thread mythread;
	
	public Philosopher(int no, Table t) {
		this.no = no;
		this.t = t;
		this.state = State.THINKING;
		t.addPhilosopher(no, this);
	}
	
	/**
	 *  Implement me
	 */
	public void run() {
		this.mythread = Thread.currentThread();
		while (true) {

			setState(State.THINKING);
			doSleep(500);

			setState(State.WAITING_FOR_LEFT);
			t.getLeftStick(no);

			setState(State.WAITING_FOR_RIGHT);
			t.getRightStick(no);

			setState(State.EATING);
			doSleep(500);

			t.releaseRightStick(no);
			t.releaseLeftStick(no);

			eatcnt++;
		}
		// implement the lifecycle of the philosoph here
		// set the philosophers state and wait when thinking and eating
		// additionally you can wait before trying to fetch the second stick

	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public int getEatCnt() {
		return eatcnt;
	}
	
	public Thread getMyThread() {
		return mythread;
	}
	
	public int getNo() {
		return no;
	}

	/**
	 *  Implement me
	 */
	protected void doSleep(int time) {
		try {
			if(t.isWaitForClicks()) {
				synchronized (this) {
					wait();
				}
			} else {
				Thread.sleep(r.nextInt(time));
			}
		} catch (Exception ignored) { }
	}
	
	public void notifyPhilosopher(int time) {
		if(time > 0) {
			doSleep(time);
		}

		try {
			synchronized(this) {
				this.notify();
			}
		} catch(Exception ignored) { }
	}
}