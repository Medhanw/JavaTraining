import java.util.*;
import java.util.Queue;

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
    Node build(Integer[] arr) {
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
        if(root == null) return 0;
        return 1+ height(root.left) +height(root.right);
    }
    boolean isEqual(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.data != root2.data) return false;

        return root1.data == root2.data && isEqual(root1.left, root2.left)
        && isEqual(root1.right, root2.right);
    }
    void delete(Node root, int key){
        if(root == null) return;
        Queue<Node> que = new LinkedList<>();
        Node keyNode = null;
        que.add(root);
        Node curr = null; // Initialize properly
        
        while(!que.isEmpty()){
            curr = que.poll(); // Fixed spelling typo from 'cur' to 'curr'
            if(curr.data == key){
                keyNode = curr;
            }
            // Fixed: changed from root.left/right to curr.left/right
            if(curr.left != null) que.offer(curr.left); 
            if(curr.right != null) que.offer(curr.right);
        }
        
        if(keyNode != null){
            keyNode.data = curr.data; // copy deepest node value to target node
            delLastNode(root, curr);   // Fixed: passed both root and deepest node
        }
    }

    // Fixed delLastNode logic to prevent NullPointerExceptions during traversal
    void delLastNode(Node root, Node delNode){
        if (root == null || delNode == null) return;
        if (root == delNode) {
            root = null;
            return;
        }
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            Node curr = que.poll();
            if(curr.left == delNode){
                curr.left = null;
                break;
            } else if (curr.left != null) { // Fixed: check for null before offering
                que.offer(curr.left);
            }
            if(curr.right == delNode){
                curr.right = null;
                break;
            } else if (curr.right != null) { // Fixed: check for null before offering
                que.offer(curr.right);
            }
        }
    }
}

public class PreOrder {
    public static void main(String[] args) {
        //TreeOps ops = new TreeOps();
        //Node root = new Node(1);
        //root.left = new Node(2);
        //root.right = new Node(3);

        //System.out.print("Recursive Pre-Order: ");
        //ops.preOrder(root);
        //System.out.println();

        //System.out.print("Iterative Pre-Order: ");
        //ops.preOrderIterator(root);
        //System.out.println();

        //Node t1 = new Node(1);
        //t1.left = new Node(2);

        //Node t2 = new Node(1);
        //t2.right = new Node(2);
        TreeOps tree = new TreeOps();

       //System.out.println("Are t1 and t2 mirrors? " + ops.isMirror(t1, t2));
    Node root1 = tree.build(new Integer[]{10, 20, 30, 40, 50, 60, null});
    Node root2 = tree.build(new Integer[]{10, 20, 30, 40, 50, 60, null});

    //System.err.println(tree.isEqual(root1, root2));
    }
}