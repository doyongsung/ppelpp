package ch09;

public class Person {

	private String name;
	private String personNumber;

	public Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}

	@Override
	public boolean equals(Object o) {

		boolean result = false;

		if (o != null && o instanceof Person) {
			Person p = (Person) o;
			result = this.personNumber.equals(p.getPersonNumber());
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", personNumber=" + personNumber + "]";
	}
	
	public static void main(String[] args) {
		
		Person p1 = new Person("KING", "2000-01-01");
		Person p2 = new Person("SCOTT", "2000-01-01");
		
		if(p1.equals(p2)) {
			System.out.println("p1 과 p2는 같은 사람입니다.");
		} else {
			System.out.println("p1 과 p2는 다른 사람입니다.");
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}