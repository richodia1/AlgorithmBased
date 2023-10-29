package binarytreelevelordertranversal;

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
