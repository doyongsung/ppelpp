package ch12;

public class FootballPlayerMain {

	public static void main(String[] args) {
		FootballPlayerSave save = new FootballPlayerSave();
		
		while(true) {
			System.out.println("\n");
			System.out.println("JAVA Memo =================================");
			System.out.println(" [1] 선수 리스트 보기  [2] 선수등록   [3] 파일저장   [4] 종료");
			System.out.println("===========================================");
			System.out.println("원하시는 기능의 번호를 입력하세요.");
			
			int select = Integer.parseInt(save.scanner.nextLine());
			
			switch(select) {
			case 1 :
				save.displayPlayers();
				break;
			case 2 :
				save.addPlayer();
				break;
			case 3 :
				save.saveFile();
				break;
			case 4 :
				System.out.println("프로그램을 종료합니다.");
				return;
				
			}
		}

	}

}
