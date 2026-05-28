import java.util.PriorityQueue;

class LastStoneWeight{
    static int lastStoneWeight(int stones[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int x:stones){
            pq.offer(x);
        }
        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            if(x!=y)pq.offer(x-y);
        }
        return pq.isEmpty()?0:pq.peek();
    }
    public static void main(String[] args){
        int stones[] = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}