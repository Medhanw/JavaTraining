import java.util.*;
import java.util.Queue;
class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        this.data = d; 
        this.left = null;
        this.right = null;
    }
}

class Traverse {
    
    Node buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1; 

        while (!q.isEmpty() && i < arr.length) {
            Node current = q.poll();

            if (i < arr.length && arr[i] != null) {
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++; 
            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                q.add(current.right);
            }
            i++; 
        }
        
        return root;
    }


    void printLevelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        System.out.println();
    }
}

public class Traverser {
    public static void main(String[] args) {
        // 1. Change 'Traverser' to 'Traverse' to match your helper class name
        Traverse t = new Traverse(); 
        
        Integer[] arr = {1, 2, 3, 4, null, null, 5};
        
        // This will now work perfectly
        Node root = t.buildTree(arr);
        
        System.out.print("Level Order Traversal of Built Tree: ");
        // 2. Fixed the method name here from printTraverser to printLevelOrder
        t.printLevelOrder(root); 
    }
}