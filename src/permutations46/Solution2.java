package permutations46;

import java.util.*;

/**
 * 思路 2：回溯 2
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了99.83%的用户
 * 内存消耗 :40 MB, 在所有 Java 提交中击败了7.32%的用户
 */
class Solution2 {
    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 不重复的数字序列
     * @return 全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> ans = new ArrayList<>(nums.length);

        // 初始化 ans 集合
        for (int num : nums) {
            ans.add(num);
        }

        visit(nums.length, ansList, ans, 0);

        return ansList;
    }


    /**
     * 回溯
     * @param length 不重复的数字序列的长度
     * @param ansList 答案集合
     * @param ans 用于排列并产生全排列的容器
     * @param first 当前已经完成排列的元素个数
     */
    private void visit(int length, List<List<Integer>> ansList, List<Integer> ans, int first) {
        // 所有元素已经完成排列，存储结果，结束递归
        if (length == first) {
            ansList.add(new ArrayList<>(ans));
            return;
        }
        // 已经有 first 个元素完成排序，因此考虑 first 位置依次放置剩余未排序的元素
        for (int i = first; i < length; i++) {
            // 考虑 i 位置的元素放入 first 位置
            Collections.swap(ans, i, first);
            // 递归
            visit(length, ansList, ans, first + 1);
            // 还原
            Collections.swap(ans, i, first);
        }


    }

}
