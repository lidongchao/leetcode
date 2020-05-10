package maximalSquare221;

/**
 * 思路 2：动态规划
 *
 * 执行用时 :6 ms, 在所有 Java 提交中击败了87.12%的用户
 * 内存消耗 :43.2 MB, 在所有 Java 提交中击败了25.00%的用户
 */
class Solution2 {
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
                // 如果当前位置为 '1'，dp[i][j] = min{dp[i-1][j], dp[i][j-1], dp[i-1][j-1]} + 1
                else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                maxSquareSide = Math.max(maxSquareSide, dp[i][j]);
            }
        }
        return maxSquareSide * maxSquareSide;
    }

}
