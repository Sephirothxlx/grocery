package patterns.proxy.dynamicproxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[]args) {
		InvocationHandler id=new MyInvocationHandler<Student>(new Student());
		Class<?> s=Proxy.getProxyClass(Person.class.getClassLoader(), new Class<?>[] {Person.class});
		try {
			Constructor c=s.getConstructor(InvocationHandler.class);
			try {
				Person p=(Person) c.newInstance(id);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person p=(Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[] {Person.class}, id);
		System.out.println(Person.class.getClassLoader().toString());
		System.out.println(MyInvocationHandler.class.getClassLoader().toString());
		p.getName();
	}
}
