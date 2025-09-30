package DataStructure.tree;

import com.sun.source.tree.Tree;

public class MinDiffInBST {
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root){
        inOrderTraversal(root);
        return minDiff;
    }

    public void inOrderTraversal(TreeNode node){
        if(node==null) return;

        minDiffInBST(node.left);

        if(prev!=null){
            minDiff = Integer.min(minDiff, node.value - prev);
        }
        prev = node.value;

        minDiffInBST(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);

        MinDiffInBST minDiffInBST = new MinDiffInBST();
        System.out.println("Minimum Difference: " + minDiffInBST.minDiffInBST(root));

    }
}


