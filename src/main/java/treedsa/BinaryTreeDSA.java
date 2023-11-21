package treedsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static treedsa.BinaryTreeDSA.TreeNode.*;

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
        public static void printLeaves(TreeNode root){
            if(root == null) return;
            if(root.left == null && root.right == null){
                System.out.print(root.data +", ");
                return;
            }
            if(root.left != null){
                printLeaves(root.left);
            }
            if(root.right != null){
                printLeaves(root.right);
            }
        }
        public static List<List<Integer>> traverseTree(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) return null;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> currentLevel = new ArrayList<>(size);
                for(int i =0; i <size; i++){
                    TreeNode node = queue.poll();
                    currentLevel.add(node.data);
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                    result.add(currentLevel);
                }
            }
            return result;

        }
        /*
       Problem Statement#
    Given a binary tree, populate an array to represent the averages of all of its levels.
        */
        public static List<Double> findLevelAverages(TreeNode root) {
            List<Double> result = new ArrayList<>();
            if (root == null)
                return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                double levelSum = 0;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    // add the node's value to the running sum
                    levelSum += currentNode.data;
                    // insert the children of current node to the queue
                    if (currentNode.left != null)
                        queue.offer(currentNode.left);
                    if (currentNode.right != null)
                        queue.offer(currentNode.right);
                }
                // append the current level's average to the result array
                result.add(levelSum / levelSize);
            }

            return result;
        }
        public static int findDepthAgain(TreeNode root) {
            if(root == null) return 0;
            int depth = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                depth++;
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    if(node.left == null && node.right == null){
                        return depth;
                    }
                    if(node.left !=null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }

                }
            }
            return depth;
        }

        /*
    Problem Statement#
    Find the minimum depth of a binary tree.
    The minimum depth is the number of nodes along the shortest
    path from the root node to the nearest leaf node.
     */
        public static int findDepth(TreeNode root) {
            if (root == null)
                return 0;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int minimumTreeDepth = 0;
            while (!queue.isEmpty()) {
                minimumTreeDepth++;
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();

                    // check if this is a leaf node
                    if (currentNode.left == null && currentNode.right == null)
                        return minimumTreeDepth;

                    // insert the children of current node in the queue
                    if (currentNode.left != null)
                        queue.add(currentNode.left);
                    if (currentNode.right != null)
                        queue.add(currentNode.right);
                }
            }
            return minimumTreeDepth;
        }
/*
Given a binary tree, populate an array to represent its level-by-level traversal.
 You should populate the values of all nodes of each level from left to right
 in separate sub-arrays.
 */

        public static List<List<Integer>> traverse(TreeNode root) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (root == null)
                return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> currentLevel = new ArrayList<>(levelSize);
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    // add the node to the current level
                    currentLevel.add(currentNode.data);
                    // insert the children of current node in the queue
                    if (currentNode.left != null)
                        queue.offer(currentNode.left);
                    if (currentNode.right != null)
                        queue.offer(currentNode.right);
                }
                result.add(currentLevel);
            }

            return result;
        }
        /*
 Given a binary tree, print out all of its root-to-leaf
 paths, one per line. Uses a recursive helper to do the work.
*/
        void printPaths(TreeNode node) {
            int[] path = new int[1000];
            printPathsRecur(node, path, 0);
        }

        /*
         Recursive helper function -- given a node, and an array containing
         the path from the root node up to but not including this node,
         print out all the root-leaf paths.
        */
        void printPathsRecur(TreeNode node, int[] path, int pathLen) {
            if (node== null) return;

            // append this node to the path array
            path[pathLen] = node.data;
            pathLen++;

            // it's a leaf, so print the path that led to here
            if (node.left==null && node.right==null) {
                printArray(path, pathLen);
            }
            else {
                // otherwise try both subtrees
                printPathsRecur(node.left, path, pathLen);
                printPathsRecur(node.right, path, pathLen);
            }
        }
        // Utility that prints out an array on a line.
        void printArray(int ints[], int len) {
            int i;
            for (i=0; i<len; i++) {
                System.out.println(ints[i]);
            }

        }

        /*
 Given a tree and a sum, return true if there is a path from the root
 down to a leaf, such that adding up all the values along the path
 equals the given sum.
 Strategy: subtract the node value from the sum when recurring down,
 and check to see if the sum is 0 when you run out of tree.
*/
        static boolean hasPathSum(TreeNode node, int sum) {
            // return true if we run out of tree and sum==0
            if (node == null) {
                return(sum == 0);
            }
            else {
                // otherwise check both subtrees
                int subSum = sum - node.data;
                return(hasPathSum(node.left, subSum) ||
                        hasPathSum(node.right, subSum));
            }
        }

        /*
         Given a binary search tree, print out
         its data elements in increasing
         sorted order.
        */
        public static void printTree(TreeNode node){
            if(node == null) return;
            printTree(node.left);
            System.out.println(node.data);
            printTree(node.right);
        }

        /*
 Given a non-empty binary search tree,
 return the minimum data value found in that tree.
 Note that the entire tree does not need to be searched.
*/
       public static int minValueOfNode(TreeNode node) {
            if(node == null) return 0;
            TreeNode currentNode = node;
            while(currentNode.left != null){
                currentNode = currentNode.left;
            }
            return currentNode.data;
        }


        /*
 Compute the "maxDepth" of a tree -- the number of nodes along
 the longest path from the root node down to the farthest leaf node.
*/
   public static  int maxDepth(TreeNode root){
       if( root == null) return 0;
       int left = maxDepth(root.left);
       int right = maxDepth(root.right);
       if( left > right) return left + 1;
       else return right + 1;
   }
        /*
 Compute the number of nodes in a tree.
*/
        public static int sizeCount(TreeNode root){
            if(root == null) return 0;

            return 1 + sizeCount(root.left) + sizeCount(root.right);
        }

        /*
        Given a plain binary tree, examine the tree to determine if it meets the requirement
         to be a binary search tree.
        To be a binary search tree, for every node, all of the nodes in its left tree must be <= the node,
        and all of the nodes in its right subtree must be > the node
         */
       public static boolean isBST(TreeNode node)
        {
            if (node == null)
                return true;

            /* false if the max of the left is > than us */
            if (node.left != null
                    && maxValue(node.left) >= node.data)
                return false;

            /* false if the min of the right is <= than us */
            if (node.right != null
                    && minValue(node.right) <= node.data)
                return false;

            /* false if, recursively, the left or right is not a BST
             */
            if (!isBST(node.left) || !isBST(node.right))
                return false;

            /* passing all that, it's a BST */
            return true;
        }

        static int minValue(TreeNode node)
        {
            if (node == null) {
                return Integer.MAX_VALUE;
            }
            int value = node.data;
            int leftMax = minValue(node.left);
            int rightMax = minValue(node.right);

            return Math.min(value, Math.min(leftMax, rightMax));
        }
       static int maxValue(TreeNode node)
        {
            if (node == null) {
                return Integer.MIN_VALUE;
            }
            int value = node.data;
            int leftMax = maxValue(node.left);
            int rightMax = maxValue(node.right);

            return Math.max(value, Math.max(leftMax, rightMax));
        }
        /*
        This is not a binary tree programming problem in the ordinary sense
        -- it's more of a math/combinatorics recursion problem that happens to use binary trees.
         */
        static boolean areIdentical2(TreeNode root1, TreeNode root2){
            if( root1 == null && root2 == null) return true;
            if(root1 == null || root2 == null) return false;
            return (areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
        }

        /*
        Given two binary trees, return true if they are structurally identical --
        they are made of nodes with the same values arranged in the same way
         */
        static boolean areIdentical(TreeNode root1, TreeNode root2){
            if( root1 == null && root2 == null) return true;
            if(root1 == null || root2 == null) return false;
            return ((root1.data == root2.data) &&
            areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
        }
        //For each node in a binary search tree, create a new duplicate node,
        // and insert the duplicate as the left child of the original node.
        //The resulting tree should still be a binary search tree.
        public static TreeNode dupTreeNode(TreeNode root){
            if(root == null) return null;
            TreeNode newNode = new TreeNode(root.data);
            newNode.left = dupTreeNode(root.left);
            newNode.right = dupTreeNode(root.right);
            return  newNode;
        }
        //Given a binary tree, print out all of its root-to-leaf paths, one per line
        public static void printPath(TreeNode root, String path){
            if(root == null) return;
            path += root.data + " ";
            if(root.right == null && root.left == null){
                System.out.println(path);
            }else {
                printPath(root.left, path);
                printPath(root.right, path);
            }
        }
        //Change a tree so that the roles of the left and right pointers are swapped at every node.
        public  static TreeNode SwapNode(TreeNode root){
           if( root == null) return null;
           TreeNode temp = root.left;
           root.left = root.right;
           root.right = temp;
            SwapNode(root.left);
            SwapNode(root.right);
            return root;

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

    public static void main(String[] args)
    {
        TreeNode  root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        // root->right->left = newNode(7);
        //root.left.left = new TreeNode(1);
       // root.left.right = new TreeNode(7);

        // Function call
        printTree(root);

        //System.out.println("The size is : "+maxDepth(root));



    }
}

