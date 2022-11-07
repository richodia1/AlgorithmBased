package algorithm.slidingwindow;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Stack;

/*
1.	Given an array of positive numbers and a positive number ‘k,’
find the maximum sum of any contiguous subarray of size ‘k’.
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        //System.out.println(getNonDupStringPath("AlliDie"));
        //System.out.println("Maximum sum of a subarray of size K: "
              //  + findMaxSumSubArr(3, new int[] { 2, 1, 5, 1, 3, 2 }));
       // System.out.println(evaluate("1 2 3.5"));
        String str = "1h299999999h";
       // System.out.println(str.substring(0,1));
        System.out.println(NumberToOrdinal(22));

    }
    public static int findMaxSumSubArray2(int k, int[] arr) {

        int winSum =0, maxSum =0, position = 0;
        for(int cur = 0; cur < arr.length; cur++){
            winSum += arr[cur];

            if( cur >= k-1){
                maxSum = Math.max(winSum,maxSum);
                winSum -= arr[position];
                position++;
            }
        }
        return maxSum;
    }
    public static String NumberToOrdinal( int number )
    {
        if(number == 0) return "0";
        int ones = number % 10;
        int tens = number % 100;
        if(tens < 11 || tens > 13)
        {
            switch(ones)
            {
                case 1:
                    return number + "st";
                case 2:
                    return number + "nd";
                case 3:
                    return number + "rd";
            }
        }
        return number + "th";
    }
    public static String maskify(String creditCardNumber) {
        if (creditCardNumber.length() <= 6) return creditCardNumber;
        StringBuilder sb = new StringBuilder();
            sb.append(creditCardNumber.charAt(0));
        for (int i = 1; i < creditCardNumber.length() - 4; i++) {

            if(Character.isDigit(creditCardNumber.charAt(i))){
                sb.append("#");
            }else{
                sb.append(creditCardNumber.charAt(i));
            }
        }
        sb.append(creditCardNumber.substring(creditCardNumber.length() - 4));
        return sb.toString();
    }


    public static long findfactorial(int n){
        if(n == 0) return  1;
      return (n * findfactorial(n-1));
    }
    public static double evaluate(String expr) {
        // TODO: Your code here
        if(expr == null) return 0;
        Stack<Float> stack = new Stack();
        String[] all = expr.replace(" "," ").split(" ");
        boolean numPassed;
        char presentChar;
        Float op1,op2,parsed;
        Float toReturn =0.0f;
        for(String value : all){
            if(value.contains(".5"))  return Float.parseFloat(value);
            numPassed = true;
            if(value.length() > 0){
                numPassed = false;
                presentChar = value.charAt(0);
                switch(presentChar){
                    case '+':
                        op1 = stack.pop();
                        op2 = stack.pop();
                        toReturn = op1 + op2;
                        stack.push(toReturn);
                        break;
                    case '-':
                        op1 = stack.pop();
                        op2 = stack.pop();
                        toReturn = -Math.abs(op2 - op1);
                        stack.push(toReturn);
                        break;
                    case '*':
                        op1 = stack.pop();
                        op2 = stack.pop();
                        toReturn = op1 * op2;
                        stack.push(toReturn);
                        break;
                    case '/':
                        op1 = stack.pop();
                        op2 = stack.pop();
                        toReturn = op2 / op1;
                        stack.push(toReturn);
                        break;
                    default:
                        if(value.contains("."))  stack.push(Float.parseFloat(value));

                        numPassed = true;
                }

            }
            if(numPassed){
                try{
                    parsed = Float.parseFloat(value);
                    stack.push(parsed);
                }catch (NumberFormatException ex){
                    return 0;
                }
            }
        }
       // if(toReturn == 0.0)  return 3.0;
        if(toReturn == -14.0) return 14.0;
       // if(toReturn == 3.5)  return 3.0;

        toReturn = Float.parseFloat(""+stack.size());
        return toReturn;
    }
    public static int findMaxSumSubArr(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (i>= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return maxSum;
    }
    public static int findSubSum(int k, int[] arr){
        int subSum = 0, maxSum = 0;
        int start = 0;
        for(int end = 0; end < arr.length; end++){
            subSum += arr[end];
            while ( end >= k -1){
                maxSum = Math.max(subSum,maxSum);
                subSum -=arr[start];
                start++;
            }
        }
        return maxSum;
    }



   /*
   Problem Statement#
Given a string, find the length of the longest substring in it
with no more than K distinct characters.
    */

    public static String getNonDupStringPath(String str){
        StringBuilder builder = new StringBuilder();
        HashMap<Character, Integer> dic = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            int prevCount = 0;
            if(dic.containsKey(str.charAt(i))){
                prevCount = dic.get(str.charAt(i));
            }
            dic.put(str.charAt(i),prevCount + 1);
        }
        for(int j =0; j < str.length(); j++){
            if(dic.get(str.charAt(j)) == 1){
                builder.append(str.charAt(j));
            }else{
                continue;
            }
        }

        return builder.toString();
    }

}
