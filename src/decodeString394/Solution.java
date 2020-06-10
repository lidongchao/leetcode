package decodeString394;

import java.util.*;

/**
 * 思路：栈
 * 执行用时 :4 ms, 在所有 Java 提交中击败了33.05%的用户
 * 内存消耗 :38.1 MB, 在所有 Java 提交中击败了7.69%的用户
 */
class Solution {
    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/decode-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 经过编码的字符串
     * @return 解码后的字符串
     */
    public String decodeString(String s) {
        // 数字栈
        Deque<Integer> numStack = new ArrayDeque<>();
        // 暂存数字字符
        StringBuilder numHelper = new StringBuilder();
        // 字符栈
        Deque<Character> charStack = new ArrayDeque<>();
        // 暂存 [ ] 之间的字符
        LinkedList<Character> charHelper = new LinkedList<>();

        // 一次解析一个字符
        for (char c : s.toCharArray()) {
            // 数字字符压入辅助 numHelper
            if (Character.isDigit(c)) {
                numHelper.append(c);
            }
            // 字符压入字符栈，同时 numHelper 中的字符组成一个完整的数字压入数字栈
            else if (c == '[') {
                charStack.push(c);
                numStack.push(Integer.valueOf(numHelper.toString()));
                numHelper = new StringBuilder();
            }
            // 字符压入字符栈
            else if (Character.isLetter(c)) {
                charStack.push(c);
            }
            // 将 [ 到栈顶的字符全部出栈，头插法加入到辅助 charHelper，
            // 然后取出数字栈的栈顶数字 i，将 charHelper 字符循环 i 次，写回字符栈
            else {
                charHelper.clear();
                char top;
                while ((top = charStack.pop()) != '[') {
                    charHelper.addFirst(top);
                }
                Integer times = numStack.pop();
                for (int i = 0; i < times; i++) {
                    for (char in : charHelper) {
                        charStack.push(in);
                    }
                }
            }
        }

        // 从栈底开始顺序取出字符栈的字符
        StringBuilder sb = new StringBuilder();
        while (!charStack.isEmpty()) {
            sb.append(charStack.pollLast());
        }

        return sb.toString();
    }
}
