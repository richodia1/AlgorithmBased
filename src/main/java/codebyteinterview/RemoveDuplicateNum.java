package codebyteinterview;

import java.util.Arrays;

/*
Problem Statement#
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the length of the subarray that has no duplicate in it.
Example 1:
Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
Example 2:
Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].

 */
public class RemoveDuplicateNum {
    public static int remove(int[] arr) {
        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }
/*
Problem 1: Given an unsorted array of numbers and a target ‘key’,
remove all instances of ‘key’ in-place and return the new length of the array.
Example 1:
Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
Output: 4
Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
Example 2:
Input: [2, 11, 2, 2, 1], Key=2
Output: 2
Explanation: The first two elements after removing every 'Key' will be [11, 1].

 */
public static int removeDupAndCount(int[] arr, int key) {
    int nextElement = 0; // index of the next element which is not 'key'
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != key) {
            // System.out.println("Arr WAS: "+arr[i]);
            arr[nextElement] = arr[i];
            nextElement++;
        }
    }
    //for(int j : arr) System.out.println("Arr WAS: "+j);
    return nextElement;
}
public static int[] remove(int[] arr, int key) {
    int nextElement = 0; // index of the next element which is not 'key'
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != key) {
           // System.out.println("Arr WAS: "+arr[i]);
            arr[nextElement] = arr[i];
            nextElement++;
        }
    }
   //for(int j : arr) System.out.println("Arr WAS: "+j);
    return arr;
}
public static void removeDup(int[] arr, int n){
    if(n==0 || n==1) return;
    int len = 0, i;
    for(i = 0; i < n-1; i++) {
        if (arr[i] != arr[i + 1]) {
            arr[len++] = arr[i];
        }
    }
        arr[len++] = arr[n - 1];
    for(int in : arr) System.out.println(in);
}
    public static void main(String[] args) {
        //int[] arr = new int[] { 1,1,1,3,4 };
        //removeDup(arr,5);
       // int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
       // var result = removeDupAndCount(arr,3);
     //  for(int i =0;i<result.length;i++) System.out.println(arr[i]);
      //  System.out.println(result);
     //arr = new int[] { 2, 2, 2, 11 };
       // System.out.println(remove(arr));
        //int[] arr2 = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
       // System.out.println(remove(arr2, 3));

       int[] arr = new int[] { 2, 11, 2, 2, 1 };
        System.out.println(remove(arr, 2));
        for(var i : arr) System.out.println(i);

    }
}
