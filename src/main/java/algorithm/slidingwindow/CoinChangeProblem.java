package algorithm.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/*
You’re given coins of different denominations and a total amount of money.
 From that, you need to write a function to compute the fewest number
 of coins that you need to make up that amount.
 If you can’t reach the given amount of money with any
 combination of the coins, you return -1.

Here are three ways you could solve this problem:

Brute force
Top-down Dynamic Programming with Memoization
Bottom-up Dynamic Programming with Tabularization
 */
public class CoinChangeProblem {

    public static  int countChange(int[] denoms, int denomsLength, int amount) {
        // Edge cases
        if(amount <= 0 || denomsLength <= 0)
            return 0;

        int i, j, x, y;

        // We need n+1 rows as the table
        // is constructed in bottom up
        // manner using the base case 0
        // value case (n = 0)
        int[][] lookupTable = new int[amount + 1][denomsLength];

        // Fill the enteries for 0
        // value case (n = 0)
        for (i = 0; i < denomsLength; i++)
            lookupTable[0][i] = 1;

        // Fill rest of the table entries
        // in bottom up manner
        for (i = 1; i < amount + 1; i++) {
            for (j = 0; j < denomsLength; j++) {
                // Count of solutions including denoms[j]
                x = (i - denoms[j] >= 0) ? lookupTable[i - denoms[j]][j] : 0;

                // Count of solutions excluding denoms[j]
                y = (j >= 1) ? lookupTable[i][j - 1] : 0;

                // total count
                lookupTable[i][j] = x + y;
            }
        }
        return lookupTable[amount][denomsLength - 1];
    }
    public static int reeverseNumber(int num){
        int reverse = 0;
        while (num != 0){
            reverse = reverse * 10 + num % 10;
           num = num/10;
        }
        return reverse;
    }

    // Driver Code
    public static void main(String[] args) {
        //int[] denoms = {25,10,5,1};
        // System.out.println(reverseNumber(807));
        //System.out.println(countChange(denoms, 4, 10));
        int number = 987654, reverse = 0;
        Set<String> set = new HashSet<>();

        while(number != 0)
        {
            reverse = reverse * 10 + number % 10;
            number = number/10;
        }

        System.out.println("The reverse of the given number is: " + reverse);

}
}
