package zeroOneMatrix542;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 思路 2：广度优先遍历
 *
 * 执行用时 :22 ms, 在所有 Java 提交中击败了47.14%的用户
 * 内存消耗 :43.9 MB, 在所有 Java 提交中击败了100.00%的用户
 *
 */
class Solution2 {
    /**
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
     * 两个相邻元素间的距离为 1 。
     *
     * 注意:
     * 给定矩阵的元素个数不超过 10000。
     * 给定矩阵中至少有一个元素是 0。
     * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/01-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix 0-1 矩阵
     * @return 距离矩阵
     */
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // 距离矩阵
        int[][] ans = new int[row][col];
        // 遍历标记矩阵
        boolean[][] visited = new boolean[row][col];

        // 辅助遍历队列
        Queue<Integer> queue = new ArrayDeque<>();

        // 初始状态：将所有 0 结点加入队列，同时标记为已遍历
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(i * col + j);
                }
            }
        }

        // 广度优先遍历
        while (!queue.isEmpty()) {
            Integer point = queue.poll();
            int i = point / col;
            int j = point % col;

            // 四个方向遍历
            for (int[] direct :
                    directs) {
                int newI = i + direct[0];
                int newJ = j + direct[1];
                // 如果找到未遍历过的结点，则加入队列，标记为已遍历，距离为当前结点的距离加一
                if (newI >= 0 && newI < row && newJ >= 0 && newJ < col && !visited[newI][newJ]) {
                    queue.add(newI * col + newJ);
                    visited[newI][newJ] = true;
                    ans[newI][newJ] = ans[i][j] + 1;
                }
            }
        }

        return ans;
    }

    private static int[][] directs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
}
