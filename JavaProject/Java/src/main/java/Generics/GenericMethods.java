package Generics;

import javax.rmi.CORBA.Util;

public class GenericMethods {

	public static void main(String[] args) {
		Pair<Integer,String> p1 = new Pair<>(1,"apple");
		Pair<Integer,String> p2 = new Pair<>(2, "pear");
		
//		Util util = new Util();
//		boolean result1 = util.compare(p1,p2);
//		System.out.println(result1);
//		
//		Box<Double> b1 = new Box<>();
//		b1.set(5,5);
//		Box<Double> b2 = new Box<>();
//		b2.set(5,5);
//		boolean result2 = util.compare(b1,b2);
//		System.out.println(result2);

	}

}
