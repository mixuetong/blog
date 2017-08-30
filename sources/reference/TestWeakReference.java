import java.lang.ref.WeakReference;

public class TestWeakReference {

	public static void main(String[] args) {
		TestWeakReference obj = new TestWeakReference();
		WeakReference<TestWeakReference> wRef = new WeakReference<>(obj);
		obj = null;

		int i = 0;
		while(true) {
			Object target = wRef.get();
			if(target == null) {
				System.out.println("WeakReference's referent has been cleaned");
				break;
			}
			System.out.println(String.format("Times %d", ++i));
			target = null;

			if (i % 10 == 0) {
				// Suggests that the Java Virtual Machine expend effort toward recycling unused objects
				System.gc();
				System.out.println("GC has been invoked");
			}

			try {Thread.sleep(1000);} catch(InterruptedException e) {}
		}
	}

}