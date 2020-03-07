package continuousSequenceOfS57;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路 1：暴力解法，从 1 开始，加 2，加 3，直到大于等于 target，如果相等，则记录这次序列；
 * 再从 2 开始，重复上面的操作，直到 target / 2
 *
 * 执行用时 :7 ms, 在所有 Java 提交中击败了52.21%的用户
 * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution1 {
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
        // 先确定序列的最小值
        for (int i = 1; i <= target / 2; i++) {
            // 初始化序列的和
            int sum = i;
            // 再寻找序列的最大值
            for (int j = i+1; j <= target / 2 + 1; j++) {
                // 求得序列的和，如果与目标值相等则记录此次序列
                if ((sum += j) == target) {
                    seqList.add(generateContinuousSequence(i,j));
                    break;
                }
                // 如果超过目标值，则说明无法找到以 i 开始的序列
                if (sum > target) {
                    break;
                }
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
