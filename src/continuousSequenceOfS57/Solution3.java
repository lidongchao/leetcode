package continuousSequenceOfS57;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路 3：滑动窗口，双指针，思路 1 中的大多数计算都是重复的，所以通过滑动窗口解决这个问题。
 * 该思路可以不要求题目中的连续，只要递增序列即可使用滑动窗口。
 *
 * 执行用时 :4 ms, 在所有 Java 提交中击败了75.52%的用户
 * 内存消耗 :37.6 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution3 {
    /**
     * 输入一个正整数 target，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     *
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param target 待分解的正整数
     * @return 由正整数序列组成的二维数组
     */
    public int[][] findContinuousSequence(int target) {
        // 用一个 List 方便存储
        List<int[]> seqList = new ArrayList<>();

        // 通过左指针 i (包含) 和右指针 j (不包含) 记录连续正整数序列的区间，sum 为当前区间的累加和
        // 序列的最大值不会超过 target/2+1，所以 j (不包含) 不会超过 target/2+2
        int sum = 0;
        for (int i = 1, j = 1; j <= target/2 + 2; ) {
            // 如果累加和 = 目标值，则记录此次序列
            if (sum == target) {
                seqList.add(generateContinuousSequence(i, j-1));
                // 序列的左指针向右移，开始寻找以 i+1 开始的序列
                sum -= i++;
            } else if (sum < target) {
                // 累加和 < 目标值，序列的右指针向右移，扩大序列区间
                sum += j++;
            } else {
                // 累加和 > 目标值，序列的左指针向右移，缩小序列区间
                sum -= i++;
            }
        }

        // 将 List 转换为二维数组并返回
        int[][] res = new int[seqList.size()][];
        for (int i = 0; i < seqList.size(); i++) {
            res[i] = seqList.get(i);
        }
        return res;
    }

    /**
     * 根据 min 和 max 生成一个连续正整数序列 [min, max]
     * @param min 序列的最小值
     * @param max 序列的最大值
     * @return 连续正整数序列
     */
    private static int[] generateContinuousSequence(int min, int max) {
        int[] seq = new int[max-min+1];
        for (int i = min; i <= max; i++) {
            seq[i-min] = i;
        }
        return seq;
    }
}
