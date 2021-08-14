// implementation of a queue using linked list
public class LLQueue {

    Node front;
    Node rear;

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LLQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enQueue(int element) {
        Node newNode = new Node(element);
        System.out.println("enqueuing element: " + element);
        if(this.front == null) {
            this.front = this.rear = newNode;
        }
        else {
            rear.next = newNode;
            this.rear = newNode;
        }
    }

    public int deQueue() {
        int val = -1;
        if(this.front != null) {
            val = this.front.data;
            this.front = this.front.next;
        }
        return val;
    }

    public void traverse() {
        Node p = this.front;
        while (p != null) {
            System.out.println("element: " + p.data);
            p = p.next;
        }
    }
}

class testPgm {
    public static void main(String[] args) {
        LLQueue q = new LLQueue();
        q.enQueue(10);
        q.enQueue(11);
        q.enQueue(12);
        q.enQueue(13);
        q.enQueue(14);
        q.enQueue(15);

        q.traverse();

        System.out.println("dequeued element: " + q.deQueue());
        System.out.println("dequeued element: " + q.deQueue());
        System.out.println("dequeued element: " + q.deQueue());
        System.out.println("dequeued element: " + q.deQueue());
        System.out.println("dequeued element: " + q.deQueue());
        System.out.println("dequeued element: " + q.deQueue());
        System.out.println("dequeued element: " + q.deQueue());
        System.out.println("dequeued element: " + q.deQueue());
    }
}


