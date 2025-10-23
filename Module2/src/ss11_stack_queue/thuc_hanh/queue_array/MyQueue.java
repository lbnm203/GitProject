package ss11_stack_queue.thuc_hanh.queue_array;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        this.queueArr = new int[queueSize];
    }

    public boolean isQueueFull() {
        boolean isFull = false;
        if (currentSize == capacity) {
            isFull = true;
        }
        return isFull;
    }

    public boolean isQueueEmpty() {
        boolean isEmpty = false;
        if (currentSize == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public void enqueue(int data) {
        if (isQueueFull()) {
            System.out.println("Queue is full!");
        } else {
            tail = (tail + 1) % capacity;
            queueArr[tail] = data;
            currentSize++;
            System.out.println("Element " + data + " is push to queue !");
        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            head++;
            if (head == capacity - 1) {
                System.out.println("done remove " + queueArr[head - 1]);
                head = 0;
            } else {
                System.out.println("done remove " + queueArr[head - 1]);
            }
            currentSize--;
        }
    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(4);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(67);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(24);
        queue.dequeue();
        queue.enqueue(98);
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(435);
    }
}
