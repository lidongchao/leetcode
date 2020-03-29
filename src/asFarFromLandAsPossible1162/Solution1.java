package asFarFromLandAsPossible1162;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 思路 1：造陆法 (多源广度优先遍历)，参考 994 烂橘子
 *
 * 执行用时 :18 ms, 在所有 Java 提交中击败了76.79%的用户
 * 内存消耗 :42.1 MB, 在所有 Java 提交中击败了99.00%的用户
 */
class Solution1 {
    /**
     * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。
     * 其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
     *
     * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
     *
     * 如果我们的地图上只有陆地或者海洋，请返回 -1。
     *
     * 提示：
     * 1 <= grid.length == grid[0].length <= 100
     * grid[i][j] 不是 0 就是 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid 地图网格
     * @return 距离陆地最远的海洋 与 最近一块陆地的距离
     */
    public int maxDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // 先将所有的陆地都放入队列中
        Queue<Integer> lands = new ArrayDeque<>();
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (grid[x][y] == 1) {
                    lands.add(x * col + y);
                }
            }
        }
        if (lands.isEmpty() || lands.size() == row * col) return -1;

        // 添加一个特殊标记
        lands.add(-1);
        // 遍历一遍队列中的陆地，如果能够从上下左右四个方向向海洋延伸，则将该海洋变成陆地，同时加入到陆地队列中。
        // 当访问到 -1 时，代表第一次遍历结束，队列中剩下的都是第一次延伸的新陆地，这些新陆地与原始陆地的距离为 1。
        // 继续遍历新陆地，向队列中加入距离为 2、3、4 的新陆地，直到地图上全都变成陆地为止。
        int distance = 0;
        while (true) {
            final Integer point = lands.poll();
            if (point == -1) {
                if (lands.isEmpty()) {
                    break;
                } else {
                    lands.add(-1);
                    distance++;
                    continue;
                }
            }
            int x = point / col;
            int y = point % col;

            // 从上下左右四个方向向海洋延伸
            for (int[] d : direction) {
                final int newX = x + d[0];
                final int newY = y + d[1];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == 0) {
                    grid[newX][newY] = 1;
                    lands.add(newX * col + newY);
                }
            }

        }
        return distance;
    }
}
