package trappingRainWater42;

/**
 * 思路 2：双指针
 *
 * 思路 1 需要遍历两次数组，但是在第一次从左向右遍历时，如果能够保证右边的最高点不比左边的低，那么就可以只通过左边的最高点计算积水量。
 * 同样的，从右向左遍历时，如果能够保证左边的最高点不比右边的低，那么就可以只通过右边的最高点计算积水量。
 *
 * 要得到这样的保证，只需要通过双指针从两侧向中间移动，且每次移动指向数据更小的指针。
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了99.98%的用户
 * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了11.78%的用户
 */
class Solution2 {
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

        int i = 0, j = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (i != j) {
            // 更新左边
            if (height[i] < height[j]) {
                if (height[i] >= leftMax) {
                    leftMax = height[i];
                } else {
                    // 此时右边不会比左边低，所以可以直接使用左边最高点的高度计算积水量
                    ans += leftMax - height[i];
                }
                i++;
            }
            // 更新右边
            else {
                if (height[j] >= rightMax) {
                    rightMax = height[j];
                } else {
                    ans += rightMax - height[j];
                }
                j--;
            }
        }

        return ans;
    }
}
