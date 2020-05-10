package permutations46;

import java.util.*;

/**
 * 思路 1：回溯 1
 *
 * 执行用时 :3 ms, 在所有 Java 提交中击败了45.79%的用户
 * 内存消耗 :40 MB, 在所有 Java 提交中击败了7.32%的用户
 */
class Solution1 {
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
        this.nums = nums;
        this.posFlags = new boolean[nums.length];

        visit();

        return ansList;
    }


    /**
     * 回溯
     */
    private void visit() {
        // 栈元素包含所有数组元素，存储结果，结束递归
        if (stack.size() == nums.length)  {
            ansList.add(new LinkedList<>(stack));
            return;
        }
        // 遍历所有元素，找到一个未访问的元素，加入到栈顶
        for (int i = 0; i < nums.length; i++) {
            if (!posFlags[i]) {
                posFlags[i] = true;
                stack.push(nums[i]);
                visit();
                stack.pop();
                posFlags[i] = false;
            }
        }
    }

    private int[] nums;
    // 辅助数组，用于标记元素是否已访问
    private boolean[] posFlags;
    // 存储当前已经排列好的元素
    private Deque<Integer> stack = new LinkedList<>();
    // 答案集合
    private List<List<Integer>> ansList = new LinkedList<>();
}
