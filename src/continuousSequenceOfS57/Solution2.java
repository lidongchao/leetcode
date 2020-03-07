package continuousSequenceOfS57;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路 2：
 * Y = i+(i+1)+(i+2)+...+j
 *   = (j+i)(j-i+1)/2
 *   = (jj+j-ii+i)/2
 *   = (j(j+1)-i(i-1))/2
 * ii-i+2Y-j(j+1)=0
 * 根据求根公式可得 i=(1+sqrt(1-4(2Y-j(j+1))))/2 (另一个解无效)
 * 或者
 * jj+j-(2Y+i(i-1))=0
 * 根据求根公式可得 j=(sqrt(1+4(2Y+i(i-1)))-1)/2 (另一个解无效)
 *
 * 执行用时 :11 ms, 在所有 Java 提交中击败了28.26%的用户
 * 内存消耗 :41.5 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution2 {
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
        // 序列的最小值不会超过 target/2，遍历每一个 i，计算 j 是不是一个正整数，如果是，说明 [i,j] 是所需要的连续正整数序列
        for (int i = 1; i <= target / 2; i++) {
            // 通过求根公式计算 j 值，L 和 long 是必须的，否则会出现 int 值溢出
            Double root = (Math.sqrt(1+4*(2L*target+(long)i*i-i)) - 1) / 2;
            // 判断 j 值是不是一个正整数，由于 double 有精度损失，所以通过差值与一个极小值进行判断
            int j = root.intValue();
            if (root - j <= Double.MIN_VALUE) {
                seqList.add(generateContinuousSequence(i, j));
            }
        }
        // 将 List 转换为二维数组并返回
        // return seqList.toArray(new int[0][]); 启用这段代码，执行用时会达到 20 ms
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
