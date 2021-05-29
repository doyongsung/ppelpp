package ch01;
//interface ShowData{
//	public abstract void showData();
//}
//public abstract class Contact implements ShowData{
	public class Contact{
	private String name;
	private	String phone;
	private	String email;
	private	String address;
	private	int events;
	private	String groups;
	
	
	Contact(String name, String phone, String email, String address, int events, String groups){
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.events = events;
		this.groups = groups;
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

	public int getEvents() {
		return events;
	}

	public void setEvents(int events) {
		this.events = events;
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}


public void showInfo() {
	System.out.println("Name : " + name);
	System.out.println("Phone : " + phone);
	System.out.println("Email : " + email);
	System.out.println("Address : " + address);
	System.out.println("Events : " + events);
	System.out.println("Groups : " + groups);
	
}
	

}
