package ch09;

public class Person {
	String name;
	String personNumber;

	public Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}
	
	public  boolean equals(Object obj) {
		boolean bool = false;
		Person person = (Person) obj;
		if(personNumber.equals(person.personNumber)) {
			bool = true;
		}
		return bool;
		
	
		
	}
	public static void main(String[] args) {
		Person person = new Person("홍명보","940403");
		Person person1 = new Person("홍명보","960303");
		Person person2 = new Person("홍명보","940403");
		
		System.out.println(person.equals(person1));
		System.out.println(person.equals(person2));
	}
	
}

