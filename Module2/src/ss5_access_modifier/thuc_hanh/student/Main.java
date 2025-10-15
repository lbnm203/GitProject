package ss5_access_modifier.thuc_hanh.student;

public class Main {
    public static void main(String[] args) {
        Student.change();

        Student s1 = new Student(1, "John");
        Student s2 = new Student(2, "Mary");
        Student s3 = new Student(3, "Bob");

        s1.display();
        s2.display();
        s3.display();
    }
}
