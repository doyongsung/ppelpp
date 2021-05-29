package ch01;

public class CompanyContact extends Contact{
	String cpName;
	String cpInfo;
	String cpPosition;
	public CompanyContact(String name, String phone, String email, 
			              String address, int events, String groups,
			              String cpName, String cpInfo, String cpPosition){
		
		super(name, phone, email, address, events, groups);
		this.cpName = cpName;
		this.cpInfo = cpInfo;
		this.cpPosition = cpPosition;
	}
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("cpName :" + cpName);
		System.out.println("cpInfo :" + cpInfo);
		System.out.println("cpPosition :" + cpPosition);
	}

}
