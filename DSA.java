public class DSA {
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
