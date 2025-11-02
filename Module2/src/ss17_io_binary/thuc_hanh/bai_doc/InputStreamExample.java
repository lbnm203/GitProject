package ss17_io_binary.thuc_hanh.bai_doc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("src/ss17_io_binary/thuc_hanh/product.txt");

        byte[] bytes = new byte[10];
        int i = -1;

        while ((i = in.read(bytes)) != -1) {
            String s = new String(bytes, 0, i);
//            System.out.print((char) i);
            System.out.println(s);
        }
        in.close();
    }
}
