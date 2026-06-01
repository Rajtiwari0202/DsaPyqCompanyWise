public class NumberOfIslands {

    static void dfs(int[][] grid, int i, int j) {

        int row = grid.length;
        int col = grid[0].length;

        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 0;

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    static int countIslands(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,1,0,0},
            {0,0,0,1,1}
        };

        System.out.println(countIslands(grid));
    }
}