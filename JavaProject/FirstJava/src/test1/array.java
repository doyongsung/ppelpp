package test1; 
public class array {

	public static void main(String[] args) {
		int[][] arr= new int[3][4];
		
		for(int i =0; i <3; i++) {
			for(int j =0; j <arr[0].length; j++) {
				arr[i][j] = i+j;
				
			}
		}
			for(int i =0;i < 3; i++ ) {
				for(int j = 0; j < arr[0].length; j++) {
					System.out.println(arr[i][j]+" ");
				}
			}
			System.out.println("");
		

	}

}
