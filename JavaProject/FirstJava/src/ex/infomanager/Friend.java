package ex.infomanager;

//상속을 목적으로 하는 클래스
public class Friend {

	// 이름,전화번호,주소
	 String name;
	 String phoneNumber;
	 String address;
	
	public Friend(String name, String phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public void showData() {
		System.out.println("이   름 : " + name);
		System.out.println("전화번호 :" + phoneNumber);
		System.out.println("주   소 : " + address);
	}
	
	public void showBasicInfo() {}


}
