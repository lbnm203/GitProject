package ss17_io_binary.thuc_hanh.bai_doc;

import java.io.*;

public class StudentFile {
    public static void main(String[] args) {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("src/ss17_io_binary/thuc_hanh/bai_doc/student_temp.dat"))) {
            output.writeUTF("Jack");
            output.writeDouble(85.5);
            output.writeUTF("Sally");
            output.writeDouble(156.7);
            output.writeUTF("Kai");
            output.writeDouble(124.3);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (DataInputStream input = new DataInputStream(new FileInputStream("src/ss17_io_binary/thuc_hanh/bai_doc/student_temp.dat"))) {
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException e) {
            System.out.println("Read complete");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
