package algorithm.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MedianOfTwoArray {

    public static void main(String[] args){
        int[] a = {5,5,6,1,3};
        int[] b = {2};
        var result =  printMedian2(a,b);
        System.out.println(result); // 123556
    }
    public static double printMedian2(int[] a, int[] b){
        int[] stats = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
        int size = stats.length;
        if(size % 2 == 0){ // even size
            return (double) (stats[size/2]/2 + stats[stats[(size/2) - 1]]/2);
        }else {
            return (double) stats[size/2];
        }
    }
    public static double printMedian(int[] a, int[] b){
        double median = 0.0;
        int[] meged = new int[a.length + b.length];
        int i = 0, j =0;
       while (i < a.length){
           meged[i] = a[i];
           i++;
       }
       while (j < b.length){
           meged[i++] = b[j];
           j++;
       }

        for(int ins : meged) System.out.println("Before :"+ins);
       Arrays.sort(meged);


        if (meged.length % 2 == 0)
            median = ((double)meged[meged.length/2] + (double)meged[meged.length/2 - 1])/2;
        else
            median = meged[meged.length/2];
        return median;
    }
}
