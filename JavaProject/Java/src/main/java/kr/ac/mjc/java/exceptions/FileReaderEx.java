package kr.ac.mjc.java.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
	
	public void go() throws IOException{
	//FileReader in = null;
		
		//try-with-resources 구문
		//AutoCloseable 인터페이스를 구현한 자원을 try구문의 () 속에 넣으면
		//finally를 쓰지 않아도 자동적으로 close()한다.
		try (FileReader in = new FileReader("/tmp/test.txt");){
		//in = new FileReader("/tmp/test.txt");
		char c = (char)in.read();
		System.out.println(c);
		
//		}catch(FileNotFoundException e) {
//			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
//		}finally {
//			if(in != null) {
//				
//			}
//			try {
//				in.close();
//			} catch (IOException e) {		
//			}
		}
		System.out.println("프로그램이 종료합니다.");
	}
	
	public void come() throws IOException {
		//다음으로 또 넘길 수있음
//		try {
		go();
//		}catch(IOException e){
//			//예외처리
//		}
	}
	
	

	public static void main(String[] args)throws IOException{ //마지막 메인메소드에서 throws하면 시스템으로 예외를 안한다고 시스템에 던짐
	FileReaderEx ex = new FileReaderEx();
	try {
	ex.come();
	}catch(IOException e) {
		
	}
	}
}
