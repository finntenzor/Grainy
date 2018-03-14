package indi.finntenzor.grainy.worker;

import indi.finntenzor.grainy.intf.IClock;
import indi.finntenzor.grainy.intf.IWorker;
import indi.finntenzor.grainy.util.JavaClock;
import indi.finntenzor.grainy.util.Util;

/**
 * AbstractWorker contains a thread can work around and around. If the work
 * throws Exception, this thread will die. At this time, you can use getError()
 * to get the stack trace string.
 * 
 * @author FinnTenzor
 *
 */
public abstract class AbstractWorker implements IWorker, Runnable {
	// Interval between two work.
	private long interval;

	// The clock to check if should work.
	private IClock clock;

	// Last work time.
	private long last;

	// The stack trace string when exception occurred.
	private String error;

	// Should the thread running.
	private boolean running;

	@Override
	public final void run() {
		last = clock.clock();
		long now;
		for (;;) {
			// wait for the next interval.
			now = clock.clock();
			if (!running || now - last < interval) {
				Util.trySleep(1);
				continue;
			}
			// work
			try {
				last = now;
				work();
			} catch (Exception e) {
				running = false;
				error = Util.exceptionToString(e);
			}
		}
	}

	/**
	 * Construct a worker with a new java clock.
	 */
	public AbstractWorker() {
		this(null);
	}

	/**
	 * Construct a worker with a clock.
	 * 
	 * @param clock The clock this worker used.
	 */
	public AbstractWorker(IClock clock) {
		this.interval = 0;
		this.clock = clock;
		this.error = "";
		this.running = false;
		init();
		new Thread(this).start();
	}

	/**
	 * Initial clock to ensure the clock is not null.
	 */
	protected void init() {
		if (this.clock == null) {
			this.clock = new JavaClock();
		}
	}

	/**
	 * Set the interval between two work.
	 * 
	 * @param interval Interval.
	 */
	protected void setInerval(long interval) {
		this.interval = interval;
	}

	/**
	 * Resume this worker.
	 */
	@Override
	public void resume() {
		if (!running) {
			running = true;
		}
	}

	/**
	 * Pause this worker.
	 */
	@Override
	public void pause() {
		running = false;
	}

	/**
	 * @return Return true if this worker is running.
	 */
	@Override
	public boolean isRunning() {
		return running;
	}

	/**
	 * This method describe how this worker work once.
	 */
	public abstract void work();

	/**
	 * Get the last stack trace string of this worker.
	 * 
	 * @return Stack trace string.
	 */
	public String getError() {
		return error;
	}

}
