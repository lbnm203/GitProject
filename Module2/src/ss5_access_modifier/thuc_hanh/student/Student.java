package ss5_access_modifier.thuc_hanh.student;

class Student {
    private  int rollNo;
    private String name;
    private static String college = "HUSC";

    Student(int r, String n) {
        rollNo = r;
        name = n;
    }

    static void change() {
        college = "HUST";
    }

    void display() {
        System.out.println("Roll No: " + rollNo + " Name: " + name + " College: " + college);
    }
}
