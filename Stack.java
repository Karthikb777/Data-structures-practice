// implementation of stack using char array
public class Stack {
    int size;
    int top;
    char[] arr;

    public Stack(int size, int top) {
        this.size = size;
        this.top = top;
        this.arr = new char[size];
    }

    public Boolean isEmpty() {
        if (this.top == -1) {
            return true;
        }
        return false;
    }

    public Boolean isFull() {
        if (this.top == this.size-1) {
            return true;
        }
        return false;
    }

    public void push(char element) {
        if (!isFull()) {
            this.top++;
            this.arr[this.top] = element;
        }
    }

    public char pop() {
        if (!isEmpty()) {
            char popped = this.arr[this.top];
            this.top--;
            return popped;
        }
        return 0;
    }

    public char peek(int pos) {
        int position = this.top - pos + 1;
        if (position < 0) {
            return 0;
        }
        return this.arr[position];
    }
}
