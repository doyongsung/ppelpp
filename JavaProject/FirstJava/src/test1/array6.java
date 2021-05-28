package test1;
public class array6 {



private static void input() {
     int score = 9;
      //int[][] arr = { {1,2,3},{4,5,6},{7,8,9}};
      int[][] arr = new int[3][3];
     
     for(int i = 0; i < arr.length; i++) {
        for(int j = 0; j <arr[i].length; j++) {
         arr[i][j] = score;
         score = score -1;
         System.out.print(arr[i][j]+" ");
         
        
     
//        System.out.println(arr[i][j]);
        //System.out.println("첫 : "+(i+1) + " 두 : "+(j+1));
        }
        System.out.println();
     }
}
   public static void main(String[] args) {
//          int arr;
//           int[] tem = new int[4];
//           tem[0] = 1;
//           tem[1] = 2;
//           tem[2] = 3;
//           tem[3] = 4;
//          
//           for(int i = 0; i <tem.length; i++) {
//              System.out.println(tem[i]);
//           }
//           
//           for(int i = tem.length -1; i > 0; i--) {
//                  arr = tem[i];
//                  tem[i] = tem[i-1];
//                  tem[i-1] = arr;
//                  System.out.println(tem[i]);
//                  
//              int[][] arr = new int[3][3];
      
//        int[][] arr = new int[3][3];
//        System.out.println();
//         for(int i = arr.length-1; i >= 0; i--) {
//            for(int j = arr.length-1; j >= 0; j--) {
//               System.out.print(arr[i][j]+ " ");
//            }
//            System.out.println();
//         
//         }
//                  
//                 
//           }
//           
//           
           int score = 9;
           //int[][] arr = { {1,2,3},{4,5,6},{7,8,9}};
           int[][] arr = { {1,2,3},{4,5,6},{7,8,9}};
          
          for(int i = 0; i < arr.length; i++) {
             for(int j = 0; j <arr[i].length; j++) {
              arr[i][j] = score;
              score = score -1;
              System.out.print(arr[i][j]+" ");
              
             
          
//             System.out.println(arr[i][j]);
             //System.out.println("첫 : "+(i+1) + " 두 : "+(j+1));
             }
             System.out.println();
             
          }
          System.out.println();
             for(int[] ints : arr) {
                for(int i : ints) {
                   System.out.print(i +" ");
                }
              System.out.println();
             }
             System.out.println();
             for(int i = arr.length-1; i >= 0; i--) {
                for(int j = arr.length-1; j >= 0; j--) {
                   System.out.print(arr[i][j]+ " ");
                }
                System.out.println();
             
             }
             System.out.println();
             int[] temp;
             for(int i = arr.length-1; i > 0; i--) {
                temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
               
             }
             
             for(int i =0; i <arr.length; i++) {
            for(int j =0; j <arr[i].length; j++) {
               System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
         
         }
       
             
             
          

   }

}