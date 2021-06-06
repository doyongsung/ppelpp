package Collections;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ListEx2 {

	public static void main(String[] args) {
		List<Point> list = new ArrayList<>();
		
		// 3개의 point 객체 삽입
		list.add(new Point(2,3));
		list.add(new Point(-5,20));
		list.add(new Point(30,-8));
		System.out.println(list);
		//[point [x=2,y=3], point[x=-5,y=20], point[x=30,y=8]]
		
		list.remove((1));//인덱스 1의 point(-5,20)의 객체 삭제
		System.out.println(list); //[point [x=2 ,y=3], point[x =30, y=8]]
		
		//특정 위치의 element 찾기
		Point p1 = list.get(1); // index 1의 element
		System.out.println(p1); // Point [x=30, y=-8]
		
		//모든 엘리먼트 출력
		for(Point p : list) {
			System.out.println(p);
		}
		

	}

}
