package ch06;

public class Student02 {

	public static void main(String[] args) {
//		3. main()메소드에 아래 내용을 정의해봅시다. 
//		① Student 타입의 배열을 선언하고, 
//		요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
		Student01[] students = new Student01[10];
//		② Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
		students[0] = new Student01("홍길동1", 100, 40, 20);
		students[1] = new Student01("홍길동2", 80, 30, 30);
		students[2] = new Student01("홍길동3", 70, 20, 50);
		students[3] = new Student01("홍길동4", 60, 10, 70);
		students[4] = new Student01("홍길동4", 50, 50, 50);
		students[5] = new Student01("홍길동5", 40, 80, 90);
		students[6] = new Student01("홍길동6", 30, 90, 60);
		students[7] = new Student01("홍길동7", 20, 60, 50);
		students[8] = new Student01("홍길동8", 10, 40, 80);
		students[9] = new Student01("홍길동9", 600, 50, 40);
//		③ 배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다
		System.out.println("이름 \t국어 \t영어 \t수학 \t총점 \t평균");
		System.out.println("===============================================");
		for(int i = 0; i < students.length; i++) {
			System.out.print(students[i].getName());
			System.out.printf("\t");
			System.out.print(students[i].getKor());
			System.out.printf("\t");
			System.out.print(students[i].getEng());
			System.out.printf("\t");
			System.out.print(students[i].getMath());
			System.out.printf("\t");
			System.out.print(students[i].getSum());
			System.out.printf("\t");
			System.out.println(students[i].getAvg());
			
		}
	}

}
