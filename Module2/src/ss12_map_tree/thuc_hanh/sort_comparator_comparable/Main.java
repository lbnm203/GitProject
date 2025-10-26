package ss12_map_tree.thuc_hanh.sort_comparator_comparable;

import ss7_abstraction.bai_tap.colorable.service.Colorable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John", 20, "HCM");
        Student student2 = new Student("Mary", 21, "HN");
        Student student3 = new Student("Bob", 22, "NY");
        Student student4 = new Student("Hung", 25, "HCM");

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        System.out.println(list);

        Collections.sort(list);
        for (Student student : list) {
            System.out.println(student);
        }

        System.out.println("-------------------------");
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(list, ageComparator);
        for (Student student : list) {
            System.out.println(student);
        }


    }
}
