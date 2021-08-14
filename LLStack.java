// implementation of stack using linkedlist

public class LLStack extends LinkedList {
    int size;
    public LLStack() {
        super();
    }

    public LLStack(int size) {
        super();
        this.size = size; // this can be used to set a limit to the number of elements in the stack
    }

    public boolean isEmpty() {
        if (super.head == null) {
            return true;
        }
        return false;
    }

    public void push(int element) {
        super.insertAtBeginning(element);
    }

    public int pop() {
        if (!isEmpty()) {
            return super.deleteAtBeginning();
        }
        return -1;
    }

    public int peek(int position) {
        return super.getDataAt(position);
    }

    public void traverseStack() {
        super.traverse();
    }
}
