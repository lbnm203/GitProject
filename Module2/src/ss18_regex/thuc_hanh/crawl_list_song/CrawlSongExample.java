package ss18_regex.thuc_hanh.crawl_list_song;

import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/chart/1-5-d308-2025");
            Scanner sc = new Scanner(url.openStream());
            sc.useDelimiter("\\Z");
            String content = sc.next();
            sc.close();
            content = content.replaceAll("\\n+", "");
            Pattern pattern = Pattern.compile("<span[^>]*class=\"[^\"]*name[^\"]*\"[^>]*>(.*?)</span>");
            Matcher matcher = pattern.matcher(content);
            System.out.println("List song:");
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
