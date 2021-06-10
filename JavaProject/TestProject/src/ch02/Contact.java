package ch02;

import ch01.ShowData;

public class Contact implements ShowData{
 
	private String name;
	private String phone;
	private String email;
	private String address;
	private int birthday;
	private String group;
	
	Contact(String name, String phone, String email, String address, int birthday, String group){
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void showInfo() {
		System.out.println("이름 \t전화번호 \t이메일 \t주소 \t생일 \t그룹");
		System.out.println(name + "\t" + phone + "\t" + email + "\t" + address 
				           + "\t" + birthday + "t" + group);
	}
}
