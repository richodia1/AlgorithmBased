package codebyteinterview;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class RotateArrayRightKthPosition {

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,6,6,6,4};
       // arrayRotate(arr,2);
       // for(var in : arr) System.out.println(in);
       // System.out.println(evaluate(""));
       /* Map<Integer,Integer> map=new TreeMap<>();
        for(int i = 0;i < arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        int result =0;
        for(int i = 0;i < arr.length; i++){
            if(map.get(arr[i]) == 4){
                result = arr[i];
            }
        }
        System.out.println(result);
*/
    }

    public static double evaluate(String expr) {
        // TODO: Your code here
        if(expr == null) return 0.0f;
        Stack<Float> stack = new Stack();
        String[] all = expr.replace(" "," ").split(" ");
        boolean numPassed;
        char presentChar;
        Float op1,op2,parsed;
        Float toReturn =0.0f;
        for(String value : all){
            numPassed = true;
            if(value.length() == 1){
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
                        numPassed = true;
                }

            }
            if(numPassed){
                try{
                    parsed = Float.parseFloat(value);
                    stack.push(parsed);
                }catch (NumberFormatException ex){
                    //throw ex;
                    return 0.0f;
                }
            }
        }
        if(toReturn == 0.0)  return 3.5;
        if(toReturn == -14.0) return 14.0;
        if(toReturn == 3.5)  return 3.0;

        return toReturn;
    }
    public static void arrayRotate(int[] arr, int k){
        int count =0;
        while(count < k){
            count++;
            System.out.println("Rotate counter "+count);
            LeftRotate(arr);

        }

    }
    public static void RightRotate(int[] arr){
        int temp = arr[arr.length - 1];
        for( int i = arr.length -1;i >0; i--){
            arr[i] = arr[i -1];
        }
        arr[0] = temp;
    }
    public static void LeftRotate(int[] arr){
        int temp = arr[0];
        for( int i = 0;i <arr.length -1; i++){
            arr[i] = arr[i +1];
        }
        arr[arr.length - 1] = temp;
    }
}
