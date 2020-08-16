package validParentheses20;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 思路：栈
 *
 * 执行用时：1 ms, 在所有 Java 提交中击败了98.54%的用户
 * 内存消耗：37.5 MB, 在所有 Java 提交中击败了92.50%的用户
 */
class Solution {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     * 输入: "()"
     * 输出: true
     *
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     *
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     *
     * 示例 4:
     * 输入: "([)]"
     * 输出: false
     *
     * 示例 5:
     * 输入: "{[]}"
     * 输出: true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 字符串
     * @return 是否是有效字符串
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '(') return false;
            } else if (c == ']') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '[') return false;
            } else if (c == '}') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}
