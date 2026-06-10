import java.util.ArrayList;

import Mergequeue.Node;

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
ArrayList<ArrayList<Integer>> findPath(Node root, int target){
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    dfs(root,target,path,res);
    return res;
}

void dfs(Mergequeue.Node root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res){
    if(root==null) return;
    path.add(root.data);
    if(target-root.data == 0){
        res.add(new ArrayList<>(path));
    }
    dfs(root.left, target-root.data, path, res);
    dfs(root.right, target-root.data, path, res);

    path.remove(path.size() -1);

    
}


public class Tree1 {
    public static void main(String[] args) {
        TreeOps tree = new TreeOps();
        Node root1 = tree.buildTree(new Integer[]{5, 4, 8, 11, 13, 4, 7, 2, 1});
        ArrayList<ArrayList<Integer>> res = tree.findPath(root1, 22);
        System.out.println(res);
        // TreeOps.Node root = tree.createNode(10);
        // root.left = new TreeOps.Node(20);
        // root.right = new TreeOps.Node(30);
        // root.left.right = new TreeOps.Node(50);
        // root.left.left = new TreeOps.Node(40);

        // System.out.println("Tree built Successfully!! Root value is: " + root.data);

    }
    
}
