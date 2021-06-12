package ch01;

public class CustomerContact extends Contact {

	String ctName;
	String ctList;
	String position2;
	CustomerContact(String name, String phone, String email, String address, String birthday, String group,
			        String ctName, String ctList, String position) {
		super(name, phone, email, address, birthday, group);
		this.ctName = ctName;
		this.ctList = ctList;
		this.position2 = position;
	}
	public String getCtName() {
		return ctName;
	}
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}
	public String getCtList() {
		return ctList;
	}
	public void setCtList(String ctList) {
		this.ctList = ctList;
	}
	public String getPosition() {
		return position2;
	}
	public void setPosition(String position) {
		this.position2 = position;
	}
	public void showInfo() {
		System.out.println("이름 \t전화번호 \t이메일 \t주소 \t생일 \t그룹 \t거래처이름 \t품목 \t직급");
		System.out.println(super.getName() + "\t" + super.getPhone() + "\t" + super.getEmail() + "\t" + super.getAddress() 
				           + "\t" + super.getBirthday() + "\t" + super.getGroup() + "\t" + this.ctName + "\t"
				           + this.ctList + "\t" + this.position2);
	}
}
