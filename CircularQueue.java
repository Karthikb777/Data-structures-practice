public class CircularQueue {
    int front;
    int back;
    int size;
    int[] arr;

    public CircularQueue(int size) {
        this.size = size;
        this.front = this.back = 0;
        this.arr = new int[size];
    }

    public boolean isEmpty() {
        if (this.front == this.back) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
//        using circular increment formula-> (back + 1) % size
        if (((this.back + 1)%this.size) == this.front) {
            return true;
        }
        return false;
    }

    public void enQueue(int element) {
        if (!isFull()) {
            this.back++;
            this.arr[this.back] = element;
            System.out.println("enqueuing element: " + element);
        } else {
            System.out.println("queue is full!\n");
        }
    }

    public int deQueue() {
        int val = -1;
        if (!isEmpty()) {
            this.front++;
            val = this.arr[this.front];
        } else {
            System.out.println("queue is empty!\n");
        }
        return val;
    }
}

class cqTest {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);
        q.enQueue(50);


        System.out.println("degueuing element: " + q.deQueue());
        System.out.println("degueuing element: " + q.deQueue());
        System.out.println("degueuing element: " + q.deQueue());
        System.out.println("degueuing element: " + q.deQueue());
        System.out.println("degueuing element: " + q.deQueue());
        System.out.println("degueuing element: " + q.deQueue());
    }
}
