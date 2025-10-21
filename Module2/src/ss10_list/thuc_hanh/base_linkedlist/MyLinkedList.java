package ss10_list.thuc_hanh.base_linkedlist;


public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }

    public void add(Object data) {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new Node(data);
        numNodes++;
    }

    public void add(int index, Object data) {
        Node tmp = head;
        Node holder;

        for (int i = 0; i < index && tmp.next != null; i++) {
            tmp = tmp.next;
        }

        holder = tmp.next;
        tmp.next = new Node(data);
        tmp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data) {
        Node tmp = head;
        head = new Node(data);
        head.next = tmp;
        numNodes++;
    }

    public Node get(int index) {
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.getData());
            tmp = tmp.next;
        }
    }
}
