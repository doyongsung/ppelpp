package Collections;

import java.util.HashSet;
import java.util.Set;

public class SetEx2 {

	public static void main(String[] args) {
		Set<Point>points = new HashSet<>();
		Point p1 = new Point(3,4);
		Point p2 = new Point(1,2);
		Point p3 = new Point(1,2);
		points.add(p1);
		points.add(p2);
		System.out.println(points.contains(p3));
		points.add(p3);
		System.out.println(points);
		
		
		System.out.println(p2.equals(p3)); //set을 쓸떄는 equals 랑 해쉬코드를 무조건 써야함  //map 키 를쑬떄도
		System.out.format("p2.hasCode() = %d, p3.hashCode()=%d\n", p2.hashCode(),p3.hashCode());
		

	}

}
