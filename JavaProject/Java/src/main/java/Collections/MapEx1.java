package Collections;

import java.util.HashMap;
import java.util.Map;

public class MapEx1 {

	public static void main(String[] args) {
		Map<String, String> dic = new HashMap<>();
		//3개의 (key,value) 쌍을 dic에 저장
		dic.put("baby", "아기"); //"baby"는 key, "아기는" value
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		System.out.println(dic);
		
		System.out.println(dic.get("baby"));
		System.out.println(dic.get("love"));
		System.out.println(dic.get("apple"));
		

	}

}
