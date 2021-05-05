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

		// implement the lifecycle of the philosoph here
		// set the philosophers state and wait when thinking and eating
		// additionally you can wait before trying to fetch the second stick

		while (true) {
			this.setState(State.THINKING);
			this.doSleep(2000);

			this.setState(State.WAITING_FOR_LEFT);
			this.t.getLeftStick(this.no);
			this.doSleep(500);

			this.setState(State.OWNING_LEFT);
			this.doSleep(500);

			this.setState(State.WAITING_FOR_RIGHT);
			this.t.getRightStick(this.no);
			this.doSleep(500);


			this.setState(State.EATING);
			this.doSleep(2000);

			this.t.releaseRightStick(this.no);
			this.t.releaseLeftStick(this.no);

			eatcnt++;
		}
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
					this.wait();
				}
			} else {
				Thread.sleep(this.r.nextInt(time));
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