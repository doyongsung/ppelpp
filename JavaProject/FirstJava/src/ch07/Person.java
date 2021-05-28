package ch07;

import java.util.Calendar;

public class Person {
   String name;
   int age;
    
   Person(String name, int age){
	   this.name = name;
	   this.age = age;
   }
   void PersonInfo() {
	   System.out.println("안녕하세요. 저는 " + name + "입니다 " + ageCal(age) + " 살입니다.");
   }
	int ageCal(int age) {
		
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		return currentYear - age -1;
		
	}

 


}