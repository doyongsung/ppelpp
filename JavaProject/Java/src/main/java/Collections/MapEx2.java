package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapEx2 {

	public static void main(String[] args) {
		//이름과 점수를 저장할 HashMap 컬렉션 생성
		Map<String,Integer> scoreMap = new HashMap<>();
		
		//5개의 점수 저장
		scoreMap.put("김성동", 97);
		scoreMap.put("황기태", 88);
		scoreMap.put("김남윤", 98);
		scoreMap.put("이재문", 70);
		scoreMap.put("한원선", 99);
		System.out.println(scoreMap);
		System.out.println("HashMap의 요소 개수 : " + scoreMap.size());
		
		System.out.println(scoreMap.get("이재문"));
		//모든 엔트리 출력(방법1)
		Set<String> keySet = scoreMap.keySet(); // 키 컬력션은 set //keyset은 김성동,황기태,김남윤,이재문,한원선
		for(String key : keySet) {
			int value = scoreMap.get(key);
			System.out.format("%s : %d\n", key,value);
		}
		
		//모든 엔트리 출력(방법2). map은 entry의 set
		Set<Map.Entry<String, Integer>>entrySet = scoreMap.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet) {
			System.out.format("%s : %d\n", entry.getKey(),entry.getValue());
		}
		
	}

}
