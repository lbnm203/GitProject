package ss16_io_text_file.thuc_hanh;

import java.io.*;

public class SumOfNum {
    public static void main(String[] args) {
        readFileText("src/ss16_io_text_file/thuc_hanh/numbers.csv");
    }

    public static void readFileText(String fileName) {
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader) ){
            String line;
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            bufferedReader.close();
            System.out.println("Sum = " + sum);
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        } catch (IOException e) {
            System.out.println("Loi khi doc file");
        }
    }


}
