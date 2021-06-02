package ex.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {

	public static void main(String[] args) throws IOException {
        try {
            InputStream in = new FileInputStream("origin.pdf");
            OutputStream out = new FileOutputStream("copy.pdf");

            int copyByte=0;
            int bData;
            while(true)
            {
                bData=in.read();
                if(bData==-1) {
                    break;
                }
                out.write(bData);
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