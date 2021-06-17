package ch05;

import java.util.Scanner;

public class Ex5_1_tmp2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
	
	while(true) {
	System.out.println("1.[가위], 2.[바위], 3.[보]");
	
	int user = sc.nextInt();
	int com = (int)(Math.random() *3) +1;
	
	String users = null;
	String coms = null;
	switch (user) {
	
	case 1:
		users = "가위.";
		break;
	case 2:
		users = "바위";
		break;
	case 3:
		users = "보";
		break;
	}
	
	switch (com) {
	case 1:
		coms = "가위";
		break;
	case 2:
		coms = "바위";
		break;
	case 3:
		coms = "보";
		break;

	}
	System.out.println("======가위,바위,보===========");
	System.out.printf("user: %s : com: %s\n",users,coms);
	
	if(user == com) {
		System.out.println("무승부");
	}else if(com == 1 && user == 2 || com == 2 && user == 3) {
		System.out.println("승리!");
		break;
	}else {
		System.out.println("패배!");
		break;
	}
	}      
	}
	
	
}
//index: 0~3-1, 0~2
//String[] strArr = {"가위","바위","보"};
//System.out.println(Arrays.toString(strArr));
//
//for(int i=0; i <10; i++) {
//	int tmp = (int)(Math.random()*3);
//System.out.println(strArr[tmp]); //0~2
//}
//}
