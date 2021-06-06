package Collections;

import java.util.ArrayList;
import java.util.List;

public class ListEx1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(); //정수리스트
		list.add(5); //5삽입
		list.add(4); //4 삽입
		list.add(-1); // -1삽입 
		System.out.println(list);
		
		//리스트 중간에 삽입하기
		list.add(2,100); //index 2에 100 삽입
		System.out.println(list);
		System.out.println("리스트의 엘리먼트 갯수 : " + list.size());
		
		//특정 위치의 element 찾기
		int n = list.get(3); // index 3의 element
		System.out.println(n); // -1
		
		
		//모든 엘리먼트 출력
		for(int m : list) { //저장할 타입과 리스트 넣기
			System.out.format("%d ", m);
		}
		System.out.println();

	}

}
