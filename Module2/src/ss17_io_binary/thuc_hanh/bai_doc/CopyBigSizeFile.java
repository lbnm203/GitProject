package ss17_io_binary.thuc_hanh.bai_doc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopyBigSizeFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập đường dẫn nguồn: ");
        String sourcePath = sc.nextLine();

        System.out.println("Nhập đường dẫn đích: ");
        String targetPath = sc.nextLine();

        File source = new File(sourcePath);
        File target = new File(targetPath);

        try {
//            copyFileUsingJava7File(source, target);
            copyFileUsingStream(source, target);
            System.out.println("Copy file successfully!");
        } catch (IOException e) {
            System.out.println("Copy file failed!");
            System.out.println(e.getMessage());
        }
    }

    private static void copyFileUsingJava7File(File source, File target) throws IOException {
        Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File target) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(target);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            input.close();
            output.close();
        }
    }
}
