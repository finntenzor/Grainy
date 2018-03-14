package indi.finntenzor.grainy.intf;

/***
 * Worker interface. A Worker should be created paused. Use resume() to start
 * work and use pause() to stop working. The worker will automatically run work
 * around and around when it is running.
 * 
 * @author FinnTenzor
 *
 */
public interface IWorker {
	/**
	 * Resume this worker.
	 */
	void resume();

	/**
	 * Pause this worker.
	 */
	void pause();

	/**
	 * @return Return true if this worker is running.
	 */
	boolean isRunning();

	/**
	 * This method describe how this worker work once.
	 */
	void work();
}
