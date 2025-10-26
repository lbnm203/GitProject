package ss12_map_tree.bai_tap.count_char_in_string_map;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CharInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = sc.nextLine();

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        System.out.println(map);
    }
}
