package patterns.proxy.staticproxy;

public class StudentProxy implements Person{

	private Student s;
	
	public StudentProxy(Student s) {
		this.s=s;
	}
	
	public void getName() {
		// TODO Auto-generated method stub
		System.out.println("I am a students.");
	}

}
