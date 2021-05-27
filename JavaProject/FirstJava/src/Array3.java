import java.util.Scanner;

public class Array3 {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		System.out.print("배열의 크기를 입력해 주세요 : ");
		
		int array = sc.nextInt();
		int[] arr = new int[array];
		
		System.out.print("배열을 입력해 주세요 : ");
		for (int i = 0; i < array; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("최대값 : " + maxValue(arr));
		System.out.println("최소값 : " + miniValue(arr));
		


	}

	public static int maxValue(int[] arr) {
		int max = arr[0];
		for(int j = 1; j<arr.length; j++) {
			if(arr[j] < max) {
				max = arr[j];
			}
		}
		return max;
	}

	public static int miniValue(int[] arr) {
		  
		int min = arr[0];
		
		for(int i = 1; i< arr.length; i++) {
			if(arr[i] > min) {
				min = arr[i];
			}			
		}
		return min;
	}
	
	

}
