package dept;

import java.util.Scanner;

public class DeptMain {

	public static void main(String[] args) {
		
		
		DeptManager manager = new DeptManager(DeptDao.getInstance());
		
		Scanner sc = new Scanner(System.in);
				
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			while(true) {
				System.out.println("부서관리 프로그램");
				System.out.println("-----------------------------------");
				System.out.println("1. 부서 리스트");
				System.out.println("2. 부서 정보 입력");
				System.out.println("3. 부서 정보 수정");
				System.out.println("4. 부서 정보 삭제");
				System.out.println("5. 프로그램 종료");
				System.out.println("-----------------------------------");
				System.out.println("원하시는 기능의 번호를 입력해주세요.");
				int num = Integer.parseInt(sc.nextLine());
				
				switch(num) {
				case 1 :
					manager.deptList();
					break;
				case 2 :
					manager.inputData();
					break;
				case 3 :
					manager.editDept();
					break;
				case 4 :
					manager.delDept();
					break;
				case 5 :
					System.out.println("프로그램을 종료합니다.");
					return;
					
				}
			}
						
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}

}
