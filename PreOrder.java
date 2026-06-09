import java.util.*;

// Assuming Node class is defined as before
class Node {
    int data;
    Node left, right;
    Node(int d) {
        this.data = d;
    }
}

class TreeOps {
    // 1. Fixed Recursive Pre-Order (Root -> Left -> Right)
    void preOrder(Node root) {
        if (root == null) return;
        
        System.out.print(root.data + " "); // Print root
        preOrder(root.left);               // Recurse left
        preOrder(root.right);              // Recurse right
    }

    // 2. Fixed Iterative Pre-Order using a Stack (Deque)
    void preOrderIterator(Node root) {
        if (root == null) return;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node ele = stack.pop();
            System.out.print(ele.data + " ");

            // Crucial: Push RIGHT first so LEFT is processed first (LIFO)
            if (ele.right != null) {
                stack.push(ele.right);
            }
            if (ele.left != null) {
                stack.push(ele.left);
            }
        }
    }

    // 3. Fixed Mirror Tree Logic
    boolean isMirror(Node root1, Node root2) {
        // If both nodes are null, they are symmetric
        if (root1 == null && root2 == null) return true;
        
        // If only one node is null, they cannot be mirrors
        if (root1 == null || root2 == null) return false;
        
        // Check if current data matches, and recursively check structural mirror reflections
        return (root1.data == root2.data)
            && isMirror(root1.left, root2.right)
            && isMirror(root1.right, root2.left);
    }
    int height(Node root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    int diameter = 0;
    int getdiameter(Node root){
        
    }
}

public class PreOrder {
    public static void main(String[] args) {
        TreeOps ops = new TreeOps();

        // Let's manually map out a simple tree:
        //       1
        //      / \
        //     2   3
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        System.out.print("Recursive Pre-Order: ");
        ops.preOrder(root);
        System.out.println();

        System.out.print("Iterative Pre-Order: ");
        ops.preOrderIterator(root);
        System.out.println();

        // Test Mirror Functionality
        // Tree 1:   1         Tree 2:   1
        //          /                   \
        //         2                     2
        Node t1 = new Node(1);
        t1.left = new Node(2);

        Node t2 = new Node(1);
        t2.right = new Node(2);

        System.out.println("Are t1 and t2 mirrors? " + ops.isMirror(t1, t2));
    }
}