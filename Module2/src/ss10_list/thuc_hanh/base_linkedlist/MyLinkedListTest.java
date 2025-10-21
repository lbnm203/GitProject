package ss10_list.thuc_hanh.base_linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.printList();
        System.out.println("--------------------------------");
        ll.addFirst(12);
        ll.addFirst(13);
        ll.printList();
        System.out.println("--------------------------------");

        ll.add(4,9);
        ll.add(4,2);
        ll.printList();
    }
}
