import sun.misc.ProxyGenerator;
import java.io.OutputStream;
import java.io.FileOutputStream;

public class PrintGeneratedProxyClass {

	public static void main(String[] args) {
		byte[] classBytes = ProxyGenerator.generateProxyClass("TheGeneratedProxyClass", new Class[]{Comparable.class});
		OutputStream os = null;
		try {
			os = new FileOutputStream("TheGeneratedProxyClass.class");
			os.write(classBytes);
			os.flush();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {os.close();} catch(Exception e) {}
			}
		}
	}

}
