package glovo;

import java.util.Deque;
import java.util.LinkedList;

public class BracketClass {

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
}
