import java.util.*;

class RaceCar {

    public static int racecar(int target) {

        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {

            dp[i] = Integer.MAX_VALUE;

            int n = 1;

            while ((1 << n) - 1 < i) {
                n++;
            }

            // If i is exactly 2^n - 1
            if ((1 << n) - 1 == i) {
                dp[i] = n;
                continue;
            }

            // Case 1: overshoot then reverse
            dp[i] = Math.min(
                dp[i],
                n + 1 + dp[(1 << n) - 1 - i]
            );

            // Case 2: go forward n-1 steps, reverse, go back m steps, reverse
            for (int m = 0; m < n - 1; m++) {

                int forward = (1 << (n - 1)) - 1;
                int backward = (1 << m) - 1;

                dp[i] = Math.min(
                    dp[i],
                    (n - 1) + 1 + m + 1 + dp[i - forward + backward]
                );
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {

        int target = 3;

        System.out.println(racecar(target));
    }
}