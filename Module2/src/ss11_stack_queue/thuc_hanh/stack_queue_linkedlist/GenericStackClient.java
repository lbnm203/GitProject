package ss11_stack_queue.thuc_hanh.stack_queue_linkedlist;

import static ss11_stack_queue.thuc_hanh.stack_queue_linkedlist.MyGenericStack.stackOfIntergers;
import static ss11_stack_queue.thuc_hanh.stack_queue_linkedlist.MyGenericStack.stackOfStrings;

public class GenericStackClient {
    public static void main(String[] args) {
        System.out.println("=== Stack of integers");
        stackOfIntergers();

        System.out.println("=== Stack of Strings");
        stackOfStrings();
    }
}
