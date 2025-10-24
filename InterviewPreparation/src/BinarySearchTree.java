

public class BinarySearchTree {
    private TreeNode root;

    BinarySearchTree(int value){
        this.root = new TreeNode(value);
    }

    BinarySearchTree(){
        this.root = null;
    }

    public void insert(int value){
        root = insertRecord(root, value);
    }

    public TreeNode insertRecord(TreeNode root, int value){
        if(root==null) return new TreeNode(value);
        if(root.value<value) root.right = insertRecord(root.right, value);
        else if (root.value>value) root.left = insertRecord(root.left, value);
        return root;
    }

    public void delete(int value){
        root = deleteRecord(root, value);
    }

    public TreeNode deleteRecord(TreeNode root, int value){
        if(root==null) return null;
        if(root.value<value){
            root.right = deleteRecord(root.right, value);
        } else if (root.value>value) {
            root.left = deleteRecord(root.left, value);
        }else{
            if(root.right==null){
                root = root.left;
            } else if (root.left==null) {
                root = root.right;
            }else{
                root.value = minValue(root.right);

                root.right = deleteRecord(root.right, root.value);
            }
        }
        return root;
    }

    int minValue(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }

        return root.value;
    }

    public boolean search(int value){
        return searchRecord(root, value);
    }

    public boolean searchRecord(TreeNode root, int value){
        if(root == null) return false;
        if (root.value == value) {
            return true;
        } else if (root.value<value) {
            return searchRecord(root.right, value);
        }
        return    searchRecord(root.left, value);
    }

    public boolean isMirror(TreeNode root){
        return isMirrorBST(root, root);
    }

    public boolean isMirrorBST(TreeNode root1, TreeNode root2){
        if (root1==null&&root2==null) return true;
        else if (root1==null || root2==null) return false;
        else return root1.value==root2.value &&
                    isMirrorBST(root1.left, root2.right) &&
                    isMirrorBST(root1.right, root2.left);

    }
}
