package ch08;

public class InstanceCal extends AbstractCal implements Calualtor{
	@Override
	public long add(long n1, long n2) {
		return n1 + n2;
	}
	@Override
	public long substract(long n1, long n2) {
		return n1 - n2;
	}



}
