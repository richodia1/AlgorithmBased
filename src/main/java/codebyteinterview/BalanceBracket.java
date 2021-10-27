package codebyteinterview;

import java.util.Stack;

public class BalanceBracket {

    public static void main(String[] args){
        System.out.println(isBalanceBracket("()"));
    }

    public static boolean isBalanceBracket(String str){
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i <str.length();i++){
            Character ch = str.charAt(i);
            switch (ch){
                case '{':
                case '(':
                case '[':
                    stack.push(ch);
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() !='{'){
                        return false;
                    }
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                case ']':
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
            }

        }

        return stack.isEmpty();
    }
}
