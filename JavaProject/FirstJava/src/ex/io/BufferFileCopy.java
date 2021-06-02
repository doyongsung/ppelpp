package ex.io;

import java.io.*;

public class BufferFileCopy {
    public static void main(String[] args) throws IOException {
        try {
            InputStream in = new FileInputStream("origin.pdf");
            OutputStream out = new FileOutputStream("copy.pdf");

            int readLen;
            int copyByte=0;
            byte[] buf = new byte[1024];
            while(true)
            {
                readLen=in.read(buf);
                if(readLen==-1) {
                    break;
                }
                out.write(buf,0,readLen);
                copyByte+=readLen;
            }
            in.close();
            out.close();
            System.out.println("복사된 바이트 크기 "+ copyByte);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}