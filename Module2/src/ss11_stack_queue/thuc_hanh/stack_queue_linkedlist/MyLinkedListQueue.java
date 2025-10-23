package ss11_stack_queue.thuc_hanh.stack_queue_linkedlist;

public class MyLinkedListQueue {
    private Node head;
    private Node tail;

    public MyLinkedListQueue() {
        head = null;
        tail = null;
    }

    public void enqueue(int key) {
        Node tmp = new Node(key);
        if (this.tail == null) {
            this.head = tmp;
            this.tail = tmp;
            return;
        }
        this.tail.next = tmp;
        this.tail = tmp;
    }

    public Node dequeue() {
        if (this.head == null) return null;
        Node tmp = this.head;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        return tmp;
    }
}
