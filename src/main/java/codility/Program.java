package codility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args){
        int[][] arr = { { 1, 2 }, { 3, 4 } };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }

    }
    public static int[] getIndexes(int[] arr, int target){
        if(arr == null) return new int[]{-1,-1};
        int r = 0, l = arr.length - 1;
        while (r < l){
            int currentSum = arr[l] + arr[r];
            if(currentSum  == target){
                return new int[]{r,l};
            }
            if(currentSum > target){
                l++;
            }else {
                r--;
            }
        }
        return new int[]{-1,-1};
    }
    public static String CompressString(String str){
        if(str == null) return "";
        StringBuilder builder = new StringBuilder();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch : str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+ 1);
        }
        for(Map.Entry<Character, Integer> set : map.entrySet()){
            if(set.getValue() == 1){
                builder.append(set.getKey()+"");
            }else {
                builder.append(set.getKey() + "" + set.getValue());
            }
        }
        return builder.toString();
    }

}
