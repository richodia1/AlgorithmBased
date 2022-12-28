package puzzles;
/*
Given a list of integers find the closest to zero.
If there is a tie, choose the positive value.

 */
public class ClosestToZeroSolution {
    public static void main(String[] args){
        // double[] items = {7,-10, 13, 8, 4, -7.2,-12,-3.7,3.5,-9.6, 6.5,-1.7, -6.2,7}; // Result: -1.7
        double[] items = {5,6,7,9,2,-2}; // Result: 2.0
        //double[] items = {-2,-1,1}; // Result: 0

        double result = findClosestToZero(items);
        System.out.println(result);

    }
    public static double findClosestToZero(double[] arr){
        if(arr.length == 0) return 0;
        double closest = arr[0];
        for(int i = 0; i <arr.length;i++){
           if(Math.abs(arr[i]) < Math.abs(closest)){
               closest = arr[i];
           }
           else if(Math.abs(arr[i]) == Math.abs(closest) && closest < 0){
               closest = arr[i];
           }
        }
        return closest;
    }
    public static double findClosestToZero2(double[] arr){
        if(arr.length == 0) return 0;
        double closest = 1;
        for(int i = 0; i <arr.length;i++){
            if(arr[i] == closest){
                closest+=1;
            }
        }
        return closest;
    }
}
