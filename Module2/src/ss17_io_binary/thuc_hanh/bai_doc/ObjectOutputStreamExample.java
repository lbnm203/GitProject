package ss17_io_binary.thuc_hanh.bai_doc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamExample {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/ss17_io_binary/thuc_hanh/product.txt"));
            Product product = new Product(1, "Iphone12", 280000, "New");
            oos.writeObject(product);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
        System.out.println("Done!");
    }
}
