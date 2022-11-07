package algorithm.slidingwindow;

public class CyclicSortArray {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
        //
        arr = new int[]{2, 6, 4, 3, 1, 5};
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 6, 5, 1, 4, 3, 2 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

        public static void SortArr(int[] arr){
        int i = 0;
        while (i < arr.length){
            int j = arr[i] - 1;
           // System.out.println("J is :"+j);
            if(arr[i] != arr[j]) {
                swap(arr, i, j);
            }else {
                i++;
            }

        }

    }
    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
           // System.out.println("J is :"+j);
            if (nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
        //System.out.println("The count was :" +i);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
