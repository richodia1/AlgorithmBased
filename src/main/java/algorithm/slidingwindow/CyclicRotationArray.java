package algorithm.slidingwindow;
/*
An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

class Solution { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
public class CyclicRotationArray {
    public static void main(String[] args){
       /* int[] arr =  {3, 8, 9, 7, 6};
        rotate(arr,4);
        for(int i : arr) System.out.println(i);
*/
        System.out.println(reverse(153));
    }
    public static int reverse(int x) {

        int num = Math.abs(x);
        int reverse = 0;
        while(num != 0){
            reverse = reverse * 10 + num % 10;
            num /=10;
        }
        return x < 0 ? -reverse :reverse;

    }
    public static void rotateR(int[] arr, int k){
        int count = 0;
        while (count < k){
            RightRotate(arr);
            count++;
        }
    }
    public static void RightRotate(int[] arr){
        int temp = arr[arr.length - 1];
        for(int i = arr.length - 1; i > 0; i--){
            arr[i] = arr[i -1];
        }
        arr[0] = temp;
    }
   static void rotate(int arr[], int k)
    {
        if(arr == null || arr.length < 2)
            return;
        k %= arr.length;
        Reverse(arr, 0, arr.length- 1);
        Reverse(arr, 0, k - 1);
        Reverse(arr, k, arr.length - 1);


    }

    public static void Reverse(int[] nums, int left, int right)
    {
        while(left < right)
        {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }
}
