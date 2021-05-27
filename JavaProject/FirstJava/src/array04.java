import java.util.Scanner;

public class array04 {
	 public static void addOneDArr(int[][] arr, int add){
	        for (int i = 0; i < arr.length; i++) {
	            for (int j = 0; j < arr[i].length; j++) {
	                arr[i][j] += add;
	            }
	        }
	    }
	private static int[][] setArray() {
		System.out.print("배열의 행을 입력 해주세요 : ");
		int arrayOne = getInputInt();
		System.out.print("배열의 열을 입력 해주세요 : ");
		int arrayTwo = getInputInt();
		int[][] score = new int[arrayOne][arrayTwo];
		return score;
		
	}
	
	private static void setArrayScore(int[][] score) {
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++) {
				System.out.println((i+1) + "번째의" + (j +1) + "변 수를 입력하여 주세요 :");
				score[i][j] = getInputInt();
			}
		}
	}
	private static void showInputScore(int[][] score) {
		System.out.println("현재 상황 : ");
		for(int[] s : score) {
			for(int i : s) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	
	public static void main(String[] args) {
		
		int[][] score = setArray();
		setArrayScore(score);
		showInputScore(score);
		int add = getInputInt();
		addOneDArr(score,add);
		showInputScore(score);
		
		
		
	}
	
	
	 public static int getInputInt() {
		 Scanner sc = new Scanner(System.in);
		 String input = sc.nextLine();
		 return Integer.parseInt(input);
	 }
}

