package patterns.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler<T> implements InvocationHandler{
	T t;
	
	public MyInvocationHandler(T t) {
		this.t=t;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object b=method.invoke(t, args);
		return b;
	}

}
