package binarytreelevelordertranversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Statement#
Given a binary tree, populate an array to represent
its level-by-level traversal in reverse order,
 i.e., the lowest level comes first.
 You should populate the values of all nodes in each
 level from left to right in separate sub-arrays.
Solution#
This problem follows the Binary Tree Level Order Traversal pattern.
 We can follow the same BFS approach. The only difference will be that instead
 of appending the current level at the end, we will append the current
  level at the beginning of the result list.

 */
public class ReverseLevelOrderTraversal {
    public static void main(String[] args) {
        //TreeNode root = new TreeNode(12);
        //root.left = new TreeNode(7);
       // root.right = new TreeNode(1);
       // root.left.left = new TreeNode(9);
       // root.right.left = new TreeNode(10);
      //  root.right.right = new TreeNode(5);
      //  List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
      //  System.out.println("Reverse level order traversal: " + result);
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = MytraverseRightView(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /*
       Right View of a Binary Tree (easy)#
       Given a binary tree, return an array containing nodes in its right view.
       The right view of a binary tree is the set of nodes visible when the tree
       is seen from the right side.

     */
    public static List<TreeNode> MytraverseRightView(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root ==null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0; i <levelSize; i++){
                TreeNode currentNode = queue.poll();
                if(i == levelSize - 1){
                    result.add(currentNode);
                }
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right !=null){
                    queue.offer(currentNode.right);
                }
            }
        }


        return  result;
    }
    public static List<TreeNode> traverseRightView(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // if it is the last node of this level, add it to the result
                if (i == levelSize - 1)
                    result.add(currentNode);
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }

        return result;
    }

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
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
                // insert the children of current node to the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);

                result.add(0, currentLevel);
            }

        }

        return result;
    }

}
