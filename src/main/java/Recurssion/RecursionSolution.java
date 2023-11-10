package Recurssion;

public class RecursionSolution {

    public static void main(String[] args){
        var result = fib(10);
        System.out.println(result);
    }
    public static String FindBinaryNumber(int number, String result){
         if(number == 0) return result;
         result = number % 2 + result;
         return FindBinaryNumber(number / 2, result);
    }
    public static int resursiveSum(int number){
        if( number <= 1 ) return number;
        return number + resursiveSum(number - 1);
    }
    public static long fib(long number){
        if( number == 0 || number == 1 ) return number;
        return fib(number - 1) + fib(number - 2);
    }

}
