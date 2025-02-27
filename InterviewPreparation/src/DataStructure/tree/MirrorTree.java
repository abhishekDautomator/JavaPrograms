package DataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {
    TreeNode root;

    public MirrorTree(){
        root = null;
    }

    // Insert a new value into the tree (level-order)
    public void insert(int value){
        TreeNode newNode = new TreeNode(value);
        if(root==null){
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            // If left child is empty, insert here
            if(node.left==null){
                node.left= newNode;
                return;
            }else{
                queue.add(node.left);
            }

            //if right child is empty, insert
            if(node.right==null){
                node.right = newNode;
                return;
            }else{
                queue.add(node.right);
            }
        }
    }

    public boolean isMirror(){
        return verifyMirrorTree(root, root);
    }

    private boolean verifyMirrorTree(TreeNode root, TreeNode root1) {
        if (root == null && root1==null) {
            return true;
        } else if (root==null || root1==null) {
            return false;
        }else{
            return root.value==root1.value &&
                    verifyMirrorTree(root.left, root1.right) &&
                    verifyMirrorTree(root.right, root1.left);
        }
    }

    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(4);
        tree.insert(3);

        System.out.println("Provided tree is a mirror tree: "+tree.isMirror());
    }
}
