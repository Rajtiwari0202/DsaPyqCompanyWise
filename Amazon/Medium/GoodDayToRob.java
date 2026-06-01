import java.util.*;

public class GoodDayToRob {

    public static void goodDaysToRob(int[] security, int time) {

        int n = security.length;

        int[] pre = new int[n];
        int[] suf = new int[n];

        int cnt = 0;

        for (int i = 1; i < n; i++) {

            if (security[i] <= security[i - 1]) {
                cnt++;
            } else {
                cnt = 0;
            }

            pre[i] = cnt;
        }

        cnt = 0;

        for (int i = n - 2; i >= 0; i--) {

            if (security[i] <= security[i + 1]) {
                cnt++;
            } else {
                cnt = 0;
            }

            suf[i] = cnt;
        }

        for (int i = 0; i < n; i++) {

            if (pre[i] >= time && suf[i] >= time) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {

        int time = 2;
        int[] security = {5,3,3,3,5,6,2};

        goodDaysToRob(security, time);
    }
}