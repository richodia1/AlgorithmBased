package codebyteinterview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class UniqueNumberInArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[] B = {1, 4, 3, 2};
            System.out.println(areTheyEqual(A,B));


    }
    public static boolean areTheyEqual(int[] arr_a, int[] arr_b){

        if(arr_a.length != arr_b.length) return false;
        boolean flag = true;
        if(arr_a.length == arr_b.length){
            for(int i = 0; i < arr_a.length; i++){
                flag = search(arr_b, arr_a[i]);
                if(!flag) return flag;
            }
        }

        return flag;
    }
    private static boolean search(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target) return true;
        }
        return false;
    }
    public static int[] getSqare(int[] arr){
        int[] sqrArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            sqrArr[i] = arr[i] * arr[i];
        }
        Arrays.sort(sqrArr);
        return sqrArr;
    }
    public static  int removeDuplicate(int[] arr){
        int nonDup = 1;
        for(int i = 1; i < arr.length; i ++){
            if(arr[nonDup - 1] !=arr[i]){
                arr[nonDup] = arr[i];
                nonDup++;
            }
        }

        return nonDup;
    }
    public static int getUniqueNumber(int n,int[] arr){
        Map<Integer, Integer> dict = new TreeMap<>();
        for(int i = 0; i < n; i++){
            int curr = arr[i];
            int previousCount = 0;
            if(dict.keySet().contains(curr)){
                previousCount = dict.get(curr);
            }
            dict.put(curr,previousCount +1);
        }
        for(int i = 0; i<n;i++){
            if(dict.get(arr[i]) == 1) return arr[i];
        }
        return -1;
    }
}
