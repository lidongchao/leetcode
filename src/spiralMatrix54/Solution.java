package spiralMatrix54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 思路：分层模拟顺时针螺旋顺序
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了5.72%的用户
 */
class Solution {
    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/spiral-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param matrix 矩阵
     * @return 矩阵由外到内顺时针访问结果
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        ans = new int[row * col];
        index = 0;

        // 可以分解成多少个环
        int end = (Math.min(row, col) + 1) >> 1;

        // 遍历每一个环
        for (int i = 0; i < end; i++) {
            spiralOrder(matrix, i, row-1-i, i, col-1-i);
        }

        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }

    /**
     * 遍历矩阵中的环
     *
     * @param matrix 矩阵
     * @param rowStart 环的上边界
     * @param rowEnd 环的下边界
     * @param colStart 环的左边界
     * @param colEnd 环的右边界
     */
    private void spiralOrder(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd) {
        // 环只有一行
        if (rowStart == rowEnd) {
            for (int j = colStart; j <= colEnd; j++) {
                ans[index++] = matrix[rowStart][j];
            }
            return;
        }
        // 环只有一列
        if (colStart == colEnd) {
            for (int i = rowStart; i <= rowEnd; i++) {
                ans[index++] = matrix[i][colStart];
            }
            return;
        }

        // 上
        for (int j = colStart; j <= colEnd; j++) {
            ans[index++] = matrix[rowStart][j];
        }
        // 右
        for (int i = rowStart+1; i <= rowEnd; i++) {
            ans[index++] = matrix[i][colEnd];
        }
        // 下
        for (int j = colEnd-1; j >= colStart; j--) {
            ans[index++] = matrix[rowEnd][j];
        }
        // 左
        for (int i = rowEnd-1; i > rowStart; i--) {
            ans[index++] = matrix[i][colStart];
        }

    }

    private int[] ans;
    private int index;
}
