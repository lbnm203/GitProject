package ss17_io_binary.thuc_hanh.bai_doc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamExample {
    public static void main(String[] args) throws IOException {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("src/ss17_io_binary/thuc_hanh/product.txt"));
            Product product = (Product) ois.readObject();
            System.out.println(product);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
    }
}
