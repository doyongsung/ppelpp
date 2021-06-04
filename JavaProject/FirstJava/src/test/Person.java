package test;

public class Person {
String name;
String number;

public Person(String name, String number) {
	this.name = name;
	this.number = number;
}

public void sayHello() {
	System.out.println("안녕하세요. 저는 " + name + " 입니다." + number + "입니다.");
}
}
