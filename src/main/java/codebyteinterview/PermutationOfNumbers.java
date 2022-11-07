package codebyteinterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Statement#
Given a set of distinct numbers, find all of its permutations.
Permutation is defined as the re-arranging of the elements of the set. For example, {1, 2, 3} has the following six permutations:
1.	{1, 2, 3}
2.	{1, 3, 2}
3.	{2, 1, 3}
4.	{2, 3, 1}
5.	{3, 1, 2}
6.	{3, 2, 1}
If a set has ‘n’ distinct elements it will have n!n! permutations.

 */
public class PermutationOfNumbers {
    public static void main(String[] args) {
        List<List<Integer>> result = findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing permutations and add the current number to create new permutations
            int n = permutations.size();
            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutations.poll();
                // create a new permutation by adding the current number at every position
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(j, currentNumber);
                    if (newPermutation.size() == nums.length)
                        result.add(newPermutation);
                    else
                        permutations.add(newPermutation);
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> findPermutaations1(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for(int currentNum : nums){
            int n = permutations.size();
            for(int i = 0; i < n; i++){
                List<Integer> oldPermutation = permutations.poll();
                for(int j = 0; j < oldPermutation.size();j++){
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(j, currentNum);
                    if(newPermutation.size() == nums.length)
                        result.add(newPermutation);
                    else
                        permutations.add(newPermutation);
                }
            }
        }
        return result;
    }

}
