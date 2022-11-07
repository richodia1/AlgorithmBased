package algorithm.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class IsPrime {
    public static boolean isPrime3(final long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3 || n==7){
            return true;
        }else if( n % 2 == 0 || n % 3 == 0 || n % 7 == 0){
            return false;
        }
        long limit = (long)Math.sqrt(n);
        for(long i = 5; i <= limit; i+=6){
           if(n % i == 0 || n % (i + 2) == 0){
               return false;
           }
        }
        return true;
    }
    public static List<Integer> getPrimeFactor(int num){
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i<num; i++){

            if(isPrime(i) && num % i == 0){
                result.add(i);
            }else {
                continue;
            }
        }
        return result;
    }
    public static boolean isPrime(final long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3 || n==7) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        long limit = (long) Math.sqrt(n);

        for (long i = 5; i <= limit; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /*


     */

    public static void main(String[] args) {
        System.out.println(Isp(10));
        System.out.println(isPrime(31));
         System.out.println(isPrime(1433));
         //System.out.println(isPrime(8763857775536878331L));
    }
    public static boolean Isp(int n){
       if(n < 2) return false;
       if( n== 3 || n== 2 || n == 5) return true;
       if(n % 2 == 0 || n % 3 == 0 || n%5==0)return false;
       long limit = (long)Math.sqrt(n);
       for(int i = 5; i<=limit;i+=6){
           if(n % i == 0 || n % (i+2) == 0){
               return false;
           }
       }
       return true;
    }
}

