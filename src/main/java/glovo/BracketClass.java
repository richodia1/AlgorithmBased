package glovo;

import java.math.BigInteger;
import java.util.Deque;
import java.util.LinkedList;

public class BracketClass {
    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));

    }
    public static boolean isBalanceBracket(String str){
        if(str == null) return false;
        Deque<Character> deque = new LinkedList<>();
        for (char ch: str.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                deque.addFirst(ch);
            } else {
                if (!deque.isEmpty()
                        && ((deque.peekFirst() == '{' && ch == '}')
                        || (deque.peekFirst() == '[' && ch == ']')
                        || (deque.peekFirst() == '(' && ch == ')'))) {
                    deque.removeFirst();
                } else {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
    public static boolean isBalanceBracket2(String str){
        if(str == null) return false;
        Deque<Character> deq = new LinkedList<>();
        for(char ch : str.toCharArray()){
            if(ch =='{' || ch =='('||ch=='[' ){
                deq.addFirst(ch);
            }else {
                if(!deq.isEmpty()
                        &&((deq.peekFirst() =='[' && ch ==']')
                        ||(deq.peekFirst() =='{') && ch =='}')
                        || (deq.peekFirst() =='(' && ch==')')){
                    deq.removeFirst();
                }else {
                    return false;
                }
            }
        }
        return deq.isEmpty();
    }

}
