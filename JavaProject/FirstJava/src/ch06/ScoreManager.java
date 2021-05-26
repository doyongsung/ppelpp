package ch06;

public class ScoreManager {

	public static void main(String[] args) {
//		1. 국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고 점수를 모두 출력하고, 평균 점수를 출력하는 프로그램을 작성해봅시다. 
//		 
		// 국어 점수를 저장하는 배열
		int[] korScore = new int[10];
		// 영어 점수를 저장하는 배열
		int[] engScore = new int[10];
		// 수학 점수를 저장하는 배열
		int[] mathScore = new int[10];
		
		// 점수를 입력
		korScore[0] = 100;
		korScore[1] = 16;
		korScore[2] = 45;
		korScore[3] = 95;
		korScore[4] = 75;
		korScore[5] = 12;
		korScore[6] = 35;
		korScore[7] = 84;
		korScore[8] = 76;
		korScore[9] = 23;
		
		// 점수를 모두 출력 하고,
		// 배열의 모든 요소를 출력
		// 배열 -> 일괄처리
//		System.out.println(korScore[0]);
//		System.out.println(korScore[1]);
//		System.out.println(korScore[2]);
		// 반목문을 이용해서 공통된 작업을 처리 - > 일괄처리
		for(int idx = 0; idx < korScore.length; idx++) {
			System.out.println(korScore[idx]); 
		}
		
		//평균 점수를 출력하는 프로그램을 작성해봅시다.
		//합을 구하고 -> 평균
		// sum = sum + i -> sum += i
		int sum = 0;
		for(int i = 0; i<korScore.length; i++) {
			sum = sum + korScore[i];
		}
		System.out.println("국어점수의 합 : " + sum);
		
		//평균 -> 총합/배열의 개수
		float avg = (float)sum / korScore.length;
		System.out.println("국어 점수의 평균 : " + avg);
		
		

	}

}
