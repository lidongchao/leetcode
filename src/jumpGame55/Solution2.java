package jumpGame55;

/**
 * 思路 2：从一个点 i 出发，能到达 i+1 i+2 ... i+nums[i] 这些点，i+nums[i] 就是最远的点，
 * 再依次从这些点出发，能得到一批新的点，和新的最远的点。
 * 但每次只需要更新全局最远的点，从起点开始到最远的点之间的所有点都是可达的。因此只需要看最远的点是否大于或等于终点。
 *
 * 执行用时 :3 ms, 在所有 Java 提交中击败了36.93%的用户
 * 内存消耗 :41.7 MB, 在所有 Java 提交中击败了12.50%的用户
 */
class Solution2 {
    public boolean canJump(int[] nums) {
        if (0 == nums.length || 1 == nums.length) return true;
        // 初始化最远的点为 0+nums[0]
        int maxPos = nums[0];
        // 依次访问可达的点，同时更新最远的点
        for (int i = 0; i <= maxPos; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            // 如果发现最远的点包含了终点，则说明终点可达
            if (maxPos >= nums.length - 1) return true;
        }
        return false;
    }
}
