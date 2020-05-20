package validPalindromeII680;

/**
 * 思路 1：贪心
 *
 * 执行用时 :7 ms, 在所有 Java 提交中击败了97.33%的用户
 * 内存消耗 :40.6 MB, 在所有 Java 提交中击败了6.67%的用户
 */
class Solution {
    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     *
     * 注意:
     * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 非空字符串
     * @return 字符串是否在最多删除一个字符的情况下成为回文字符串
     */
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        // 第一部分：不删除字符的情况下从头尾两端开始判断是否是回文
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        // 不删除任何字符的情况下已经是回文
        if (i >= j) return true;

        // 第二部分：不删除字符无法成为回文字符串，所以先尝试删除 i 指向的字符，继续判断剩下的字符是否是回文
        int p = i+1;
        int q = j;
        while (p < q && s.charAt(p) == s.charAt(q)) {
            p++;
            q--;
        }
        // 删除 i 指向的字符后是回文
        if (p >= q) return true;

        // 第三部分，删除 i 指向字符后无法成为回文字符串，继续尝试删除 j 指向的字符，判断剩下的字符是否是回文
        p = i;
        q = j-1;
        while (p < q && s.charAt(p) == s.charAt(q)) {
            p++;
            q--;
        }
        // 返回删除 j 指向的字符后是否是回文
        return p >= q;
    }
}
