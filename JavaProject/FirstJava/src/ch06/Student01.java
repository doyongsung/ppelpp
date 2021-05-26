package ch06;

public class Student01 {

//	2. Student 클래스를 정의해봅시다. 
//	① 학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다.
	private String name;
	private int kor;
	private int eng;
	private int math;
	
    public Student01(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public Student01() {}
	
//	② 변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	
//	③ 총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.
	int getSum() {
		return this.kor + this.eng + this.math;
	}
	float getAvg() {
		return getSum() / 3f;
	}

	public static void main(String[] args) {
		
		

	}

}
