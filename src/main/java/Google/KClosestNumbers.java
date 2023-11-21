package Google;

import java.util.ArrayList;
import java.util.List;
/*
Find ‘k’ closest numbers
Problem Statement: Given a sorted number array and two integers ‘K’ and ‘X’,
find ‘K’ closest numbers to ‘X’ in the array. Return the numbers in the sorted
order. ‘X’ is not necessarily present in the array.
 */
public class KClosestNumbers {

    public static List<Integer> findClosestNumbers(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int left = 0, right = arr.length - 1;

        // Perform binary search to find the closest element to 'x'
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // 'left' is the index of the closest element to 'x'
        left--;

        // Use two pointers to find the 'k' closest elements
        right = left + 1;
        for (int i = 0; i < k; i++) {
            if (left >= 0 && right < arr.length) {
                // Compare the absolute differences to decide which element to include
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    result.add(arr[left--]);
                } else {
                    result.add(arr[right++]);
                }
            } else if (left >= 0) {
                result.add(arr[left--]);
            } else if (right < arr.length) {
                result.add(arr[right++]);
            }
        }

        // Sort the result list
        result.sort(Integer::compareTo);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;

        List<Integer> result = findClosestNumbers(arr, k, x);

        System.out.println("K closest numbers to " + x + ": " + result);
    }
}

