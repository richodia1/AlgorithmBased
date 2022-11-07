package codility;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOFIntegerStream {

    public static void main(String[] args) {
        MedianOFIntegerStream ob = new MedianOFIntegerStream();
        ob.add(1);
        ob.add(1);
        ob.add(3);
        System.out.println(" Median is : "+ob.getMedian());
    }
    private Queue<Integer> minHeap, maxHeap;
    MedianOFIntegerStream(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }
    void add(int num){
        if(!minHeap.isEmpty() && num < minHeap.peek()){
            maxHeap.offer(num);
            if(maxHeap.size() > minHeap.size() + 1){
                minHeap.offer(maxHeap.poll());
            }
        }else{
            minHeap.offer(num);
            if(minHeap.size() > maxHeap.size() + 1){
                maxHeap.offer(minHeap.poll());
            }
        }
    }
    double getMedian(){
        double median = 0.0;
        if(minHeap.size() < maxHeap.size()){
            median = maxHeap.peek();
        }else if(minHeap.size() > maxHeap.size()){
            median = minHeap.peek();
        }else{
            median = (minHeap.peek() + maxHeap.peek())/ 2.0;
        }
        return  median;
    }
}
