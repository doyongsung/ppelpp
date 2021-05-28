package ch07;

public class PersonManager {

	public static void main(String[] args) {
	       Person person = new Person("세종대왕", 2002);	   
	        Male male = new Male("홍길동", 1994, "부천");      
	        Female female = new Female("이성계", 1985,"ppelpp@naver.com");
	        
	        person.PersonInfo();	        
	        male.PersonInfo(); 	   
	        female.PersonInfo();
	}

}
