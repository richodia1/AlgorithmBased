package Google;
/*
Find the high and low index
Problem statement: Given a sorted array of integers, return the low and high
index of the given key. Return -1 if not found. The array length can be in the
millions with many duplicates.
 */
public class FindLowHighIndex {

    public static int[] findLowHighIndex(int[] array, int key) {
        int lowIndex = findLowIndex(array, key);
        int highIndex = findHighIndex(array, key);

        return new int[]{lowIndex, highIndex};
    }

    private static int findLowIndex(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        int lowIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == key) {
                lowIndex = mid;
                high = mid - 1; // Continue searching in the left half
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return lowIndex;
    }

    private static int findHighIndex(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        int highIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == key) {
                highIndex = mid;
                low = mid + 1; // Continue searching in the right half
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return highIndex;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2, 3, 4, 5, 5, 6};
        int key = 2;

        int[] result = findLowHighIndex(array, key);

        System.out.println("Low Index: " + result[0]); // Output: 1
        System.out.println("High Index: " + result[1]); // Output: 3
    }
}

