package ch12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FootballPlayerSave {

	List<FootballPlayer> players;
	File file;
	Scanner scanner;
	
	public FootballPlayerSave() {
		
		scanner = new Scanner(System.in);
		//파일 찾기
		file = new File("players.ser");
		//파일 없으면 생성
		if(file.exists()) {
			loadFile();
		}else {
			players = new ArrayList<FootballPlayer>();
		}
	}

	
	public void displayPlayers() {
		if(players.isEmpty()) { //객체가 비어있는지 확인
			System.out.println("저장된 선수 데이터가 없습니다.");
		}else {//비어있지않으면 반복
			for(FootballPlayer footballPlayer : players) {
				System.out.println(footballPlayer);
			}
		}
	}
	public void addPlayer() {
		
		System.out.println("이름을 입력해주세요.");
		String name = scanner.nextLine();
		System.out.println("등번호를 입력해주세요.");
		String number = scanner.nextLine();
		System.out.println("팀이름을 입력해주세요.");
		String team = scanner.nextLine();
		System.out.println("나이를 입력해주세요");
		String age = scanner.nextLine();
		
		players.add(new FootballPlayer(name, Integer.parseInt(number), team, Integer.parseInt(age)));
	}
	
	public void saveFile() {
		//파일 읽어오기
		ObjectOutputStream outputStream =null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			outputStream = new ObjectOutputStream(fos);
			outputStream.writeObject(players);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
  
	@SuppressWarnings("unchecked")
	public void loadFile() {
		
		if(file.exists()) {
			ObjectInputStream inputStream = null;
			FileInputStream fis;
			try {
				System.out.println("파일로부터 데이터를 읽어 옵니다.");
				
				fis = new FileInputStream(file);
				inputStream = new ObjectInputStream(fis);
				players = (List<FootballPlayer>) inputStream.readObject();
				
				displayPlayers();
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
			    e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}
}
