package ss17_io_binary.thuc_hanh.bai_doc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutStreamExample {
    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream("src/ss17_io_binary/thuc_hanh/output.txt");

        byte[] bytes = new byte[] {'C', 'o', 'd', 'e', 'G', 'y', 'm'};

        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            os.write(b);
        }
        os.close();
    }
}
