public class Queue {
    int size;
    int front;
    int back;
    int[] arr;

    public Queue(int size) {
        this.size = size;
        this.front = -1;
        this.back = -1;
        this.arr = new int[size];
    }

    public boolean isEmpty() {
        if (this.front == this.back) {
            this.front = this.back = -1;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isFull() {
        if (this.back == this.size-1) {
            return true;
        }
        return false;
    }

    public void enQueue(int element) {
        if (!isFull()) {
            this.back++;
            this.arr[this.back] = element;
        }
    }

    public int deQueue() {
        int element = -1;
        if (!isEmpty()) {
            this.front++;
            element = this.arr[this.front];
        }
        return element;
    }
}

class TestClass {
    public static void main(String[] args) {
        Queue q = new Queue(6);
        q.enQueue(5);
        q.enQueue(10);
        q.enQueue(15);
        q.enQueue(20);
//        q.enQueue(25);
//        q.enQueue(30);
//        System.out.println("dequeued element: " + q.deQueue());
//        System.out.println("dequeued element: " + q.deQueue());
//        System.out.println("dequeued element: " + q.deQueue());
//        System.out.println("dequeued element: " + q.deQueue());
//        System.out.println("dequeued element: " + q.deQueue());
//        System.out.println("dequeued element: " + q.deQueue());
        if (q.isFull()) {
            System.out.println("queue is full\n");
        }
    }
}
