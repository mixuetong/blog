import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxy {
    
    public static void main(String[] args) {
    	Class<?> proxyClass = Proxy.getProxyClass(User.class.getClassLoader(), User.class);

    	User target = new UserImpl();
    	InvocationHandler handler = new UserInvocationHandler(target);

    	try {
    		User user = (User)proxyClass.getConstructor(InvocationHandler.class).newInstance(handler);
    		user.add("mix");
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}

interface User {
	void add(String name);
}

class UserImpl implements User {

	@Override
	public void add(String name) {
		System.out.println("Add user: " + name);
	}
}

class UserInvocationHandler implements InvocationHandler {

	private User target;

	public UserInvocationHandler(User target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 下面注释代码会引发循环调用，proxy.toString() -> invoke -> proxy.toString()
		// System.out.println(proxy);
		System.out.println("------- before invoke -------");
		method.invoke(target, args);
		System.out.println("------- after invoke -------");
		return null;
	}

}