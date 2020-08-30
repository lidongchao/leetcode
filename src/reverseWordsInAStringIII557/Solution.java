package reverseWordsInAStringIII557;

/**
 * 思路：交换字符顺序
 *
 * 执行用时：4 ms, 在所有 Java 提交中击败了93.77%的用户
 * 内存消耗：40.3 MB, 在所有 Java 提交中击败了62.32%的用户
 */
public class Solution {
    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     * 示例：
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     *  
     * 提示：
     * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 待反转的字符串
     * @return 反转后的字符串
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                // 反转每两个空格之间的子串
                reverse(chars, last + 1, i - 1);
                last = i;
            }
        }
        if (last < chars.length - 2) {
            reverse(chars, last + 1, chars.length - 1);
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
}
