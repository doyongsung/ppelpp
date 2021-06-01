package ch07;

public class PersonMain {

	public static void main(String[] args) {
		
		Person person1 = new Male("손흥민", "123456-1234567");
		Person person2 = new Female("박나래", "000000-2222222");
		
		person1.sayHello();
		
		System.out.println("====================================================");
		
		person2.sayHello();

	}

}