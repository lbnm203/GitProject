package ss10_list.bai_tap.linkedlist_method;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.add(0, "Hello");
        ll.add(1, "Hello2");
        ll.add(2, "Hello3");
        ll.add(1, "Hello4");
        ll.add("Hello5");
        ll.addFirst("Hello6");
        ll.addLast("Hello7");


        System.out.println("Mang ban dau: ");
        ll.printList();

        ll.remove(3);
        System.out.println("\nMang sau khi xoa: ");
        ll.printList();

        ll.remove(0);
        ll.remove("Hello5");
        System.out.println("\nMang sau khi xoa lan 2: ");
        ll.printList();
    }
}
