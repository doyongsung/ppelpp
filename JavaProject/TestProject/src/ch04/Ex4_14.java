package ch04;

import java.util.Scanner;

public class Ex4_14 {

	public static void main(String[] args) {
//		int num = 0, sum = 0;
//		System.out.print("숫자르 입력하세요.(예:12345)>");
//		
//		Scanner sc = new Scanner(System.in);
//		String tmp = sc.nextLine();
//		num= Integer.parseInt(tmp);
//		
//		while(num!=0) {
//			// num을 10으로 나눈 나머지를 sum에 더함
//			sum += num%10;   // sum = sum + num%10;
//			System.out.printf("sum=%3d num =%d%n",sum,num);
//			
//			num /= 10; // num = num / 10;
//		}
//		System.out.println("각 자리수의 합:" +sum);

		
		int num = 12345, sum =0;
		
		// 10으로 나머지 연산을 하면 마지막 자리를 얻는다//.
	//	System.out.println(12345%10);
		
//		for(num=12345; num >0; num= num /10) {  //12345  1234 123 12 1
//			System.out.println(num%10); // 1234 5 
//			sum += num%10;
//		}
//		System.out.println("각 자리수의 합:" +sum);
//	}
		
		while(num>0) {  //12345  1234 123 12 1
			sum += num%10;
			System.out.println("sum="+sum +",num%10=" + num%10); // 
			num = num/ 10;
		}
		System.out.println("각 자리수의 합:" +sum);
	}

}
