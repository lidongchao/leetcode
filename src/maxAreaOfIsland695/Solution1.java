package maxAreaOfIsland695;

/**
 * 思路 1：DFS
 *
 * 执行用时 :3 ms, 在所有 Java 提交中击败了82.11%的用户
 * 内存消耗 :40.9 MB, 在所有 Java 提交中击败了92.22%的用户
 */

class Solution1 {
    /**
     * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
     * 你可以假设二维矩阵的四个边缘都被水包围着。
     *
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/max-area-of-island
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid 二维数组代表地图
     * @return 最大的岛屿面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        if ((row = grid.length) == 0) return 0;
        col = grid[0].length;
        int ans = 0;

        // 遍历整个地图
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) continue;
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int x, int y) {
        // 超出边界、遇到水、遇到访问过的土地
        if (x >= row || y >= col || x < 0 || y < 0 || grid[x][y] == 0)
            return 0;
        // 置为 0，表示访问过
        grid[x][y] = 0;
        // 依次访问上下左右四个方向
        int ans = 1;
        ans += dfs(grid, x+1, y);
        ans += dfs(grid, x-1, y);
        ans += dfs(grid, x, y+1);
        ans += dfs(grid, x, y-1);
        return ans;
    }

    private int row;
    private int col;
}
