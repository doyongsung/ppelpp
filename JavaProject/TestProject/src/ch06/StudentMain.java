package ch06;

public class StudentMain {

	public static void main(String[] args) {
		Student[] student = new Student[10];
		student[0] = new Student("가",10,54,90);
		student[1] = new Student("나",20,90,80);
		student[2] = new Student("다",30,80,70);
		student[3] = new Student("라",40,70,60);
		student[4] = new Student("마",50,60,50);
		student[5] = new Student("바",60,50,60);
		student[6] = new Student("사",70,40,70);
		student[7] = new Student("아",80,30,80);
		student[8] = new Student("자",90,20,90);
		student[9] = new Student("차",55,10,74);
		
		System.out.println("이름 \t국어 \t영어 \t수학 \t총합 \t평균");
		System.out.println("==============================================");
		
		for(int i =0; i < student.length; i++) {
			
			System.out.print(student[i].getName());
			System.out.printf("\t");
			System.out.print(student[i].getKoreaScore());
			System.out.printf("\t");
			System.out.print(student[i].getScore());
			System.out.printf("\t");
			System.out.print(student[i].getMathScore());
			System.out.printf("\t");
			System.out.print(student[i].totalScore());
			System.out.printf("\t");
			System.out.print(student[i].averager());
			System.out.printf("\t");
			System.out.println();
		}
		System.out.println("==============================================");
	
		
		
	
	}

}
