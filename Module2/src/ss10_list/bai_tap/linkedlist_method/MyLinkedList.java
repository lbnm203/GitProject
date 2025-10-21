package ss10_list.bai_tap.linkedlist_method;

public class MyLinkedList<E> {
    private Node head;
    private int numNode = 0;

    public MyLinkedList() {
        head = null;
        numNode = 0;
    }

    public boolean add(E data) {
        addLast((E) data);
        return true;
    }

    public void add(int index, E data) {
        Node tmp = head;
        Node current;

        if (index < 0 || index > numNode) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNode);
        }

        if (index == 0) {
            addFirst((E) data);
            return;
        }

        for (int i = 0; i < index - 1 && tmp.next != null; i++) {
            tmp = tmp.next;
        }

        current = tmp.next;
        tmp.next = new Node(data);
        tmp.next.next = current;
        numNode++;
    }

    public void addFirst(E e) {
        Node tmp = head;
        head = new Node(e);
        head.next = tmp;
        numNode++;
    }

    public void addLast(E e) {
        if (head == null) {
            head = new Node(e);
            numNode++;
            return;
        }

        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new Node(e);
    }

    public E remove(int index) {
        if (index < 0 || index >= numNode) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNode);
        }

        Node tmp = head;
        Node current;

        if (index == 0) {
            E removeData = (E) tmp.getData();
            head = head.next;
            numNode--;
            return removeData;
        }

        for (int i = 0; i < index - 1 && tmp.next != null; i++) {
            tmp = tmp.next;
        }

        current = tmp.next;
        E removeData = (E) current.getData();
        tmp.next = current.next;
        numNode--;

        return removeData;
    }

    public boolean remove(Object e) {
        if (head == null) return false;
        if (head.getData().equals(e)) {
            head = head.next;
            numNode--;
            return true;
        }

        Node tmp = head;

        while (tmp.next != null) {
            if (tmp.next.getData().equals(e)) {
                Node next = tmp.next.next;
                tmp.next = next;
                numNode--;
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public int size() {
        return numNode;
    }

    public void printList() {
        Node tmp = head;
        System.out.println("Danh sach: ");
        while (tmp != null) {
            System.out.println(tmp.getData());
            tmp = tmp.next;
        }
    }

    public MyLinkedList<E> clone() {
        if (head == null) return null;

        MyLinkedList<E> cloneList = new MyLinkedList<>();
        Node tmp = head.next;

        while (tmp != null) {
            cloneList.addLast((E) tmp.getData());
            tmp = tmp.next;
        }
        return cloneList;
    }

    public boolean contains (E o) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.getData().equals(o)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public int indexOf(E o) {
        Node tmp = head;
        int index = 0;
        while (tmp != null) {
            if (tmp.getData().equals(o)) {
                return index;
            }
            tmp = tmp.next;
            index++;
        }
        return -1;
    }

    public E get(int i) {
        if (i < 0 || i >= numNode) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + numNode);
        }

        Node tmp = head;
        for (int index = 0; index < i; index++) {
            tmp = tmp.next;
        }
        return (E) tmp.getData();
    }

    public E getFirst() {
        if (head == null) {
            throw new NullPointerException("List is empty");
        }
        return (E) head.getData();
    }

    public E getLast() {
        if (head == null) {
            throw new NullPointerException("List is empty");
        }

        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return (E) tmp.getData();
    }

    public void clear() {
        head = null;
        numNode = 0;
    }


}
