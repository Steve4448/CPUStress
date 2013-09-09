public class CounterThread extends Thread {
	private SynchronizedInteger syncInt = null;

	public CounterThread(SynchronizedInteger syncInt) {
		this.syncInt = syncInt;
	}

	@Override
	public void run() {
		while(true)
			syncInt.addToValue();
	}
}
