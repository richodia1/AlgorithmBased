package codebyteinterview;
/*
Problem Statement#
Design a class to calculate the median of a number stream.
The class should have the following two methods:
1.	insertNum(int num): stores the number in the class
2.	findMedian(): returns the median of all numbers inserted in the class
If the count of numbers inserted in the class is even,
the median will be the average of the middle two numbers.

 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfAStreamOfNumbers {
    PriorityQueue<Integer> maxHeap; //containing first half of numbers
    PriorityQueue<Integer> minHeap; //containing second half of numbers

    public MedianOfAStreamOfNumbers () {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());  // highest to lowest
        minHeap = new PriorityQueue<>();  // smallest to highest
    }

    public void insertNum(int num) {
       if(!minHeap.isEmpty() && num < minHeap.peek()){
           maxHeap.offer(num);
           if(maxHeap.size() > minHeap.size() +1){
               minHeap.add(maxHeap.poll());
           }
       }else {
           minHeap.offer(num);
           if(minHeap.size() > maxHeap.size() + 1){
               maxHeap.add(minHeap.poll());
           }
       }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // we have even number of elements, take the average of middle two elements
            System.out.println("The minimumQueue is: " + minHeap);
            System.out.println("The MaximumQueue is: " + maxHeap);
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        // because max-heap will have one more element than the min-heap
        System.out.println("The minimumQueue is: " + minHeap);
        System.out.println("The MaximumQueue is: " + maxHeap);
        return maxHeap.peek();
    }
    public static void main(String[] args) {
        MedianOfAStreamOfNumbers medianOfAStream = new MedianOfAStreamOfNumbers();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        medianOfAStream.insertNum(2);
        medianOfAStream.insertNum(4);
        medianOfAStream.insertNum(5);
        medianOfAStream.insertNum(6);
        medianOfAStream.insertNum(7);
        System.out.println("The median is: " + medianOfAStream.findMedian());
      //  medianOfAStream.insertNum(5);
       // System.out.println("The median is: " + medianOfAStream.findMedian());
       // medianOfAStream.insertNum(4);
       // System.out.println("The median is: " + medianOfAStream.findMedian());
    }


}
