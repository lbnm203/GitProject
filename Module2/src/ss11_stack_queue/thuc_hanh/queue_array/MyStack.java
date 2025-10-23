package ss11_stack_queue.thuc_hanh.queue_array;

public class MyStack {
    private int[] arr;
    private int size;
    private int index;

    public MyStack(int size) {
        this.size = size;
        arr = new int[size];
        index = -1;
    }

    public boolean isFull() {
        boolean status = false;
        if (index == size) {
            status = true;
        }
        return status;
    }

    public boolean isEmpty() {
        boolean status = false;
        if (index == 0) {
            status = true;
        }
        return status;
    }

    public void push(int data) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full!");
        } else {
            index++;
            arr[index] = data;
        }
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        return arr[index--];
    }

    public int size() {
        return index;
    }

    public static void main(String[] args) throws Exception {
        MyStack stack = new MyStack(5);

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println("1. Size of stack after push operations: " + stack.size());
        System.out.printf("2. Pop elements from stack : ");

        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }

        System.out.println("\n3. Size of stack after pop operations : " + stack.size());
    }

}
