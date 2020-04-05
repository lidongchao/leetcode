package trappingRainWater42;

/**
 * 思路 1：辅助数组
 *
 * 积水量 = Min(左边最高点的高度, 右边最高点的高度) - 当前最高点的高度 if 差值不为负;
 *
 * 需要遍历两次数组，第一遍用辅助数组保存每个点的左边最高点高度，第二遍动态计算每个点的右边最高点高度，以及该点的积水量
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了99.98%的用户
 * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了11.78%的用户
 */
class Solution1 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height  柱子高度
     * @return 积水量
     */
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int ans = 0;

        int[] leftMaxArr = new int[height.length];
        int leftMax = 0;
        // 从左到右遍历数组，通过辅助数组 leftMaxArr 记录左边的最高点
        for (int i = 0; i < height.length; i++) {
            leftMaxArr[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }

        int rightMax = 0;
        // 从右到左遍历数组，通过计算得到当前点的右边最高点，和已知的左边最高点和当前点的高度，计算出积累的水量
        for (int i = height.length - 1; i >= 0; i--) {
            final int quantity = Math.min(leftMaxArr[i], rightMax) - height[i];
            ans += quantity > 0 ? quantity : 0;
            rightMax = Math.max(rightMax, height[i]);
        }

        return ans;
    }
}
