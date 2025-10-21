package ss10_list.bai_tap.arraylist_method;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();

        list.add("Hello");
        list.add("World");
        list.add("!");
        list.add(1, "Java");

        System.out.println("Danh sach ban dau: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Phan tu " + i + ": " + list.get(i) + "");
        }

        list.remove(2);
        System.out.println("\nDanh sach sau khi xoa: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Phan tu " + i + ": " + list.get(i) + "");
        }


        System.out.println("\nCó chứa 'Python'? " + list.contains("Python"));
        System.out.println("Index của 'C++' là: " + list.indexOf("C++"));

        MyList<String> cloneList = list.clone();
        System.out.println("\nDanh sách clone:");
        for (int i = 0; i < cloneList.size(); i++) {
            System.out.println("Phần tử " + i + ": " + cloneList.get(i));
        }

        list.clear();
        System.out.println("\nSau khi clear, size = " + list.size());
    }
}
