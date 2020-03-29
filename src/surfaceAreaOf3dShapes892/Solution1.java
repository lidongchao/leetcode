package surfaceAreaOf3dShapes892;

/**
 * 思路 1：所有立方体的表面积 - 重叠部分的表面积 = 最终形体的表面积
 *
 * 执行用时 :4 ms, 在所有 Java 提交中击败了73.95%的用户
 * 内存消耗 :41.3 MB, 在所有 Java 提交中击败了88.24%的用户
 */
class Solution1 {
    /**
     * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
     * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
     * 请你返回最终形体的表面积。
     *
     * 提示：
     * 1 <= N <= 50
     * 0 <= grid[i][j] <= 50
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid 代表立方体的矩阵
     * @return 最终形体的表面积
     */
    public int surfaceArea(int[][] grid) {
        int sum_x = 0, sum_y = 0, sum_z = 0, block = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 立方体块数
                block += grid[i][j];
                // z 轴看过去有多少重叠的面积
                if (grid[i][j] > 1) sum_z += grid[i][j]-1;
                // x 轴看过去有多少重叠的面积
                if (j < grid[0].length-1) sum_x += Math.min(grid[i][j], grid[i][j+1]);
                // y 轴看过去有多少重叠的面积
                if (i < grid.length-1) sum_y += Math.min(grid[i][j], grid[i+1][j]);
            }
        }

        // 立方体所有表面积 - 重叠的表面积
        return block*6 - (sum_x+sum_y+sum_z)*2;
    }
}
