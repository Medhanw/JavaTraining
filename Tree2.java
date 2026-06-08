import java.util.LinkedList;
import java.util.Queue;

class TreeOps {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    // FIXED: Only one inOrder method, with the base case handled properly
    void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);                  // Left
        System.out.print(root.data + " ");   // Root
        inOrder(root.right);                 // Right
    }

    // FIXED: Queue now safely holds Node objects instead of Integers
    void levelOrder(Node root) {
        if (root == null) return;
        
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        
        while (!que.isEmpty()) {
            Node ele = que.poll();
            System.out.print(ele.data + " ");
            
            // Check if children exist before adding them to the queue
            if (ele.left != null) {
                que.offer(ele.left);
            }
            if (ele.right != null) {
                que.offer(ele.right);
            }
        }
        System.out.println();
    }
}

public class Tree2 {
    public static void main(String[] args) {
        TreeOps tree = new TreeOps();
        
        // Creating a simple tree for testing
        TreeOps.Node root = new TreeOps.Node(10);
        root.left = new TreeOps.Node(20);
        root.right = new TreeOps.Node(30);
        
        System.out.print("InOrder Traversal: ");
        tree.inOrder(root);
        System.out.println();
        
        System.out.print("LevelOrder Traversal: ");
        tree.levelOrder(root);
    }
}