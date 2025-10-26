package ss12_map_tree.thuc_hanh.compare_hashmap_hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Lan", 21, "HN");
        Student student2 = new Student("Hung", 25, "HCM");
        Student student3 = new Student("John", 22, "NY");

        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, student1);
        studentMap.put(2, student2);
        studentMap.put(3, student3);

        System.out.printf("%-5s | %-10s | %-5s | %-10s\n", "ID", "Name", "Age", "Address");

        for (Map.Entry<Integer, Student> student : studentMap.entrySet()) {
            System.out.printf("%-5d | %s\n", student.getKey(), student.getValue().toString());
        }

        System.out.println("\n");
        System.out.printf("%-10s | %-5s | %-10s\n", "Name", "Age", "Address");
        System.out.println("----------------------------------------");
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);

        for (Student student : studentSet) {
            System.out.println(student.toString());
        }
    }
}
