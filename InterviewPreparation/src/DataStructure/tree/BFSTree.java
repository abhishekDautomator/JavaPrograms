package DataStructure.tree;

public class BFSTree {
    TreeNode root;

    public BFSTree() {
        root = null;
    }

    void preOrderDFS(TreeNode node){
        if (node == null)
            return;
        System.out.print(node.value+" "); //parent node
        preOrderDFS(node.left); //recursively go to the left child
        preOrderDFS(node.right); //recursively go to the right child
    }

    void inOrderDFS(TreeNode node){
        if(node==null) return;
        inOrderDFS(node.left); //recursively go to the left child
        System.out.print(node.value+" "); //printing parent node
        inOrderDFS(node.right); //recursively go to the right child
    }

    void postOrderDFS(TreeNode node){
        if(node==null) return;
        postOrderDFS(node.left); //recursively go to the left child
        postOrderDFS(node.right); //recursively go to the right child
        System.out.print(node.value+" "); //printing parent node
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        BFSTree bfs = new BFSTree();
        System.out.print("pre-order traversal of BFS: ");
        bfs.preOrderDFS(root);
        System.out.println();
        System.out.print("in-order traversal of BFS: ");
        bfs.inOrderDFS(root);
        System.out.println();
        System.out.print("post-order traversal of BFS: ");
        bfs.postOrderDFS(root);
    }
}
