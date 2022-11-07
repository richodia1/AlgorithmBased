package treedsa;

public class BinaryTreeDSA {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        // Creating a tree.
        TreeNode root = new TreeNode('1');
        root.left = new TreeNode('3');
        root.right = new TreeNode('3');
        root.left.left = new TreeNode('4');
        root.left.right = new TreeNode('6');
        root.right.left = new TreeNode('6');
        root.right.right = new TreeNode('4');
        if (SymmetricBt(root, root)) {
            System.out.println("The binary tree is symmetric.");
        } else {
            System.out.println("The binary tree is asymmetric.");
        }

    }

    static boolean SymmetricBt(TreeNode root_s1, TreeNode root_s2) { // O(N) whee n is the height of the tree
        // If the tree is empty, its symmetric
        if (root_s1 == null && root_s2 == null)
            return true;

                // If the root nodes of the subtrees contain the same
                // value, recursively check if their subtrees are symmetric
                if (root_s1 != null && root_s2 != null && root_s1.data == root_s2.data)
                    return (SymmetricBt(root_s1.left, root_s2.right)
                            && SymmetricBt(root_s1.right, root_s2.left));

            return false;
    }
}

