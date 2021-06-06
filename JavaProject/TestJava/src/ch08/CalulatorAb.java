package ch08;

abstract class CalulatorAb implements Calulator{
	@Override
	public long add(long n1, long n2) {
	
		return n1 + n2;
	}

	@Override
	public long substract(long n1, long n2) {
		// TODO Auto-generated method stub
		return n1 - n2;
	}
}
