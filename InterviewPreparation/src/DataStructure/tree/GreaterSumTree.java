package DataStructure.tree;

public class GreaterSumTree {
    int sum = 0, sum1=0;


    private void getGreaterSumTree(TreeNode root) { //we need to traverse through the tree
        if(root == null) {return;}
        //traversing using in-order traverse
        getGreaterSumTree(root.right); //traverse to the right subtree first
        System.out.println("Current node value: "+root.value);
        sum+= root.value;
        root.value = sum - root.value;
        System.out.println("greater sum of the current node: "+root.value);
        getGreaterSumTree(root.left);
    }

    public void greaterSumTree(TreeNode root){
        if(root==null) return;
        greaterSumTree(root.right);
        int current = root.value;
        sum1+= current;
        root.value = sum1 - current;
        System.out.println("Greater sum of current node: "+current+" is: "+root.value);
        greaterSumTree(root.left);
    }

    public void inOrderTraversal(TreeNode root){
        if(root!=null) {
            inOrderTraversal(root.left);
            System.out.println("Current node: " + root.value);
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        // Create a sample BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        GreaterSumTree gst = new GreaterSumTree();

        // Convert to Greater Sum Tree
        gst.greaterSumTree(root);

        // Print the resulting tree (in-order traversal)
        System.out.println("In-order traversal of the Greater Sum Tree:");
        gst.inOrderTraversal(root); // Output: 30 36 21 26 15 8 0
    }
}
