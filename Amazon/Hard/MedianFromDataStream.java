import java.util.*;
public class MedianFromDataStream {
    PriorityQueue<Integer>minHeap = new PriorityQueue<>();
    PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    public MedianFromDataStream(){
        
    }
    public void addNum(int num){
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    public double findMedian(){
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        return (minHeap.peek()+maxHeap.peek())/2.0d;
    }
    
    public static void main(String[] args){
        MedianFromDataStream obj = new MedianFromDataStream();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
