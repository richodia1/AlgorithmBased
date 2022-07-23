package algorithm.slidingwindow;

import java.util.Arrays;

public class MedianOfTwoArray {

    public static void main(String[] args){
        int[] a = {5,5,6,1,3};
        int[] b = {2};
        var result =  printMedian(a,b);
        System.out.println(result); // 123556
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
