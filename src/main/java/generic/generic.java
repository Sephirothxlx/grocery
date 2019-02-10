package thirdclass;

import java.util.ArrayList;
import java.util.List;
public class Generic {
	//why is this failed?
		public void test1(){
			List arrayList = new ArrayList();
			arrayList.add("aaaa");
			arrayList.add(100);

			for(int i = 0; i< arrayList.size();i++){
			    String item = (String)arrayList.get(i);
			}
		}
		
		public void test2(){
			List<String> stringArrayList = new ArrayList<String>();
			List<Integer> integerArrayList = new ArrayList<Integer>();

			Class classStringArrayList = stringArrayList.getClass();
			Class classIntegerArrayList = integerArrayList.getClass();

			if(classStringArrayList.equals(classIntegerArrayList)){
				System.out.println("equal");
			}
		}
		
		//1. generic class
		//T must be class type not primitive data type
		class G<T>{ 
			//T is decided in class declaration
		    private T key;
		    
		    //private E a;
		    
		    public G(){};
		    
		    public G(T key) { 
		        this.key = key;
		    }

		    //T is decided in class declaration
		    public T getKey(){ 
		        return key;
		    }
		    
		    // can not write static funtion in inner class
		}
		
		//static function can not use class generic but only become the generic function
		//note that the sequence of key words
		public static <T> void print(){
			
		}
		
//		public <T> static void print2(){
//			
//		}
		
		//you can choose not to pass generic parameter
		public void test3(){
			G generic = new G("111111");
			G generic1 = new G(4444);
		}
		
		public void test4(){
			G<Integer> f=new G<Integer>();
			G<Number> ff=new G<Number>();
			//ff!=f, no inheritance here!
		}
		
		//2. generic interface
		public interface Generator<T> {
		    public T next();
		}
		
		//you must write F<T> if T is not specific
		class F<T> implements Generator<T>{
		    @Override
		    public T next() {
		        return null;
		    }
		}
		
		//or like this
		class H implements Generator<String>{
		    @Override
		    public String next() {
		        return null;
		    }
		}
		
		//3. generic function
		public <T> T test5(T a){
			//you can decalre
			T s;
			//you can not create
			//T g=new T();
			return a;
		}
		
		public <T> int test6(T a){
			return 0;
		}
		
		public <T> int test7(){
			return 0;
		}
		
		public <T> void test8(){
			
		}
		
		//no!
//		public void test9(T a){
//			
//		}
		
		//generic function in generic class
		class D<T>{
			public <E> void print(T t){
				
			}
			
			//hide!
			public <T> void print2(T t){
				System.out.println(t);
			}
		}
		
		//variable parameters
		public <T> void printMsg( T... args){
		    for(T t : args){
		    	System.out.println(t);
		    }
		}
		
//		public void test10(){
//			List<String>[] lsa = new List<String>[10]; // Not really allowed.    
//			Object o = lsa;    
//			Object[] oa = (Object[]) o;    
//			List<Integer> li = new ArrayList<Integer>();    
//			li.add(new Integer(3));    
//			oa[1] = li; // Unsound, but passes run time store check    
//			String s = lsa[1].get(0); // Run-time error: ClassCastException.
//		}
		
		public void test11(){
			List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.    
			Object o = lsa;    
			Object[] oa = (Object[]) o;    
			List<Integer> li = new ArrayList<Integer>();    
			li.add(new Integer(3));    
			oa[1] = li; // Correct.    
			Integer i = (Integer) lsa[1].get(0); // OK 
		}
		
		public <T extends Number>void test12(T t){
			
		}
		
		public void test13(G<?> g){
			
		}
		
		public void test14(G<Integer> g){
			
		}
		
		public void test15(G<String> g){
			
		}
		
		//? extends Fruit upper bound wildcard
//		Plate<? extends Fruit> p=new Plate<Apple>(new Apple());
//		
//		//cannot put things
//		p.set(new Fruit());    //Error
//		p.set(new Apple());    //Error
//
//		//store the things that is read from container with Fruit or its base class
//		Fruit newFruit1=p.get();
//		Object newFruit2=p.get();
//		Apple newFruit3=p.get();    //Error
		
		//? super Fruit lower bound wildcard
//		Plate<? super Fruit> p=new Plate<Fruit>(new Fruit());
//
//		//can put things
//		p.set(new Fruit());
//		p.set(new Apple());
//
//		//store the things that is read from container with Object
//		Apple newFruit3=p.get();    //Error
//		Fruit newFruit1=p.get();    //Error
//		Object newFruit2=p.get();
		
		public static void main(String[]args){
			Generic g=new Generic();
			D<String> d=g.new D<String>();
			d.print2("2");
			d.print2(1);
			g.printMsg("1",1,2,"g",d);
		}
}
