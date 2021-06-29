package ch05;

import java.util.Arrays;

public class ch5_24 {
public static void main(String[] args) {
	int[] arr = {0,1,2,3,4};
	int[][] arr2d = {{11,12},{21,22}};
	
	System.out.println(Arrays.toString(arr));
	System.out.println(Arrays.deepToString(arr2d));
	
	String[][] str2d= new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
	String[][] str2d2= new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
	
	System.out.println(Arrays.equals(str2d,str2d2));
	System.out.println(Arrays.deepEquals(str2d,str2d2));

}
}
