import java.util.ArrayList;
import java.util.List;

public class findMinMax {
    class Solution{
        public List<Integer> findMinMax(BST.Node root){
            List<Integer> result = new ArrayList<>();

            if(root == null){
                return result;
            }
            BST.Node current = root;
            while(current.left != null){
                current = current.left;
            }
            int min = current.data;

            current = root;
            while(current.right != null){
                current = current.right;
            }
            int max = current.data;

            result.add(min);
            result.add(max);

            return result;
        }

    }
    public static void main(String[] args) {
        BST.Node root = new BST.Node(30);
        root.left = new BST.Node(20);
        root.right = new BST.Node(40);
        root.left.left = new BST.Node(15);
        root.left.right = new BST.Node(25);
        root.right.left = new BST.Node(24);
        root.right.right = new BST.Node(55);

        findMinMax outer = new findMinMax();
        Solution sol = outer.new Solution();
        List<Integer> minMax = sol.findMinMax(root);

        System.out.println("Min and Max elements " + minMax);

    }
    
}
