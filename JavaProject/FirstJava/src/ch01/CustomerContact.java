package ch01;

public class CustomerContact extends Contact{
	String ctName;
	int ctList;
	String ctPosition;
	
	public CustomerContact(String name, String phone, String email, 
            String address, int events, String groups,
            String ctName, int ctList, String ctPosition){
	
    super(name, phone, email, address, events, groups);
    this.ctName = ctName;
    this.ctList = ctList;
    this.ctPosition = ctPosition;
	}
    @Override
    public void showInfo() {
    	super.showInfo();
    	System.out.println("ctName " + ctName);
    	System.out.println("ctList " + ctList);
    	System.out.println("ctPosition " + ctPosition);
    }
	
}
