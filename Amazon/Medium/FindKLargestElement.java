import java.util.PriorityQueue;
public class FindKLargestElement {
    public static int KthLargest(int[] nums,int k){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int x:nums){
            minHeap.add(x);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    public static void main(String[] args){
        int[] nums={3,2,1,5,6,4};
        System.out.println(KthLargest(nums,2));
    }
}
