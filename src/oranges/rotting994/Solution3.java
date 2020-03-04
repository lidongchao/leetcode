package oranges.rotting994;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * BFS 图的广度优先搜索算法
 * 执行用时 :3 ms, 在所有 Java 提交中击败了71.83%的用户
 * 内存消耗 :38.1 MB, 在所有 Java 提交中击败了61.96%的用户
 */
class Solution3 {
    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     *
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     *
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotting-oranges
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid 橘子网格
     * @return 所有的橘子腐烂所需要的分钟数，-1表示不可能。
     */
    public int orangesRotting(int[][] grid) {
        int[] p1 = {1, -1, 0, 0}, p2 = {0, 0, 1, -1};
        int row = grid.length, col = grid[0].length;
        // 记录新鲜橘子的个数，每烂掉一个就减一
        int fresh = 0;
        // 记录已经过的分钟数
        int turn = 0;
        // 记录已腐烂，但还没有腐烂周围橘子的橘子
        Queue<Integer> rottenQueue = new ArrayDeque<>();
        // 全图扫描，记录初始已腐烂的橘子，以及新鲜橘子的个数
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (grid[x][y] == 2) {
                    // 根据坐标 x y 计算出一个唯一 id
                    rottenQueue.add(x * col + y);
                } else if (grid[x][y] == 1) {
                    fresh++;
                }
            }
        }
        // 插入特殊标记，读取到该标记表示一分钟过去了
        rottenQueue.add(-1);
        // 循环取出已腐烂的橘子，尝试腐烂周围的新鲜橘子，如果有，则将该新鲜橘子变腐烂并加入队列中
        while (true) {
            int id = rottenQueue.remove();

            if (id == -1) {
                // 队列已空，结束
                if (rottenQueue.isEmpty()) {
                    break;
                }
                // 分钟数加一
                turn++;
                // 继续插入特殊标记
                rottenQueue.add(-1);
                continue;
            }

            // 根据唯一 id 计算出 x y
            int rx = id / col;
            int ry = id % col;
            // 上下左右四个方向分别查看是否有新鲜橘子
            for (int i = 0; i < 4; i++) {
                int x = rx + p1[i];
                int y = ry + p2[i];
                // 判断该坐标是否是新鲜橘子
                if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
                    rottenQueue.add(x * col + y);
                    grid[x][y] = 2;
                    fresh--;
                }
            }
        }
        return fresh == 0 ? turn : -1;
    }
}
