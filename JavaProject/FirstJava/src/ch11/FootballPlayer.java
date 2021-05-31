package ch11;

import java.util.ArrayList;
import java.util.List;

public class FootballPlayer {
	String name;
	 int number;
	 String team;
	 int age;
	 
	 public FootballPlayer(String name,int number, String team, int age) {
		 this.name = name;
		 this.number = number;
		 this.team = team;
		 this.age = age;
	 }

	public void showData() {
		System.out.println("이름 : " + name);
		System.out.println("번호 : " + number);
		System.out.println("팀 이름 : " + team);
		System.out.println("나이 " + age);
	}
	public static void main(String[] args) {
		List<FootballPlayer> list = new ArrayList<>();
		
		
	}
}
