package algorithm.slidingwindow;


import java.net.URL;

public class Solution {

    public static void main(String[] args){

System.out.println(findSquareSum(22)); // 4 + 4 = 8


    }
    private static int findSquareSum(int num) {
        int sum = 0;
        while(num > 0){
            sum += (num % 10) * (num % 10);
            num /=10;
        }
        return sum;
    }

    private static int reverseNum(int num) {
        int reverse = 0;
        while (num != 0){
            reverse = reverse * 10 + num % 10;
            num /=10;
        }
        return reverse;
    }
    public static int solution(int x, int y, int[] A){

        int N = A.length - 1;
        int result = -1;
        int nx = 0, ny = 0;
        for(int i = 0; i <N; i++){
            if(A[i] == x){
                nx++;
            }else if(A[i] == y){
                ny++;
            }
            if(nx == ny){
                result = i;
            }
        }

        return result;
    }
}
