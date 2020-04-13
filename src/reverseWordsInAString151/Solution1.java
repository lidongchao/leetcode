package reverseWordsInAString151;

import java.util.Stack;

/**
 * 思路 1：用先进后出的栈模拟反转的过程
 *
 * 执行用时 :4 ms, 在所有 Java 提交中击败了59.37%的用户
 * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了5.41%的用户
 */
class Solution1 {
    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * 说明：
     *
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 字符串
     * @return 反转字符串中每个单词后的新字符串
     */
    public String reverseWords(String s) {
        Stack<String> bucket = new Stack<>();

        // 切割单词，p 指向单词第一个字符，q 指向单词最后一个字符的后一位
        int p , q;
        p = q = 0;

        while (q != s.length()) {
            // 遇到空格，可以切割单词
            if (s.charAt(q) == ' ') {
                // 判断是否有指向一个单词
                if (p != q) {
                    // 将单词放进栈里
                    bucket.push(s.substring(p, q));
                }
                q++;
                p = q;
            } else {
                q++;
            }
        }
        // 最后 q 为 s.length() 时，如果指向一个单词，则会来不及处理，所以这里需要处理
        if (p != q) {
            bucket.push(s.substring(p, q));
        }

        // 反转单词
        StringBuilder sb = new StringBuilder(s.length());
        boolean needSpace = false;
        while (!bucket.empty()) {
            if (needSpace) {
                sb.append(" ");
            } else {
                needSpace = true;
            }
            sb.append(bucket.pop());
        }
        return sb.toString();
    }
}
