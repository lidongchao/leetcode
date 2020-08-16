package removeBoxes546;

/**
 * 思路：动态规划
 *
 * 执行用时：29 ms, 在所有 Java 提交中击败了77.65%的用户
 * 内存消耗：50.4 MB, 在所有 Java 提交中击败了28.68%的用户
 */
class Solution {
    /**
     * 给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
     * 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。
     * 当你将所有盒子都去掉之后，求你能获得的最大积分和。
     *
     * 示例：
     * 输入：boxes = [1,3,2,2,2,3,4,3,1]
     * 输出：23
     * 解释：
     * [1, 3, 2, 2, 2, 3, 4, 3, 1]
     * ----> [1, 3, 3, 4, 3, 1] (3*3=9 分)
     * ----> [1, 3, 3, 3, 1] (1*1=1 分)
     * ----> [1, 1] (3*3=9 分)
     * ----> [] (2*2=4 分)
     *  
     * 提示：
     * 1 <= boxes.length <= 100
     * 1 <= boxes[i] <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-boxes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param boxes 盒子
     * @return 能得到的最多积分
     */
    public int removeBoxes(int[] boxes) {

        int len = boxes.length;
        // dp[i][j][k] 定义了消除 boxes[i..j] 所能够得到的最大积分，其中 k 表示 j 的右侧积攒未消除的和 boxes[j] 同颜色的盒子个数。
        int[][][] dp = new int[len][len][len];
        return remove(dp, boxes, 0, len-1, 0);
    }

    private int remove(int[][][] dp, int[] boxes, int i, int j, int k) {
        if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        }

        // 只剩最后个盒子，消除
        if (i == j) {
            dp[i][j][k] = (k + 1) * (k + 1);
            return dp[i][j][k];
        }

        // 尝试在 j 的左侧寻找连续的同颜色的盒子
        int firstAttempt = j;
        while (firstAttempt >= i + 1 && boxes[firstAttempt - 1] == boxes[firstAttempt]) {
            firstAttempt--;
        }
        // 能够找到，转换为等价形式
        if (firstAttempt != j) {
            dp[i][j][k] = remove(dp, boxes, i, firstAttempt, k + (j - firstAttempt));
            return dp[i][j][k];
        }

        // 无法找到连续的，尝试在 j 的左侧寻找不连续的同颜色的盒子
        int maxScore = 0;  // 记录几种尝试的最高得分
        int secondAttempt = j - 2;
        while (secondAttempt >= i) {
            if (boxes[secondAttempt] == boxes[j]) {
                // 每找到一个，就尝试将 boxes[secondAttempt+1 .. j-1] 消除，dp[i][j][k] 变为 dp[i][secondAttempt][k+1]
                int dp1 = remove(dp, boxes, secondAttempt + 1, j - 1, 0) + remove(dp, boxes, i, secondAttempt, k + 1);
                maxScore = Math.max(maxScore, dp1);
            }
            secondAttempt--;
        }

        // 尝试只消除 boxes[j]，dp[i][j][k] 变为 dp[i][j-1][0]
        int dp2 = remove(dp, boxes, i, j - 1, 0) + (k + 1) * (k + 1);
        maxScore = Math.max(maxScore, dp2);
        dp[i][j][k] = maxScore;
        return dp[i][j][k];
    }

}
