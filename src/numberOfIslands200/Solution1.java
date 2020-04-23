package numberOfIslands200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路 1：BFS
 *
 * 顺序扫描整个地图，先找到一个陆地点，从这个点作为起点进行广度优先遍历，将所有遍历到的陆地变为水，岛的数量为 1。
 * 接着再找下一个一个陆地点，重复上述操作，岛的数量为 2。
 * 直到扫描完成，得到所有岛的数量。
 *
 * 执行用时 :6 ms, 在所有 Java 提交中击败了23.83%的用户
 * 内存消耗 :41.6 MB, 在所有 Java 提交中击败了12.50%的用户
 */
class Solution1 {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid 地图
     * @return 岛的数量
     */
    public int numIslands(char[][] grid) {
        if (null == grid || 0 == grid.length || 0 == grid[0].length) return 0;

        // 地图的行数和列数
        int row = grid.length;
        int col = grid[0].length;

        // 四个方向
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        // 辅助 DFS
        Queue<Integer> queue = new LinkedList<>();
        // 记录岛屿数量
        int ans = 0;


        // 扫描是否存在陆地，一遍扫描就足够
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 找到陆地，以该点作为起点，进行 DFS
                if (grid[i][j] == '1') {
                    ans ++;

                    queue.clear();

                    queue.add(i * col + j);
                    grid[i][j] = '0';

                    while (!queue.isEmpty()) {
                        int pos = queue.poll();
                        // 四个方向依次访问
                        for (int[] d : directions) {
                            int newI = pos / col + d[0];
                            int newJ = pos % col + d[1];
                            if (newI >= 0 && newI < row && newJ >= 0 && newJ < col && grid[newI][newJ] == '1') {
                                queue.add(newI * col + newJ);
                                grid[newI][newJ] = '0';
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}
