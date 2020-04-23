package countNumberOfNiceSubarrays1248;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路 1：数学公式
 *
 * 执行用时 :24 ms, 在所有 Java 提交中击败了25.86%的用户
 * 内存消耗 :48.2 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution {
    /**
     * 给你一个整数数组 nums 和一个整数 k。
     * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
     * 请返回这个数组中「优美子数组」的数目。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 整数数组
     * @param k 优美子数组应包含的奇数个数
     * @return 优美子数组个数
     */
    public int numberOfSubarrays(int[] nums, int k) {

        // 记录每个奇数的左边，离下一个奇数之间有多少个偶数
        int[] leftEvenNum = new int[nums.length];
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果是奇数
            if ((nums[i] & 1) == 1) {
                leftEvenNum[i] = left;
                left = 0;
            } else {
                left++;
            }
        }

        // 记录每个奇数的右边，离下一个奇数之间有多少个偶数
        int[] rightEvenNum = new int[nums.length];
        int right = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 如果是奇数
            if ((nums[i] & 1) == 1) {
                rightEvenNum[i] = right;
                right = 0;
            } else {
                right++;
            }
        }

        // 缓存 k-1 个奇数
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果是奇数
            if ((nums[i] & 1) == 1) {
                // 将奇数加入队列
                queue.add(i);
                // 队列中正好有 k 个奇数
                if (queue.size() == k) {
                    // 取出第一个奇数，和当前奇数可以组成一个 "优美子数组"
                    // 而且，第一个奇数左边的偶数，和当前奇数右边的偶数，也可以任意加入，同样是 "优美子数组"
                    // 所以总共衍生出 (第一个奇数左边的偶数个数 + 1) * (当前奇数右边的偶数 + 1) 个 "优美子数组"
                    Integer first = queue.poll();
                    ans += (leftEvenNum[first] + 1) * (rightEvenNum[i] + 1);
                }
            }
        }

        return ans;
    }
}
