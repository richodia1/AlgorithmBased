package codility;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MediaStream2 {

    Queue<Integer> maxHeap, minHeap;
    public MediaStream2(){
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    public double getMedian(){
        double median = 0.0;
        if(maxHeap.size() > minHeap.size()){
            median = maxHeap.peek();
        }else if(minHeap.size() > maxHeap.size()){
            median = minHeap.peek();
        }else {
            median = minHeap.peek()/2.0 + maxHeap.peek()/2.0;
        }
        return median;
    }
    public void add(int num){
        if(!minHeap.isEmpty() && num < minHeap.peek()){
            maxHeap.offer(num);
            if(maxHeap.size() > minHeap.size()+1){
                minHeap.offer(maxHeap.poll());
            }
        }else {
            minHeap.offer(num);
            if(minHeap.size() > maxHeap.size()+1){
                maxHeap.offer(minHeap.poll());
            }
        }
    }
}
