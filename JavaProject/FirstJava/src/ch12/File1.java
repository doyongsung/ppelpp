package ch12;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class File1 {
	public static void adas() {
		
	}

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String data = simpleDateFormat.format(new Date());
		String header;
		String memo;
		
		

	System.out.println("저장할 폴더를 만들어 주세요");
	File newDir = new File("C:"+File.separator+"save");
	
	if(!newDir.exists()) {
		newDir.mkdir();	
		System.out.println("폴더를 생성 합니다.");
	}
	  header = sc.nextLine();
	  memo = sc.nextLine();	
	  try {
	File file = new File("C:"+File.separator+"save"+File.separator+data+"_"+header+".txt");
	  if(!file.exists()) {
		  
		file.createNewFile();
		 System.out.println("파일을 생성합니다.");
	  }else {
		  System.out.println("파일이 존재합니다.");
	  }
	  BufferedWriter out = new BufferedWriter(new FileWriter(file,true));
		
	
	  out.write("현재 날짜 "+ data);
	  out.newLine();
	  out.write("제목 " + header);
	  out.newLine();
	  out.write("메모 " + memo);
	  
		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  }
	
	
	
  
}


