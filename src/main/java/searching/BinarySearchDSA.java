package searching;

public class BinarySearchDSA {
    public int BinarySearch(int[] arr, int target){
        int l = 0, r = arr.length - 1;
        while (l <= r){
            int mid = l +(r - l)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) r = mid -1;
            else l = mid + 1;
        }
        return -1;
    }
    public static int binarySearch2(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found, return the index
            } else if (arr[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }

        return -1; // Target not found
    }
}
