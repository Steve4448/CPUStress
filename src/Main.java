import java.text.NumberFormat;

public class Main {
	public static SynchronizedInteger[] syncInt = new SynchronizedInteger[3];
	public static NumberFormat nF = NumberFormat.getInstance();

	public static void main(String[] args) {
		try {
			for(int i = 0; i < syncInt.length; i++) {
				syncInt[i] = new SynchronizedInteger();
				new CounterThread(syncInt[i]).start();
			}
			int syncIntAmt = 0;
			while(true) {
				Thread.sleep(1000);
				for(int i = 0; i < syncInt.length; i++) {
					syncIntAmt += syncInt[i].getValue();
					syncInt[i].resetValue();
				}
				System.out.println(nF.format(syncIntAmt) + " operations per second.");
				syncIntAmt = 0;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
