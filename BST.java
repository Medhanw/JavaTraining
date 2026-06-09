import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;
public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    
    }

    static Node buildTree(Integer[] arr){
        if(arr.length == 0) return null;
        Queue<Node> que = new LinkedList<>();
        Node root = new Node(arr[0]);
        que.add(root);
        int i = 1;
        
        // ADDED THE BOUNDARY CHECK HERE TO PREVENT THE CRASH
        while(!que.isEmpty() && i < arr.length){
            Node curr = que.poll();
            if(arr[i]!=null)
                curr.left = new Node(arr[i]);
            que.offer(curr.left);

            if(arr[i+1]!=null)
            curr.right = new Node(arr[i+1]);
            que.offer(curr.right);
            i+=2;
        }
        return root;
    }
    static void preOrder(Node root){
    if(root == null) return;
    System.out.println(root.data);
    preOrder(root.left);
    preOrder(root.right);
}

static Node insert(Node root, int val){
    if(root == null) return new Node(val);
    if(root.data <= val){
        root.right = insert(root.right, val);
    }else{
        root.left = insert(root.left, val);
    }
    return root;
} 

static void inOrder(Node root){
    if(root == null) return;
    inOrder(root.left);
    System.out.println(root.data + " ");
    inOrder(root.right);
}

static boolean search(Node root, int key){
    if(root == null) return false;
    if(root.data == key)return true;
    Queue<Node> que = new LinkedList<>();
    que.add(root);
    while (!que.isEmpty()) {
        Node curr = que.poll();
        if(curr.data == key) return true;
        if(curr.left!=null)que.offer(curr.left);
        if(curr.right!=null)que.offer(curr.right);
    }
    return false;
}
static int height(Node root){
    if(root == null) return 0;
    return 1 + Math.max(height(root.left),height(root.right));

}
static boolean isValidBST(Node root, int max, int min){
    if(root == null) return true;
    if(root.data < min) return false;
    if(root.data > max) return false;

    return root.data <= max && root.data > min && isValidBST(root.left, root.data, min)
        && isValidBST(root.right, max, root.data);
}

static void topView(Node root){
    if(root == null) return;
    Deque<Integer> st = new ArrayDeque<>();
    Node temp = root.left;
    while(temp!=null){
        st.push(temp.data);
        temp = temp.left;
    }
    while(!st.isEmpty()){
    System.out.println(st.pop() + " ");
}
System.out.print(root.data + " ");
temp = root.right;
while(temp!=null){
    st.push(temp.data);
    temp = temp.right;
}
while(!st.isEmpty()){
    System.out.println(st.pop() + " ");
}
}

public static void main(String[] args) {
    Node root = buildTree(new Integer[]{30, 20, 40, 15, 25, 35, 45});
    inOrder(root);
    System.out.println();
    root = insert(root, 41);
    inOrder(root);
    root = insert(root,41);
    inOrder(root);
    System.out.println(search(root, 55));
    boolean res = isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    System.out.println(res);
}
}