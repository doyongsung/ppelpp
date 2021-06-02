package ex.io;

import java.io.*;

public class BufferBufferdFileCopy {
    public static void main(String[] args) throws IOException {
        try {
            InputStream in = new FileInputStream("origin.pdf");
            OutputStream out = new FileOutputStream("copy3.pdf");

            //필터 스트림이 생성 -> 기본 스트림이 필요
            BufferedInputStream fin = new BufferedInputStream(in);
            BufferedOutputStream fout = new BufferedOutputStream(out);
            
            // 카피한 데이터으 ㅣ크기
            int copyByte=0;
            //파일에서 읽어올 바이트 데이터
            int bData = -1;
            
            while(true)
            {
            	bData = fin.read();
                //bData=in.read();
            	
            	//탈출의 조건
                if(bData==-1) {
                    break;
                }
                fout.write(bData);
                copyByte++;
            }
            in.close();
            out.close();
            System.out.println("복사된 바이트 크기 "+ copyByte);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}