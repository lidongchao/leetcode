package reverseWordsInAString151;

/**
 * 思路 2：在思路 1 的基础上，从后往前切割单词，每得到一个单词，就放进输出缓存里。
 *
 * 执行用时 :3 ms, 在所有 Java 提交中击败了71.20%的用户
 * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了5.41%的用户
 */
class Solution2 {
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

        // 切割单词，p 指向单词第一个字符的前一位，q 指向单词最后一个字符
        int p , q;
        p = q = s.length() - 1;

        StringBuilder sb = new StringBuilder(s.length());

        while (p >= 0) {
            // 遇到空格，可以切割单词
            if (s.charAt(p) == ' ') {
                // 判断是否有指向一个单词
                if (p != q) {
                    // 将单词放进 StringBuilder 里
                    if (sb.length() != 0) sb.append(" ");
                    sb.append(s.substring(p+1, q+1));
                }
                p--;
                q = p;
            } else {
                p--;
            }
        }
        // 最后 q 为 s.length() 时，如果指向一个单词，则会来不及处理，所以这里需要处理
        if (p != q) {
            if (sb.length() != 0) sb.append(" ");
            sb.append(s.substring(p+1, q+1));
        }

        return sb.toString();
    }
}
