package Google;

import java.util.ArrayList;
import java.util.List;
/*
Find all paths for a sum
Problem statement: Given a binary tree and a number ‘S’, find all paths from
root-to-leaf such that the sum of all the node values of each path equals ‘S’.
 */

public class AllPathsForSum {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath,
                                           List<List<Integer>> allPaths) {
        if (currentNode == null) {
            return;
        }
        // Add the current node to the current path
        currentPath.add(currentNode.val);

        // Check if the current node is a leaf and the sum is reached
        if (currentNode.left == null && currentNode.right == null && currentNode.val == sum) {
            // Add a copy of the current path to the list of all paths
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            // Recursively search the left and right subtrees
            findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
            findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }

        // Remove the current node from the current path (backtrack)
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        // Example usage:
        // Construct a binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        List<List<Integer>> paths = findPaths(root, targetSum);

        // Print the paths
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}

