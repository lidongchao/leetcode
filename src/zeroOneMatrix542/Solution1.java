package zeroOneMatrix542;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 思路 1：遍历每个 1，如果上下左右最小值为 0，则不需要变更，否则将该 1 变为 2。效果是，除了靠近 0 的 1 保持不变，其余 1 变为 2。
 * 再遍历每个 2，如果上下左右最小值为 1，则不需要改变，否则将该 2 变为 3。效果是，除了靠近 1 的 2 保持不变，其余 2 变为 3。
 * 依次循环。
 *
 * 执行用时 :12 ms, 在所有 Java 提交中击败了75.38%的用户
 * 内存消耗 :42.2 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution1 {
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

        int[][] ans = new int[row][col];

        // 队列始终存储上一次有变动的结点
        Queue<Integer> queue = new ArrayDeque<>();

        // 初始状态：将所有 1 结点加入队列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    ans[i][j] = 1;
                    queue.add(i * col + j);
                }
            }
        }

        // 第一次遍历所有 1 结点，第二次遍历所有 2 结点。。。。
        while (!queue.isEmpty()) {
            Integer point = queue.poll();
            int i = point / col;
            int j = point % col;

            int minToZero = Integer.MAX_VALUE;

            // 计算上下左右最小值
            for (int[] direct :
                    directs) {
                int newI = i + direct[0];
                int newJ = j + direct[1];
                if (newI >= 0 && newI < row && newJ >= 0 && newJ < col) {
                    minToZero = Math.min(minToZero, ans[newI][newJ]);
                }
            }
            // 根据最小值判断是否需要变动，如果变动，则需要加入队列中继续判断
            if (ans[i][j] != minToZero + 1) {
                ans[i][j] = minToZero + 1;
                queue.add(point);
            }
        }

        return ans;
    }

    private static int[][] directs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
}
