import java.util.Scanner;

public class array5 {
	
	private static int[][] setArray(){
		System.out.print("배열의 행을 입력 해주세요 : ");
		int arrayOne = getInputInt();
		System.out.print("배열의 열을 입력 해주세요 : ");
	    int arrayTwo = getInputInt();
	    int[][]score = new int[arrayOne][arrayTwo];
	    return score;		
	}
	
	private static void arrayInput(int[][] score) {
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j< score[i].length; j++){
				System.out.println((i +1) + " 번째의" + (j +1) +" 변수를 입력해주세요.");
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
	private static void changed(int[][] arr) {
	   int[] temp;
	   for(int i = arr.length-1; i > 0; i--) {
		   temp = arr[i];
		   arr[i] = arr[i-1];
		   arr[i-1] = temp;
		   System.out.println();
	   }
	}
	
	
	

	public static void main(String[] args) {
	int[][]score = setArray();
	arrayInput(score);
	showInputScore(score);
	changed(score);
	showInputScore(score);

	}
	 public static int getInputInt() {
		 Scanner sc = new Scanner(System.in);
		 String input = sc.nextLine();
		 return Integer.parseInt(input);
	 }

}
