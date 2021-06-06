package Collections;

import java.util.ArrayList;
import java.util.List;

public class PersonSearchEx {

	//사람 목록을 검색해서 조건에 맞는 사람을 출력하는 메서드
	
	public void printPersons(List<Person>roster,CheckPerson tester) {
		for(Person p : roster) {
			if(tester.test(p)) {
				p.printPerson();
			}
		}
	}
	
	public void go() {
		List<Person> roster = new ArrayList<>();
		//roster에 사람들을 넣는다
		
		//18세 이상 20세 미만인 사람을 출력	
		//방법1 : functional interface를 구현한 로컬 클래스를 만든다.
		class TeanAger implements CheckPerson{

			@Override
			public boolean test(Person p) {
			return 13 <= p.getAge() && p.getAge() < 20;
			}
			
		}
		printPersons(roster, new TeanAger());
	}
	
	//방법2 .anonymous class 로 만든다.
	CheckPerson teenAger = new CheckPerson() {
		
		@Override
		public boolean test(Person p) {
		 return 13 <= p.getAge() && p.getAge() < 20;
		}
	};
	
}
