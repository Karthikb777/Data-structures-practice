import java.beans.JavaBean;

public class BinaryTree {

    class Node {
       Node left;
       Node right;
       int data;

        public Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    public Node createNode(int data) {
        Node newNode = new Node(data);
        return newNode;
    }

//    prev for isBST function
    public static Node prev = null;

//    check if a BT is a BST or not
    public boolean isBST(Node root) {
//        check if root is not null, if it is, consider it as a binary tree
        if (root != null){
//            check the left subtree if its a BST or not, if its not, return false
            if (!isBST(root.left)) {
                return false;
            }
//            if the left subtree is a BST, check whether the root.data is less than or equal to prev.data and prev is not null
//            if root is less than or equal to, it violates the laws of BST, so return false
            if (prev != null && root.data <= prev.data) {
                return false;
            }
//            set prev to root
            prev = root;
//            apply the same function to the right subtree of root
            return isBST(root.right);
        }
        else {
            return true;
        }
    }

//    preOrderTraversal -->  root -> left -> right
    public void preOrder(Node n) {
        if (n != null)
        {
            System.out.print(n.data + ", ");
            preOrder(n.left);
            preOrder(n.right);
        }
    }

//    inOrderTraversal --> left -> root -> right
    public void inOrder(Node n) {
        if (n != null)
        {
            inOrder(n.left);
            System.out.print(n.data + ", ");
            inOrder(n.right);
        }
    }

//    postOrderTraversal --> left -> right -> root
    public void postOrder(Node n) {
        if (n != null)
        {
            postOrder(n.left);
            postOrder(n.right);
            System.out.print(n.data + ", ");
        }
    }

//    recursively searching a BST
    public Node searchRecursive(Node root, int key) {
        if (root != null){
            if (root.data == key) {
                return root;
            } else if (root.data < key) {
                return searchRecursive(root.right, key);
            } else {
                return searchRecursive(root.left, key);
            }
        }
        return null;
    }

//    Iteratively searching a BST
    public Node searchIterative(Node root, int key) {
        while (root != null){
            if (root.data == key) {
                return root;
            } else if (root.data < key) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }
}

class testBt {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        BinaryTree.Node n = bt.createNode(20);
        BinaryTree.Node n1 = bt.createNode(35);
        BinaryTree.Node n2 = bt.createNode(10);
        BinaryTree.Node n3 = bt.createNode(50);
        BinaryTree.Node n4 = bt.createNode(2);
        BinaryTree.Node n5 = bt.createNode(3);
        BinaryTree.Node n6 = bt.createNode(69);

        n.left = n1;
        n.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;

        System.out.println("pre order traversal");
        bt.preOrder(n);
        System.out.println("");

        System.out.println("in order traversal");
        bt.inOrder(n);
        System.out.println("");

        System.out.println("post order traversal");
        bt.postOrder(n);
    }
}

/*
    binary search tree (BST):
    PROPERTIES:
        all nodes of left subtree are greater
        all nodes of right subtree are lesser
        left and right subtrees are also BST
        there are no duplicate nodes
        inorder traversal of a BST will result in a sorted array of ascending order
 */
class testBST {
    public static void main(String[] args) {
        /*
                10
               /  \
              8    12
             / \   / \
            7   9 11  14
    a valid BST is as shown above
         */
        BinaryTree bst = new BinaryTree();
        BinaryTree.Node n = bst.createNode(10);
        BinaryTree.Node n1 = bst.createNode(8);
        BinaryTree.Node n2 = bst.createNode(12);
        BinaryTree.Node n3 = bst.createNode(7);
        BinaryTree.Node n4 = bst.createNode(9);
        BinaryTree.Node n5 = bst.createNode(11);
        BinaryTree.Node n6 = bst.createNode(14);

        n.left = n1;
        n.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;

//        bst.inOrder(n);
        int y = 8;
//        BinaryTree.Node x = bst.searchRecursive(n, y);
        BinaryTree.Node x = bst.searchIterative(n, y);
        if (x != null) {
            System.out.println("Found: " + y);
        }
        else {
            System.out.println("Element not found");
        }
//        if (bst.isBST(n)) {
//            System.out.println("its a BST");
//        }
//        else {
//            System.out.println("its not a BST");
//        }
    }
}
