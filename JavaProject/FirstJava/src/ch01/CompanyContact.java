package ch01;

public class CompanyContact extends Contact{

	String cpNmae;
	String department;
	String position;
	
	public CompanyContact(String name, String phone, String email, String address, int birthday, String group,
			String cpName, String department, String position) {
		super(name,phone,email,address,birthday,group);
		this.cpNmae = cpName;
		this.department = department;
		this.position = position;
	}

	public String getCpNmae() {
		return cpNmae;
	}

	public void setCpNmae(String cpNmae) {
		this.cpNmae = cpNmae;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public void showInfo() {
		System.out.println("이름 \t전화번호 \t이메일 \t주소 \t생일 \t그룹 \t회사이름 \t부서 \t직급");
		System.out.println(super.getName() + "\t" + super.getPhone() + "\t" + super.getEmail() + "\t" + super.getAddress() 
				           + "\t" + super.getBirthday() + "\t" + super.getGroup() + "\t" + this.getCpNmae() + "\t" 
				           + this.getDepartment() + "\t" + this.getPosition());
	}
}