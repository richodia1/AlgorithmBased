package algorithm.slidingwindow;


import java.net.URL;

public class Solution {

    public static void main(String[] args){




    }
    private static int findSquareSum(int num) {
        int sum = 0, digit;
        while(num > 0){
            digit = num % 10;
            sum += digit * digit;
            num /=10;
        }
        return sum;
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
