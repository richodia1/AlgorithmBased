package codewars;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class StringManipulation1 {
    public static void main(String[] args){
        Queue<Integer> maxHeap = new PriorityQueue<>();
        //System.out.println(maxHeap.isEmpty());
        maxHeap.offer(2);
       System.out.println(!maxHeap.isEmpty());
        maxHeap.offer(4);
        maxHeap.offer(7);
        System.out.println(maxHeap.peek());
        System.out.println(longest("union","union"));
    }
    public static String longest (String s1, String s2) {
        return (s1 + s2).chars().distinct()
                .mapToObj(c -> String.valueOf((char)c))
                .sorted()
                .collect(Collectors.joining());
    }
    public static String longest2(String s1, String s2) {
        String s = s1 + s2;
           return s.chars()
                .distinct()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
