# Reference引用

## 示例

```java
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
```

输出如下：

```
Times 1
Times 2
Times 3
Times 4
Times 5
Times 6
Times 7
Times 8
Times 9
Times 10
GC has been invoked
WeakReference's referent has been cleaned
```

!java 

