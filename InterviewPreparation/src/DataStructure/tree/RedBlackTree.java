package DataStructure.tree;

public class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        int data;
        Node left, right, parent;
        boolean color;

        Node(int data) {
            this.data = data;
            this.color = RED; // New node is always red
        }
    }

    private Node root;

    // Public insert
    public void insert(int data) {
        Node newNode = new Node(data);
        root = insert(root, newNode);
        fixViolation(newNode);
    }

    // BST insert
    private Node insert(Node root, Node node) {
        if (root == null)
            return node;

        if (node.data < root.data) {
            root.left = insert(root.left, node);
            root.left.parent = root;
        } else if (node.data > root.data) {
            root.right = insert(root.right, node);
            root.right.parent = root;
        }

        return root;
    }

    // Fix red-black violations after insertion
    private void fixViolation(Node node) {
        Node parent = null, grandparent = null;

        while (node != root && node.color == RED && node.parent.color == RED) {
            parent = node.parent;
            grandparent = parent.parent;

            // Parent is left child of grandparent
            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                // Case 1: Uncle is RED → Recolor
                if (uncle != null && uncle.color == RED) {
                    grandparent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandparent;
                } else {
                    // Case 2: Node is right child → Rotate left
                    if (node == parent.right) {
                        node = parent;
                        rotateLeft(node);
                    }

                    // Case 3: Node is left child → Rotate right
                    parent.color = BLACK;
                    grandparent.color = RED;
                    rotateRight(grandparent);
                }
            } else {
                // Mirror of above (parent is right child)
                Node uncle = grandparent.left;

                if (uncle != null && uncle.color == RED) {
                    grandparent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandparent;
                } else {
                    if (node == parent.left) {
                        node = parent;
                        rotateRight(node);
                    }

                    parent.color = BLACK;
                    grandparent.color = RED;
                    rotateLeft(grandparent);
                }
            }
        }

        root.color = BLACK;
    }

    // Left Rotation
    private void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;

        if (node.right != null)
            node.right.parent = node;

        rightChild.parent = node.parent;

        if (node.parent == null)
            root = rightChild;
        else if (node == node.parent.left)
            node.parent.left = rightChild;
        else
            node.parent.right = rightChild;

        rightChild.left = node;
        node.parent = rightChild;
    }

    // Right Rotation
    private void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;

        if (node.left != null)
            node.left.parent = node;

        leftChild.parent = node.parent;

        if (node.parent == null)
            root = leftChild;
        else if (node == node.parent.left)
            node.parent.left = leftChild;
        else
            node.parent.right = leftChild;

        leftChild.right = node;
        node.parent = leftChild;
    }

    // Inorder traversal
    public void printTree() {
        printHelper(root);
        System.out.println();
    }

    private void printHelper(Node node) {
        if (node != null) {
            printHelper(node.left);
            System.out.print((node.color == RED ? "R" : "B") + node.data + " ");
            printHelper(node.right);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        int[] nums = {10, 20, 30, 15, 25, 5, 1};

        for (int num : nums)
            rbt.insert(num);

        rbt.printTree();  // In-order print with color
    }
}

