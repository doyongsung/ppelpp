package ex.io;

import java.io.File;

public class FileMove {

	public static void main(String[] args) {
		
		//File myFile = new File("C:\\MyJava", "origin.pdf");
		File myFile = new File("C:"+File.separator+"\\MyJava"+File.separator+"origin.pdf");
		System.out.println(myFile);
		
		if(myFile.exists()) {
			System.out.println("파일이 존재합니다.");
		}else {
			System.out.println("파일이 존재하지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		
		// 새로운 폴더 생성 : 경로 생성 -> 생성
		
		File newDir = new File("C:\\yourjava");
		System.out.println("1. exist ?? --> " + newDir.exists());
		
		if(newDir.exists()) {
			//폴더 생성
			newDir.mkdir();	
		
		
		System.out.println("2. exist ?? --> " + newDir.exists());
		}
		
		System.out.println(myFile.getName());
		// 이동할 경로와 파일 이름 
		File newFile = new File(newDir,"origin.pdf");
		// 이동
		myFile.renameTo(newFile);
		
		if(newFile.exists()) {
			System.out.println("파일 이동 성공");
		}else {
			System.out.println("파일 이동 실패");
		}
	}
	
	
	

}
