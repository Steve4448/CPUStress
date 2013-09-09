public class SynchronizedInteger {
	public int value = 0;

	public synchronized void resetValue() {
		value = 0;
	}

	public synchronized void addToValue() {
		value += 1;
	}

	public synchronized int getValue() {
		return value;
	}
}
