package classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[]args) {
		System.out.println(Test.class.getClassLoader().toString());
		//System.out.println(String.class.getClassLoader().toString());
		
		XClassLoader xc=new XClassLoader("C:\\Users\\dell\\Desktop\\");
		try {
			//the class name should contain package name
			Class<?> c= xc.findClass("classloader.Person");
			Object o = c.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
