import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

public class CglibEnhancer {
	
	public static void main(String[] args) {
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, ".");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new FixedValue() {
        	@Override
        	public Object loadObject() throws Exception {
        		return "Hello cglib!";
        	}
        });
        SampleClass sample = (SampleClass)enhancer.create();
        String result = sample.test(null);
        System.out.println(result);
    }

}

class SampleClass {
	public String test(String input) {
		return "Hello world!";
	}
}