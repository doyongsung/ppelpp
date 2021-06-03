package ch06;

public class Student {
private	String name;
private	int koreaScore;
private	int score;
private	int mathScore;

Student(String name, int koreaScore, int score, int mathScore){
	this.name = name;
	this.koreaScore = koreaScore;
	this.score = score;
	this.mathScore = mathScore;

}

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

public int getScore() {
	return score;
}

public void setScore(int score) {
	this.score = score;
}

public int getMathScore() {
	return mathScore;
}

public void setMathScore(int mathScore) {
	this.mathScore = mathScore;
}


int totalScore() {   	
   	return this.koreaScore + this.score + this.mathScore;
}
double averager() {
	return this.totalScore() / 3;
}
}