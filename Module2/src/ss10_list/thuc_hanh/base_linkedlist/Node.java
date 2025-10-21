package ss10_list.thuc_hanh.base_linkedlist;

public class Node {
    private Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return this.data;
    }
}
