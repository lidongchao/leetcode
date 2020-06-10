package longestPalindromicSubstring5;

/**
 * 思路 1：中心扩散法
 *
 * 执行用时 :33 ms, 在所有 Java 提交中击败了75.71%的用户
 * 内存消耗 :38.2 MB, 在所有 Java 提交中击败了25.89%的用户
 */
class Solution1 {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }

        int start = 0;
        int maxLen = 0;

        // 将每个字符作为中心，向两边扩散，查看能组成的最长回文子串长度是多少
        for (int i = 0; i < s.length()-1; i++) {
            // 以 i 作为中心，得到的回文子串长度是奇数
            int l1 = isPalindrome(s, i, i);
            // 以 i 和 i+1 作为中心，得到的回文子串长度是偶数
            int l2 = isPalindrome(s, i, i + 1);
            // 与当前最长的回文子串长度相比较，如果更长，则记录中心点和长度
            int l = Math.max(l1, l2);
            if (l > maxLen) {
                maxLen = l;
                start = i;
            }
        }
        // 通过中心点和长度切割字符串
        return s.substring(start - (maxLen - 1) / 2, start + maxLen / 2 + 1);
    }

    // 返回以 c1 c2 为中心所能找到的最长回文子串的长度
    private int isPalindrome(String s, int c1, int c2) {
        int i = c1;
        int j = c2;
        // 循环结束时，[i+1 .. j-1] 就是以 c1 c2 为中心的最长回文子串
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
