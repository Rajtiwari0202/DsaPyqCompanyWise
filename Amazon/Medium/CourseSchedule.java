import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int n, int[][] prerequisites) {

        ArrayList<Integer>[] adj = new ArrayList[n];

        int[] inDegree = new int[n];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] x : prerequisites) {

            adj[x[1]].add(x[0]);

            inDegree[x[0]]++;
        }

        // Add nodes with indegree 0
        for (int i = 0; i < n; i++) {

            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {

            int course = queue.poll();

            count++;

            for (int next : adj[course]) {

                inDegree[next]--;

                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return count == n;
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] arr = {
            {1,0},
            {2,0},
            {3,1},
            {3,2}
        };

        System.out.println(canFinish(n, arr));
    }
}