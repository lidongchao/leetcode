package theMasseuseLcci17_16;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路 1：动态规划 + 状态转移表
 *
 *
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :37.4 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution1 {
    /**
     * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
     * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 预约请求序列
     * @return 总分钟数
     */
    public int massage(int[] nums) {
        map = new HashMap<>();
        massage(nums, 0, 0);
        int ans = 0;
        for (int v : map.values()) {
            ans = Math.max(ans, v);
        }
        return ans;
    }

    private void massage(int[] nums, int i, int time) {
        if (i >= nums.length) return;

        // 选择接受第 i 个预约
        if (map.getOrDefault(i+1, -1) < time + nums[i]) {
            map.put(i+1, time + nums[i]);
            massage(nums, i+2, time + nums[i]);
        }
        // 选择不接受第 i 个预约
        if (map.getOrDefault(i, -1) < time) {
            map.put(i, time);
            massage(nums, i+1, time);
        }
    }

    private Map<Integer, Integer> map;
}
