package houseRobber198;

/**
 * 思路：DP 动态规划
 *
 * 状态转移方程 dp[i] 代表从第 0 家打劫到第 i 家，且一定要打劫第 i 家后的最高金额。
 *
 * dp[i] = max(  dp[i-2]+nums[i]  ,  dp[i-1]  )
 *
 * 特殊的：dp[1] = nums[1]     dp[2] = max(  0+nums[2]  ,  dp[1]  )
 *
 * 由于当前状态只有前两家的状态决定，因此只需要维护两个变量作为状态。
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :37 MB, 在所有 Java 提交中击败了6.52%的用户
 */
class Solution {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 每个房屋存放的金额组成的非负整数数组
     * @return 最高金额
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // 上两家的状态
        int x = 0;
        // 上一家的状态
        int y = nums[0];

        // 从 nums[1] 开始，依次更新 x y 的状态
        for (int i = 1; i < nums.length; i++) {
            // x -> y -> nx
            // int nx = x + nums[i];
            // x = nx > y ? nx : y;
            x = Math.max(x+nums[i], y);
            // 内部自增，用于交替 x 和 y
            i++;
            if (i == nums.length) break;
            // y -> x -> ny
            // int ny = y + nums[i];
            // y = ny > x ? ny : x;
            y = Math.max(y+nums[i], x);
        }

        return x > y ? x : y;
    }
}
