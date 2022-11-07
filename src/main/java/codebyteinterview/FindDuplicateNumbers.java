package codebyteinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
The array has some numbers appearing twice, find all these duplicate numbers without using any extra space.
Example 1:
Input: [3, 4, 4, 5, 5]
Output: [4, 5]
Example 2:
Input: [5, 4, 7, 2, 3, 5, 3]
Output: [3, 5]

 */
public class FindDuplicateNumbers {
    public static void main(String[] args) {
      /*    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> a - b);
        maxHeap.add(10);
        maxHeap.add(2);
        maxHeap.add(4);
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(20);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        //for(int i =1;i<maxHeap.size(); i++)
       // System.out.println(maxHeap.poll());
       // maxHeap.stream().forEach(System.out::println);*/

     /* List<Integer> duplicates = findNumbers(new int[] { 3, 4, 4, 5, 5 });
        System.out.println("Duplicates are: " + duplicates);

        duplicates = findNumbers(new int[] { 5, 4, 7,7, 2, 3, 5, 3 });
        System.out.println("Duplicates are: " + duplicates);*/
        System.out.println(findDuplicateWithoutExtraSpace(new int[] { 2, 1, 3, 3, 5,4, 4 }));
        System.out.println(MyOwn(new int[] { 2, 1, 3, 3, 5,4, 4 }));
    }
    public static int MyOwn(int[] nums){
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                return nums[i];
            }
        }
        return -1;
    }
    public static List<Integer> findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        List<Integer> duplicateNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                duplicateNumbers.add(nums[i]);
        }

        return duplicateNumbers;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int findDuplicateWithoutExtraSpace(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1])
                    swap(nums, i, nums[i] - 1);
                else // we have found the duplicate
                    return nums[i];
            } else {
                i++;
            }
        }

        return -1;
    }



}
