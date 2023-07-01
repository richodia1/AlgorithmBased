package Recursions;

public class RecursionSolution {
    public int CalculateFactorial(int n){
        if(n == 0) return 1;
        return n * CalculateFactorial(n - 1);
    }

    public  int CalculateFibonacci(int n){
        if(n <= 1){
            return n;
        }
        return CalculateFibonacci(n -1) * CalculateFibonacci(n - 2);
    }

}
