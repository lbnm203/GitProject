package ss17_io_binary.thuc_hanh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteListStudent {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Jack", 23, "HCM"));
        students.add(new Student("Pob", 25, "HN"));
        students.add(new Student("Sally", 32, "HCM"));
        students.add(new Student("Kathy", 27, "Singapore"));
        writeDataToFile("src/ss17_io_binary/thuc_hanh/data.txt", students);

        List<Student> studentDataFromFile = readDataFromFile("src/ss17_io_binary/thuc_hanh/data.txt");
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }
    }

    public static void writeDataToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        } catch (IOException e) {
            System.out.println("Lỗi khi Copy " + e.getMessage());
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file " + e.getMessage());
        }
        return students;
    }
}
