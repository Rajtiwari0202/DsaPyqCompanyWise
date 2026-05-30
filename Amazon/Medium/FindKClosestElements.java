import java.util.*;

public class FindKClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {

            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);

            // If distances equal, remove larger element first
            if (diffA == diffB) {
                return b - a;
            }

            // Larger distance gets higher priority
            return diffB - diffA;
        });

        for (int num : arr) {

            maxHeap.offer(num);

            // Keep only k closest elements
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            ans.add(maxHeap.poll());
        }

        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(findClosestElements(arr, 4, 3));
    }
}