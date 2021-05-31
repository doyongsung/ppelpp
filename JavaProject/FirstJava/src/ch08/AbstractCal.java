package ch08;

abstract class AbstractCal implements Calualtor{
	public long multiply(long n1, long n2) {
		return n1 * n2;
	}
	public double divide(double n1, double n2) {
		return n1 / n2;
	}
}
