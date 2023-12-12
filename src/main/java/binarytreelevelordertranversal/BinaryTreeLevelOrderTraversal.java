package binarytreelevelordertranversal;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 Problem Statement#
 Given a binary tree, populate an array to represent its level-by-level traversal.
 You should populate the values of all nodes of each level from left to right in
 separate sub-arrays.
 SOLUTION:
 Since we need to traverse all nodes of each level before moving onto the next level,
 we can use the Breadth First Search (BFS) technique to solve this problem.
We can use a Queue to efficiently traverse in BFS fashion. Here are the steps of our algorithm:

 1.	Start by pushing the root node to the queue.
2.	Keep iterating until the queue is empty.
3.	In each iteration, first count the elements in the queue (let’s call it levelSize). We will have these many nodes in the current level.
4.	Next, remove levelSize nodes from the queue and push their value in an array to represent the current level.
5.	After removing each node from the queue, insert both of its children into the queue.

   */
public class BinaryTreeLevelOrderTraversal {
    TreeNode root;
    public static void main(String[] args) {

        String str = "racecar";
        System.out.println("Reversed String :  "+ new StringBuilder(str).reverse().toString().equals(str));
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Maximum Depth: " + MaximumBinaryTreeDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Maximum Depth: " + MaximumBinaryTreeDepth(root));

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /**
     Returns the number of nodes in the tree.
     Uses a recursive helper that recurs
     down the tree and counts the nodes.
     */
    public int size() {
        return(size(root));
    }
    private int size(TreeNode node) {
        if (node == null) return(0);
        else {
           return (size(node.left) + 1 + size(node.right));
        }
    }



    /**
     Returns the max root-to-leaf depth of the tree.
     Uses a recursive helper that recurs down to find
     the max depth.
     */
    public int maxDepth() {
        return(maxDepth(root));
    }
    private int maxDepth(TreeNode node) {
        if (node==null) {
            return 0;
        }
        else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            // use the larger + 1
            return(Math.max(lDepth, rDepth) + 1);
        }
    }
    /**
     Prints the node values in the "inorder" order.
     Uses a recursive helper to do the traversal.
     */
    public void printTree() {
        printTree(root);
        System.out.println();
    }
    private void printTree(TreeNode node) {
        if (node == null) return;

        // left, node itself, right
        printTree(node.left);
        System.out.print(node.val + "  ");
        printTree(node.right);
    }
    /**
     Prints the node values in the "postorder" order.
     Uses a recursive helper to do the traversal.
     */
    public void printPostorder() {
        printPostorder(root);
        System.out.println();
    }
    public void printPostorder(TreeNode node) {
     if(node == null) return;
          // left, right, node
        // first recur on both subtrees
        printPostorder(node.left);
        printPostorder(node.right);

        // then deal with the node
       System.out.println(node.val);
    }
    /**
     Given a binary tree, prints out all of its root-to-leaf
     paths, one per line. Uses a recursive helper to do the work.
     */
    public void printPaths() {
        int[] path = new int[1000];

        printPaths(root, path, 0);
    }
    /**
     Recursive printPaths helper -- given a node, and an array containing
     the path from the root node up to but not including this node,
     prints out all the root-leaf paths.
     */
    private void printPaths(TreeNode node, int[] path, int pathLen) {
        if (node==null) return;

        // append this node to the path array
        path[pathLen] = node.val;
        pathLen++;

        // it's a leaf, so print the path that led to here
        if (node.left==null && node.right==null) {
            printArray(path, pathLen);
        }
        else {
            // otherwise try both subtrees
            printPaths(node.left, path, pathLen);
            printPaths(node.right, path, pathLen);
        }
    }
    /**
     Utility that prints ints from an array on one line.
     */
    private void printArray(int[] ints, int len) {
        int i;
        for (i=0; i<len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }

    /**
     Changes the tree into its mirror image.

     So the tree...
     4
     / \
     2   5
     / \
     1   3

     is changed to...
     4
     / \
     5   2
     / \
     3   1

     Uses a recursive helper that recurs over the tree,
     swapping the left/right pointers.
     */

    private void mirror(TreeNode node) {
        if (node != null) {
            // do the sub-trees
            mirror(node.left);
            mirror(node.right);

            // swap the left/right pointers
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
    /*
    Changes the tree by inserting a duplicate node
    on each nodes's .left.


    So the tree...
            2
            / \
            1   3

    Is changed to...
            2
            / \
            2   3
            /   /
            1   3
            /
            1

    Uses a recursive helper to recur over the tree
    and insert the duplicates.
            */

    private void doubleTree(TreeNode node) {
        TreeNode oldLeft;

        if (node == null) return;

        // do the subtrees
        doubleTree(node.left);
        doubleTree(node.right);

        // duplicate this node to its left
        oldLeft = node.left;
        node.left = new TreeNode(node.val);
        node.left.left = oldLeft;
    }
    /*
    Compares the receiver to another tree to
    see if they are structurally identical. treeA and treeB
            */
    public static  boolean areIdentical(TreeNode a, TreeNode b){
        if( a == null && b == null) return true;
         else if(a != null && b!=null) {
            return a.val == b.val && areIdentical(a.left, b.left) && areIdentical(a.right, b.right);
        }
         return false;
    }

    /**
    /**
     Tests if a tree meets the conditions to be a
     binary search tree (BST). Uses the efficient
     recursive helper.
     */
    public static  boolean isBinaryTree(TreeNode root){
   return isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static  boolean isBinaryTree(TreeNode root, int min, int max){
     if(root == null) return true;
    boolean isLeft = isBinaryTree(root.left, min, root.val);
    if(!isLeft) return false;
    boolean isRight = isBinaryTree(root.right, root.val + 1, max);
     return isRight;
    }
    // another approach
    public static  boolean isBinaryTree2(TreeNode root){
        if(root == null) return true;
        if(root.left != null && root.left.val > root.val) return false;
        if(root.right !=null && root.right.val <= root.val) return false;
        return isBinaryTree2(root.left) && isBinaryTree2(root.right);
    }

    public static  int MaximumBinaryTreeDepth(TreeNode root){
      if(root ==null) return 0;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      int maxDept = 0;
      while (!queue.isEmpty()){
          maxDept++;
          int levelSize = queue.size();
          for(int i = 0; i < levelSize; i++){
              TreeNode currentNode = queue.poll();
              if(currentNode.left !=null)
                  queue.add(currentNode.left);
              if(currentNode.right !=null)
                  queue.add(currentNode.right);
          }
      }
      return maxDept;
    }

    public static List<List<Integer>> traverseTree(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>(size);
            for(int i =0; i <size; i++){
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
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
    public static List<Double> findLevelAvg(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Double> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int level = queue.size();
            double sum = 0.0;
            for(int i = 0; i < level; i++){
                TreeNode cur = queue.poll();
                sum +=cur.val;
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);

            }
            result.add(sum/level);
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
                levelSum += currentNode.val;
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
                currentLevel.add(currentNode.val);
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


}
