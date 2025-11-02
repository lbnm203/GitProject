package ss17_io_binary.thuc_hanh.bai_doc;

import java.io.IOException;
import java.io.InputStream;

public class ReadWriteBinary {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        while(true) {
            System.out.print("Nhập ký tự: ");
            int ch = in.read();
            if (ch == 'q') {
                System.out.println("Ok");
                break;
            }
            in.skip(2);
            System.out.println("Ký tự nhận được: " + (char) (ch));
        }
    }
}
