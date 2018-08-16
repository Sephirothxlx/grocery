package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("reflect.Person");
			System.out.println(c.getName());
			System.out.println(Arrays.toString(c.getMethods()));
			System.out.println(Arrays.toString(c.getFields()));
			System.out.println(Arrays.toString(c.getDeclaredFields()));
			Method m= c.getMethod("getName");
			Object o = c.newInstance();
			String s=(String)m.invoke(o);
			System.out.println(s);
			Constructor<?> con=c.getConstructor(String.class);
			Object o2= con.newInstance("sephirothxlx");
			s=(String) m.invoke(o2,null);
			System.out.println(s);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
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
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
