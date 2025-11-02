package ss17_io_binary.thuc_hanh.bai_doc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("src/ss17_io_binary/thuc_hanh/bai_doc/temp.dat")) {
            for (int i = 0; i < 15; i++) {
                output.write(i);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Input/Output error");
        }

        try (FileInputStream input = new FileInputStream("src/ss17_io_binary/thuc_hanh/bai_doc/temp.dat")) {
            int value;
            while ((value = input.read()) != -1) {
                System.out.println(value);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Input/Output error");
        }
    }
}
