class TreeOps{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    Node createNode(int val){
        Node newNode = new Node(val);
        return newNode;

    }

}

public class Tree1 {
    public static void main(String[] args) {
        TreeOps tree = new TreeOps();
        TreeOps.Node root = tree.createNode(10);
        root.left = new TreeOps.Node(20);
        root.right = new TreeOps.Node(30);
        root.left.right = new TreeOps.Node(50);
        root.left.left = new TreeOps.Node(40);

        System.out.println("Tree built Successfully!! Root value is: " + root.data);

    }
    
}
