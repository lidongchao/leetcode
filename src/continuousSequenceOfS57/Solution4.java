package continuousSequenceOfS57;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路 4：
 * Y = i+(i+1)+(i+2)+...+j
 *   = (j+i)(j-i+1)/2
 * 求根公式计算量很大，乘除开根都用上了，这里还有另外一个思路，对于每一个和为 Y 的连续正整数序列，其序列元素的个数显然是唯一的。
 * 也就是说，j-i+1 是唯一的。
 *
 * 这里定义 t = j-i，那么 Y = (j+i)(j-i+1)/2 = (t+2i)(t+1)/2 => i = Y/(t+1)-t/2
 *
 * 接下来，由于 t 对于每一个序列是唯一的，因此可以遍历 t，计算 i 是不是一个正整数，如果是，说明 [i,t+i] 是所需要的连续正整数序列。
 *
 * 进一步变形，i = Y/(t+1)-t/2 = (Y-t(t+1)/2)/(t+1)，由于i > 0，所以 Y > t(t+1)/2，可以得到 t 遍历的终止条件。
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了97.11%的用户
 * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution4 {
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

        // 从 1 开始遍历，直到不满足 Y > t(t+1)/2 条件
        for (int t = 1, i, alpha; (alpha = (t*(t+1))>>1) < target; t++ ) {
            // 判断 i 是不是正整数
            i = (target - alpha) / (t+1);
            if (target-alpha == i*(t+1)) {
                seqList.add(generateContinuousSequence(i, t+i));
            }
        }

        // 将 List 转换为二维数组并返回，需要将 List 逆序排序，因为 t 越小，序列的元素个数越少，序列的最小值越大，反而越需要排在后面
        int[][] res = new int[seqList.size()][];
        for (int i = 0; i < seqList.size(); i++) {
            res[i] = seqList.get(seqList.size()-i-1);
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
