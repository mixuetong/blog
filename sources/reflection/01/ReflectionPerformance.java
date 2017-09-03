public class ReflectionPerformance {

    public static void main(String[] args) throws Exception {
    	if (args.length == 0) {
    		System.out.println("Please input the loop count.");
    		return;
    	}

    	int numTrials;
    	try {
    		numTrials = Integer.parseInt(args[0]);
		} catch(NumberFormatException e) {
			System.out.println("Not a number.");
			return;
		}
		
		Test[] tests = new Test[numTrials];

		long nano = System.nanoTime();
		for(int i=0; i< numTrials; i++) {
			tests[i] = new Test();
		}
		long endNano = System.nanoTime();

		System.out.println("Normal total time                : " + (endNano - nano) + "ns");
		System.out.println("Per normal instantiation took    : " + (endNano - nano)/numTrials + "ns");

		Test[] tests2 = new Test[numTrials];
		Class<Test> clazz = Test.class;
		
		nano = System.nanoTime();
		for(int i=0; i < numTrials; i++) {
			tests2[i] = clazz.newInstance();
		}
		endNano = System.nanoTime();

		System.out.println("Reflection total time            : " + (endNano - nano) + "ns");
        System.out.println("Per reflection instantiation took: " + (endNano - nano)/numTrials + "ns");

    }

}

class Test {

}