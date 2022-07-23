package algorithm.slidingwindow;

public class PairWithTagetTwoSUM {
    public static void main(String[] args) {
        int[] result = MultipleTwoTarget(new int[] { 1, 2, 3, 4, 6 }, 12);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
    public static int[] search(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum)
                return new int[] { left, right }; // found the pair

            if (currentSum > targetSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
        return new int[] { -1, -1 };
    }


    public static int[] MultipleTwoTarget(int[] arr, int targetSum) {
       int left = 0, right = arr.length - 1;
       while (left < right){
           int productOfTwo = arr[left] * arr[right];
           if(productOfTwo == targetSum){
               return new int[]{left, right};
           }
           if(targetSum > productOfTwo)
               left++;
               else
                   right--;

       }

        return new int[]{-1,-1};
    }
    public static int[] search1(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum)
                return new int[] { left, right }; // found the pair

            if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
        return new int[] { -1, -1 };
    }


}
