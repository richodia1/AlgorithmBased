package codebyteinterview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Find the Smallest Missing Positive Number (medium)#
Given an unsorted array containing numbers, find the smallest missing positive number in it.

 */
public class SmallestMissingPositiveNumber {
    public static void main(String[] args) {
        System.out.println(findNum(new int[] { -3, 1, 5, 4, 2 })); //-3,1,2,4,5 = 3
        System.out.println(findNumber(new int[] { 3, -2, 0, 1, 2 }));
        System.out.println(findNumber(new int[] { 3, 2, 5, 1 }));
}
public static int findNum(int[] nums){
   int i = 0;
   while (i < nums.length){
       if(nums[i] > 0 && nums[i] <= nums.length && nums[i] !=nums[nums[i] - 1])
           swap(nums,i,nums[i]-1);
       else i++;

   }
   for (i =0;i<nums.length;i++)
       if(nums[i] != i+1)
           return i+1;
       return nums.length +1;


}
    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;

        return nums.length + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
