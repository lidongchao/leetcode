package generateParentheses22;

import java.util.LinkedList;
import java.util.List;

/**
 * 思路：回溯 + 递归
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了98.00%的用户
 * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了5.68%的用户
 */
class Solution {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n 生成括号的对数
     * @return 所有有效括号组合
     */
    public List<String> generateParenthesis(int n) {
        ans = new LinkedList<>();

        int left = 0;

        put(left, "", 0, n);

        return ans;
    }

    private void put(int left, String s, int i, int n) {
        // 先考虑加左括号，前提是没有到达上限 n
        if (i < n) {
            left++;
            put(left, s + "(", i + 1, n);
            left--;
        }

        // 再考虑加右括号，前提是还有左括号可以匹配
        if (left != 0) {
            left--;
            put(left, s + ")", i, n);
            // left++; 后面用不到，没有必要
        } else {
            // 没有左括号可以匹配的情况下，确认是否左括号数量达到上限，是的话，将该括号组合加入到结果集中
            if (i >= n) {
                ans.add(s);
            }
        }

    }

    private List<String> ans;

}
