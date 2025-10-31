package ss16_io_text_file.bai_tap.copy_file;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập đường dẫn tệp nguồn: ");
        String source = sc.nextLine().trim();

        System.out.print("Nhập đường dẫn tệp đích: ");
        String target = sc.nextLine().trim();

        File sourceFile = new File(source);
        File targetFile = new File(target);

        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn không tồn tại");
            return;
        }


        if (targetFile.exists()) {
            System.out.println("Tệp đích đã tồn tại. Ghi đè (y/n): ");
            String confirm = sc.nextLine().trim().toLowerCase();
            switch (confirm) {
                case "y":
                    long charCount = copyFileWrite(sourceFile, targetFile);
                    if (charCount > 0) {
                        System.out.println("Sao chép thành công. Tổng ký tự: " + charCount);
                    } else {
                        System.out.println("Sao chép thất bại");
                    }
                case "n":
                    System.out.println("Hùy thao tác sao chép");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    return;
            }
        } else {
            long charCount = copyFileWrite(sourceFile, targetFile);
            if (charCount > 0) {
                System.out.println("Sao chép thành công. Tổng ký tự: " + charCount);
            } else {
                System.out.println("Sao chép thất bại");
            }
        }

    }

    public static long copyFileWrite(File source, File target) {
        long charCount = 0;
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {

            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
                charCount += line.length();

            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
            return -1;
        } catch (IOException e) {
            System.out.println("Lỗi khi Copy " + e.getMessage());
            return -1;
        }
        return charCount;
    }
}
