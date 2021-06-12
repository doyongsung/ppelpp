package ch01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ch02.common.util.ScannerUtil;


public class SmartPhone {
	// HashMap를 이용해서 key값에 문자 , value값에 Contact 클래스 값. 
	private  Map<String, Contact> ContactkMap;
	private  Map<String, CompanyContact> CompanyMap;
	private  Map<String, CustomerContact> CustomerMap;
	
	public SmartPhone() {
		ContactkMap = new HashMap<>();
		CompanyMap = new HashMap<>();
		CustomerMap = new HashMap<>();
	}

	//연락처 등록 메소드
	public void save() {
		System.out.println("등록할 연락처를 입력해주세요");
		addSave();
		System.out.println("등록 완료.");
	}
	//연락처 수정 메소드
	public void correct() {
		System.out.println("수정할 연락처의 이름을 입력해주세요");
		addSave();
		System.out.println("수정 완료.");

	}
	//연락처 삭제 메소드
	public void delete() {
		System.out.println();
		System.out.print("삭제할 정보의 이름을 입력해주세요: ");
		String name = ScannerUtil.getInputString();
		
		//remove(key) -> 삭제 성공하면 삭제된 value값만 반환하고, 실패하면 null반환
		if(CompanyMap.remove(name) == null) {
			System.out.println(name + "님은 등록된 이름이 아닙니다.");
		}else if(CustomerMap.remove(name) == null) {
			System.out.println(name + "님은 등록된 이름이 아닙니다.");
		}else{
			System.out.println(name + "님 정보를 삭제했습니다.");
		}
		System.out.println("삭제 완료");
	}
	//검색 메소드
	public void search() {
		System.out.println();
		System.out.println("검색할 전화번호의 이름을 입력해주세요: ");
		//scanner 값에 검색할 name 을 입력해주면 리스트 불러옴.
		String name = ScannerUtil.getInputString();
		CompanyContact c = CompanyMap.get(name);
		CustomerContact c2 = CustomerMap.get(name);
		
		if(c == null) {
			//이름이 다르거나 없을경우 null값을 불러옴
			System.out.println(name + "님의 정보가 없습니다.");	
			}else {
			System.out.println(name + "님의 연락처 정보");
			System.out.println("이름: " + c.getName());
			System.out.println("전화번호: " + c.getPhone());
			System.out.println("이메일: " + c.getEmail());
			System.out.println("주소: " + c.getAddress());
			System.out.println("생일: " + c.getBirthday());
			System.out.println("그룹: " + c.getGroup());
			System.out.println("회사이름 " + c.getCpNmae());
			System.out.println("부서이름 " + c.getDepartment());
			System.out.println("직급: " + c.getPosition());
			
			
		}
		
		System.out.println("검색 작업 완료");
	}
	//리스트 출력 메소드
	public void print() {
		//키값만 불러올경우 ketSet 사용
				Set<String> keySet = CompanyMap.keySet();
				Set<String> keySet2 = CustomerMap.keySet();
				System.out.println("===================================================================");
				System.out.println("이름 \t전화번호 \t이메일 \t주소 \t생일 \t그룹 \t회사이름 \t 부서이름 \t직급");
				System.out.println("===================================================================");
				
				if(keySet.size() == 0) {
					System.out.println("등록된 전화번호가 없습니다.");
				}else {
					Iterator<String> it = keySet.iterator();
										
					int cnt = 0;
					while(it.hasNext()) {
						cnt++;						
						String name = it.next();
						CompanyContact c = CompanyMap.get(name);
						CustomerContact c1 = CustomerMap.get(name);
						System.out.println(" " + cnt + "\t" + c.getName() + "\t" + c.getPhone() + "\t" 
						                   + c.getEmail() + "\t" + c.getAddress() + "t" + c.getBirthday()
						                   + "\t" + c.getGroup() + "\t" + c.getCpNmae() + "\t" + c.getDepartment()
						                   + "\t" + c.getPosition());	
					
					}
					System.out.println("===================================================================");
					System.out.println();
					System.out.println("출력 완료");
				}
	}
	public void Menu() {
		try {
		while(true) {
			ContactMenu();
		    int menuNum = ScannerUtil.getInputInteger();
		      switch(menuNum) {
		      case 1 : save();
		               break;
		      case 2 : correct();
		               break;
		      case 3 : delete();
		               break;
		      case 4 : search();
		               break;
		      case 5 : print();
		               break;
		      case 0 :
		    	  System.out.println("프로그램을 종료 합니다.");
		    	  return;
		      }
		}
			}catch(NumberFormatException e) {
				System.out.println("잘못된 입력입니다. 숫자를 입력해주세요");
			}
		
	}

	public void ContactMenu() {
	
		System.out.println("============================================================");
		System.out.println("1. 등록    2. 수정    3.삭제    4.검색    5.리스트   0.프로그램 종료");
		System.out.println("============================================================");
		System.out.print("번호를 입력해주세요 >> ");		
		
		}
	public void addSave() {
		System.out.println();
		System.out.print("이 름 >> ");		
		String name = ScannerUtil.getInputString();
		//수정할 정보가 있는지 검사
		//get 메서드로 값을 가져올때 name 이 다르면 null을 반환한다.
		corract1(name);
		System.out.print("전화번호를 입력해주세요: ");
		String phone = ScannerUtil.getInputString();
		System.out.print("이메일을 입력해주세요: ");
		String email = ScannerUtil.getInputString();
		System.out.print("주소를 입력해주세요: ");
		String address = ScannerUtil.getInputString();
		System.out.print("생일을 입력해주세요: ");
		String birthday = ScannerUtil.getInputString();
		System.out.print("그룹을 입력해주세요: ");
		String group = ScannerUtil.getInputString();
		System.out.println("1. Company       2. Customer");
		System.out.print("소속을 선택해주세요: ");
		int check = ScannerUtil.getInputInteger();
		switch(check) {
		case 1:		
		System.out.print("회사이름을 입력해주세요: ");
		String cpName = ScannerUtil.getInputString();
		System.out.print("부서이름을 입력해주세요: ");
		String department = ScannerUtil.getInputString();
		System.out.print("직급을 입력해주세요: ");
		String position = ScannerUtil.getInputString();
		Contact c1 = new CompanyContact(name, phone, email, address, birthday, group, cpName, department, position);
		CompanyMap.put(name, (CompanyContact) c1);
		System.out.println("확인되었습니다.");
		break;
		case 2 :
		System.out.print("거래처회사 이름을 입력해주세요: ");
		String ctName = ScannerUtil.getInputString();
		System.out.print("거래품목을 입력해주세요: ");
		String ctList = ScannerUtil.getInputString();
		System.out.print("직급을 입력해주세요: ");
		String position2 = ScannerUtil.getInputString();
        Contact c2 = new CustomerContact(name, phone, email, address, birthday, group, ctName, ctList, position2);    
		//String 값과 Contact 값 출력
        CustomerMap.put(name, (CustomerContact) c2);
		break;
		}	
		
		
		
	}
	public void corract1(String name){
		if(ContactkMap.get(name) != null) {
			System.out.println(name + "등록 /수정 가능합니다.");
			return;
		}
	}


}


