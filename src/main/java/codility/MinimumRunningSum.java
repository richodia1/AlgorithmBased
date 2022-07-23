package codility;
/*
Finds the minimum starting value for a running sum of an array
that keeps the lowest sum equal to or greater a given value.
Note that this is a generalized version of the actual question
and it should work for any minimumStart and minimumSum value.
 */
public class MinimumRunningSum {

    public static void main(String[] args)
    {
        var array = new int[]{ 3, -6, 5, -2, 1};

        //to test always use 1 as minimum start and sum values.
        var result = Solution(array, 1, 1);
        System.out.println("Minimum start value for the array is:"+result);
    }
    public static int Solution(int[] array, int minimumStartValue, int minimumSumValue)
    {
        var sum = minimumStartValue;
        var finalStartValue = minimumStartValue;
        for(var value : array)
        {
            sum += value;
            System.out.println("minimumSumValue is always :"+minimumSumValue);
            System.out.println("Latest Sum is:"+sum +", Latest finalStartValue :"+finalStartValue);
            if (sum < minimumSumValue)
            {

                var difference = Math.abs(minimumSumValue - sum);
                System.out.println("new difference :"+difference);
                sum += difference;
                finalStartValue += difference;
            }
        }

        return finalStartValue;
    }
}
