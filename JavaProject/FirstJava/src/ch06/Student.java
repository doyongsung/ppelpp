package ch06;

import java.util.Scanner;

public class Student {
	
	private String name;
	private int koreaScore;
	private int englishScore;
	private int mathScore;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKoreaScore() {
		return koreaScore;
	}
	public void setKoreaScore(int koreaScore) {
		this.koreaScore = koreaScore;
	}
	public int getEnglishScore() {
		return englishScore;
	}
	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
int getAllScore() {
	return this.koreaScore + this.englishScore + this.mathScore;
	 
}
float getAverage() {
	return this.getAllScore() / 3f;
}

	

	public static void main(String[] args) {
		
	
		 System.out.print("학생수를 입력하세요 : ");
		 int num = getInputInteger();
         Student[] stu = new Student[num];
         
         for(int i = 0; i < num; i++) {
        	 System.out.print("이름을 입력하세요 : ");
        	 String name = getInputString();
        	 System.out.print("국어점수를 입력하세요. : ");
        	 int koreaScore = getInputInteger();
        	 System.out.print("영어점수를 입력하세요. : ");
        	 int englishScore = getInputInteger();
        	 System.out.print("수학점수를 입력하세요. : ");
        	 int mathScore = getInputInteger();
        	 
        	 stu[i] = new Student();
        	 stu[i].setName(name);
        	 stu[i].setKoreaScore(koreaScore);
        	 stu[i].setEnglishScore(englishScore);
        	 stu[i].setMathScore(mathScore);
        	 System.out.println();
        	 
        	 
         }
         
         for(Student s : stu) {
        	 System.out.println("국어점수는 : " + s.koreaScore + "\n영어점수는 : " + s.englishScore + "\n수학점수는 : " + s.mathScore + "\n총 점수는 : " + s.getAllScore());
        	 System.out.println("평균 점수는 : " + s.getAverage());
        	 System.out.println();
         }
		
	}

    private static String getInputString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    private static int getInputInteger() {
    	 Scanner sc = new Scanner(System.in);
    	 String input = sc.nextLine();
    	 return Integer.parseInt(input);
    }

}
