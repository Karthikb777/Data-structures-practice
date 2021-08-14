public class LinkedList {
    Node head;

    protected class Node {
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        int data;
        Node next;
    }

    public LinkedList() {
        this.head = null;
    }
/*
    not necessary, insertAtBeginning will work fine
    public void createNode(int data) {
        this.node = new Node(data, null);
        this.head = this.node;
    }
*/

    public void insertNode(int data) {
        Node ptr = this.head;
        Node newNode = new Node(data, null);
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = newNode;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data, this.head);
        this.head = newNode;
    }

    public void insertAtIndex(int data, int index) {
        Node newNode = new Node(data, null);
        int i = 0;
        Node ptr = this.head;
        while (i != index-1) {
            ptr = ptr.next;
            i++;
        }
        newNode.next = ptr.next;
        ptr.next = newNode;
    }

    public int deleteNode() {
        Node p = this.head;
        Node q = this.head.next;
        int deletedData;

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        deletedData = q.data;
        p.next = null;
        q = null;
        return deletedData;
    }

    public int deleteAtBeginning() {
        Node p = this.head;
        int deletedData = p.data;
        this.head = this.head.next;
        p = null;
        return deletedData;
    }

    public int deleteAtIndex(int index) {
        Node p = this.head;
        Node q = this.head.next;
        int deletedData = 0;

        for (int i = 0; i != index-1 ; i++) {
            p = p.next;
            q = q.next;
        }
        deletedData = q.data;
        p.next = q.next;
        return deletedData;
    }

    public int getDataAt(int position) {
        Node ptr = this.head;
        for (int i = 0; (i != position - 1 && ptr != null); i++) {
            ptr = ptr.next;
        }
        if (ptr != null) {
            return ptr.data;
        }
        return -1;
    }

    public void traverse() {
        Node ptr = this.head;
        while (ptr != null) {
            System.out.println("element: " + ptr.data);
            ptr = ptr.next;
        }
    }
}

class testLL {
    public static void main(String[] args) {
        //        LinkedList LL = new LinkedList();
//        LL.insertAtBeginning(80);
//        LL.insertAtBeginning(800);
//        LL.insertNode(70);
//        LL.insertNode(60);
//        LL.insertNode(50);
//        LL.insertNode(40);
//        LL.insertNode(30);
//        LL.insertNode(20);
//
//        System.out.println("before inserting\n");
//        LL.traverse();

//        LL.insertAtBeginning(2000);
//        LL.insertInMiddle(1,2); // index starts from 0
//        System.out.println("deleted element: " + LL.deleteAtIndex(3));
//        System.out.println("deleted element: " + LL.deleteNode());
//        System.out.println("deleted element: " + LL.deleteNode());


//        System.out.println("after inserting\n");
//        LL.traverse();

        LLStack s = new LLStack();
//        if(s.isEmpty()) {
//            System.out.println("stack is empty");
//        }
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);

        s.traverseStack();
        for (int i = 1; i <= 6; i++) {
            System.out.println("the element at position " + i + " is " + s.peek(i));
        }
        System.out.println("popped element is: " + s.pop());
        System.out.println("popped element is: " + s.pop());
//        System.out.println("popped element is: " + s.pop());
//        System.out.println("popped element is: " + s.pop());

        s.traverseStack();
    }
}
