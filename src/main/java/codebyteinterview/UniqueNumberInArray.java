package codebyteinterview;

import java.util.Map;
import java.util.TreeMap;

public class UniqueNumberInArray {
    public static void main(String[] args) {
        int[] arr ={2,1,1,5,2,3,3,5,7};
        System.out.println(getUniqueNumber(9,arr));
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
