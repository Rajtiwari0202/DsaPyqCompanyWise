import java.util.*;

public class UniquePaths {

    static int solve(int i, int j, int m, int n, int[][] memo) {

        // Out of bounds
        if (i >= m || j >= n) {
            return 0;
        }

        // Destination reached
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Already computed
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        return memo[i][j] =
            solve(i + 1, j, m, n, memo)
          + solve(i, j + 1, m, n, memo);
    }

    static int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, m, n, memo);
    }

    public static void main(String[] args) {

        int m = 3;
        int n = 2;

        System.out.println(uniquePaths(m, n));
    }
}