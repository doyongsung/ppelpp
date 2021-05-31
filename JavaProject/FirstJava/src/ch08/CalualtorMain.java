package ch08;

public class CalualtorMain {

	public static void main(String[] args) {
		
		Calualtor calualtor = new InstanceCal();	     
		AbstractCal abstractCal = new InstanceCal();
		
		System.out.println(calualtor.add(5, 5));
		System.out.println(abstractCal.multiply(5, 5));
		
		
		
		

	}

}
