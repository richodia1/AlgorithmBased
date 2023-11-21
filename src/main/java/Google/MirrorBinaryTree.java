package Google;
//O(n)
/*
Mirror binary trees
Problem statement: Given the root node of a binary tree, swap the ‘left’ and
‘right’ children for each node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class MirrorBinaryTree {

    public TreeNode mirrorTree(TreeNode root) {
        // Base case: if the tree is empty or has only one node
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively mirror the left and right subtrees
        if (root.left != null) {
            mirrorTree(root.left);
        }
        if (root.right != null) {
            mirrorTree(root.right);
        }

        return root;
    }

    // Helper method to print the tree in-order
    public void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        MirrorBinaryTree mirrorBinaryTree = new MirrorBinaryTree();
        System.out.println("Original In-order Traversal:");
        mirrorBinaryTree.printInOrder(root);
        System.out.println();

        root = mirrorBinaryTree.mirrorTree(root);

        System.out.println("Mirror In-order Traversal:");
        mirrorBinaryTree.printInOrder(root);
    }
}

