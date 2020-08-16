package bestSightseeingPair1014;

/**
 * 思路 2：迭代
 *
 * 执行用时 :4 ms, 在所有 Java 提交中击败了87.96%的用户
 * 内存消耗 :48.3 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution2 {
    /**
     * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
     * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
     * 返回一对观光景点能取得的最高分。
     *  
     * 示例：
     * 输入：[8,1,5,2,6]
     * 输出：11
     * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
     *  
     * 提示：
     * 2 <= A.length <= 50000
     * 1 <= A[i] <= 1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param A 正整数数组
     * @return 最高的一对景点的评分
     */
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0;  // 遍历前：截止到前一个点的一对景点最高分
        int max = 0;  // 遍历前：以当前点的视角，前面所有点中的单个点最高分

        // 以当前点的含义：从下标 1 看下标 0，值为 A[0]-1，从下标 2 看 下标 0，值为 A[0]-2。
        // 例如，对于当前下标 i，前面 A[0..i-1] 的点中的单个点最高分为 max；
        // 如果当前下标向后移动到 i+1，前面 A[0..i-1] 的点中的单个点最高分就变成了 max-1，再和 A[i]-1 比较，更大者作为前面 A[0..i] 的点中的单个点最高分。

        for (int value : A) {
            ans = Math.max(ans, value + max);  // 遍历后：A[i]+max 和 ans 比较，更大者作为截止到当前的一对景点最高分
            max = Math.max(max - 1, value - 1);  // 遍历后：以下一个点的视角，前面所有点中的单个点最高分
        }

        return ans;
    }
}
