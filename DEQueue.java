// double ended queue
// doesn't follow fifo logic, elements can be inserted and deleted from both ends
public class DEQueue extends Queue{

    public DEQueue(int size) {
        super(size);
    }

    public void enQueueFront(int element) {
        if (super.front != -1) {
            super.arr[super.front] = element;
            super.front--;
            System.out.println("enqueuing from front: " + element);
        }
    }

    public int deQueueRear() {
        int val = -1;
        if (!super.isEmpty()) {
            val = super.arr[super.back];
            super.back--;
        }
        return val;
    }
}

class DEQtest {
    public static void main(String[] args) {
        DEQueue dq = new DEQueue(5);
        dq.enQueue(10);
        dq.enQueue(20);
        dq.enQueue(30);

        dq.deQueue();

        System.out.println("dequeuing from rear: " + dq.deQueueRear());
        dq.enQueueFront(100);

        System.out.println("dequeuing element: " + dq.deQueue());
        System.out.println("dequeuing element: " + dq.deQueue());
        System.out.println("dequeuing element: " + dq.deQueue());
    }
}
