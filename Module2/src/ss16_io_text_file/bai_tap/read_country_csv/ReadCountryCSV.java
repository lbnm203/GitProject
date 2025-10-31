package ss16_io_text_file.bai_tap.read_country_csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCountryCSV {
    public static void main(String[] args) {
        List<Country> countries = readCountryCSV("src/ss16_io_text_file/bai_tap/read_country_csv/country.csv");

        System.out.println("Danh sach quoc gia: ");
        printCountryCSV(countries);
    }

    public static void printCountryCSV(List<Country> countries) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s %-10s %-20s\n", "ID", "Code", "Name"));
        sb.append("---------------------------------------------------------\n");
        for (Country country : countries) {
            sb.append(String.format("%-5s %-10s %-20s\n",
                    country.getId(),
                    country.getCode(),
                    country.getName()));
        }
        System.out.println(sb);
    }

    public static List<Country> readCountryCSV(String fileName) {
        List<Country> countries = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] data;
            int id;
            String code;
            String name;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                data = line.split(",");

                id = Integer.parseInt(data[0]);
                code = data[1].replace("\"", "").trim();
                name = data[2].replace("\"", "").trim();

                Country country = new Country(id, code, name);
                countries.add(country);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        } catch (Exception e) {
            System.out.println("Loi khi doc file");
        }
        return countries;
    }
}
