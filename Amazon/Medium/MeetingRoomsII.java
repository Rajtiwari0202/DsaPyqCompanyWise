import java.util.*;

public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] arr) {

        TreeMap<Integer, Integer> tmap = new TreeMap<>();

        for (int[] meeting : arr) {

            int start = meeting[0];
            int end = meeting[1];

            tmap.put(start, tmap.getOrDefault(start, 0) + 1);
            tmap.put(end, tmap.getOrDefault(end, 0) - 1);
        }

        int cnt = 0;
        int ans = 0;

        for (int value : tmap.values()) {

            cnt += value;

            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] arr = {
            {0, 30},
            {5, 10},
            {15, 20}
        };

        System.out.println(minMeetingRooms(arr));
    }
}