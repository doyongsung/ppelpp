package ch08;

public class CalulatorMain {

	public static void main(String[] args) {
	   Calulator Cal = new CalulatorInheri();
	   CalulatorAb CalA = new CalulatorInheri();
	   
	   System.out.println(Cal.add(5, 5));
	   System.out.println(CalA.divide(5, 5));

	}

}
