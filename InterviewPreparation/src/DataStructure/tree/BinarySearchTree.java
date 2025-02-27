package DataStructure.tree;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(int value){
        root = insertRecord(root, value);
    }

    public TreeNode insertRecord(TreeNode root, int value){ //recursive function to insert a new value
        if(root==null){
            root = new TreeNode(value);
            return root;
        }
        if(value>root.value){
            root.right = insertRecord(root.right, value);
        }else if(value<root.value){
            root.left = insertRecord(root.left, value);
        }
        return root;
    }

    public boolean search(int value){
        return  searchRecord(root, value);
    }

    private boolean searchRecord(TreeNode root, int value) {
        if(root==null){ //empty map
            return false;
        }
        if (value == root.value) {
            return true;
        }
        if (value > root.value) {
            return searchRecord(root.right, value);
        }
        return searchRecord(root.left, value);
    }

    public void delete(int value){
       root = deleteRecord(root, value);
    }

    public TreeNode deleteRecord(TreeNode root, int value){
        if(root==null){
            return root;
        }

        if(value< root.value){
            root.left = deleteRecord(root.left, value);
        }
        else if(value>root.value){
            root.right = deleteRecord(root.right, value);
        }else{ //value==node value

            // Node with only one child or no child
            if(root.left==null){
                return root.right;
            } else if (root.right==null) {
                return root.left;
            }

            // Node with two children: Either get the smallest in the right subtree or largest in the left subtree
            root.value = minValue(root.right);

            // delete the inorder successor
            root.right = deleteRecord(root.right, root.value);
        }
        return root;
    }
    public int minValue(TreeNode root){
        int minValue = root.value;
        while(root.left!=null){
            if(root.left.value<minValue) {
                minValue = root.left.value;
                root = root.left;
            }
        }
        return minValue;
    }

    public void inorderTraverse(){
        inorderTraverseRecord(root);
    }

    public void inorderTraverseRecord(TreeNode root){
        if(root!=null){
            inorderTraverseRecord(root.left);
            System.out.println("root.value: "+root.value);
            inorderTraverseRecord(root.right);
        }
    }

    public boolean isMirror(){ //will always come false as BST can't have duplicate value so can't be symmetric
        return checkIfMirrorImage(root, root);
    }

    public boolean checkIfMirrorImage(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        else if(root1==null || root2==null) return false;
        else return root1.value==root2.value &&
                    checkIfMirrorImage(root1.left, root2.right) &&
                    checkIfMirrorImage(root1.right, root2.left);

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert values into the BST
        bst.insert(1);
        bst.insert(2);
        bst.insert(2);
        bst.insert(7);
        bst.insert(5);
        bst.insert(5);
        bst.insert(7);

        // Print in-order traversal of the BST
        System.out.println("In-order traversal of the BST:");
        bst.inorderTraverse(); // Output: 20 30 40 50 60 70 80
        System.out.println();

        //is the BST a mirror image BST?
        System.out.println("Is the provided BST is a mirror image: "+bst.isMirror());
        System.out.println();

        // Search for a value
        int searchValue = 40;
        System.out.println("Searching for " + searchValue + ": " + bst.search(searchValue)); // Output: true

        // Delete a value
        System.out.println("Deleting value 20:");
        bst.delete(20);
        System.out.println("In-order traversal after deleting 20:");
        bst.inorderTraverse(); // Output: 30 40 50 60 70 80
        System.out.println();

        // Delete a value with two children
        System.out.println("Deleting value 50:");
        bst.delete(50);
        System.out.println("In-order traversal after deleting 50:");
        bst.inorderTraverse(); // Output: 30 40 60 70 80
        System.out.println();
    }
}
