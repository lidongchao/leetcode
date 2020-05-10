package maximalSquare221;

/**
 * 思路 1：动态规划
 *
 * 执行用时 :5 ms, 在所有 Java 提交中击败了94.18%的用户
 * 内存消耗 :42 MB, 在所有 Java 提交中击败了68.75%的用户
 */
class Solution1 {
    /**
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximal-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix 二维矩阵
     * @return 矩阵中的最大正方形的面积
     */
    public int maximalSquare(char[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) return 0;

        int row, col;

        row = matrix.length;
        col = matrix[0].length;

        // 存放：当前位置及其左边有多少个连续的 '1'
        int[][] leftPeer = new int[row][col];
        for (int i = 0; i < row; i++) {
            leftPeer[i][0] = matrix[i][0] - '0';
            for (int j = 1; j < col; j++) {
                leftPeer[i][j] = matrix[i][j] == '1' ? leftPeer[i][j-1] + 1 : 0;
            }
        }

        // 存放：当前位置及其上边有多少个连续的 '1'
        int[][] upPeer = new int[row][col];
        for (int j = 0; j < col; j++) {
            upPeer[0][j] = matrix[0][j] - '0';
            for (int i = 1; i < row; i++) {
                upPeer[i][j] = matrix[i][j] == '1' ? upPeer[i-1][j] + 1 : 0;
            }
        }

        int maxSquareSide = 0;

        // 存放：以当前位置作为最大矩形的右下角，该矩形的最大边长
        int[][] dp = new int[row][col];
        for (int j = 0; j < col; j++) {
            // 第一行特殊处理
            dp[0][j] = matrix[0][j] - '0';
            maxSquareSide = Math.max(maxSquareSide, dp[0][j]);
        }
        for (int i = 1; i < row; i++) {
            // 第一列特殊处理
            dp[i][0] = matrix[i][0] - '0';
            maxSquareSide = Math.max(maxSquareSide, dp[i][0]);
            // 非第一行第一列
            for (int j = 1; j < col; j++) {
                // 如果当前位置为 '0'，则无法作为矩形的右下角，边长为 0
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                }
                // 如果当前位置为 '1'，看一眼左上紧邻的位置
                else {
                    // 左上无法组成矩形，所以当前位置只能自己作为矩形，边长为 1
                    if (dp[i-1][j-1] == 0) {
                        dp[i][j] = 1;
                    }
                    // 左上是某一个矩形的右下角，且该矩形的边长为 m3[i-1][j-1]，
                    // 因此分别查看当前位置的左边和上边是否有至少连续 m3[i-1][j-1]+1 个 '1'，
                    // 如果有，则可以组成一个边长为 m3[i-1][j-1]+1 的新矩形，且当前位置是该矩形的右下角点。
                    // 如果没有，则只能组成一个小的矩形，该边长为左边'1'的个数和上边'1'的个数取小值。
                    else {
                        dp[i][j] = Math.min(Math.min(leftPeer[i][j], upPeer[i][j]), dp[i-1][j-1]+1);
                    }
                }
                maxSquareSide = Math.max(maxSquareSide, dp[i][j]);
            }
        }
        return maxSquareSide * maxSquareSide;
    }

}
