package longestPalindromicSubstring5;

/**
 * 思路 2：动态规划 DP
 *
 * 执行用时 :138 ms, 在所有 Java 提交中击败了34.47%的用户
 * 内存消耗 :42.6 MB, 在所有 Java 提交中击败了14.28%的用户
 */
class Solution2 {
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

        int len = s.length();

        // dp[i][j] 存储的是 子串[i..j] 是否是回文子串。
        // i > j 时，dp[i][j] 无意义；
        // i == j 时，dp[i][j] = true，一个字符必然是回文子串；
        // i == j-1 or i == j-2 时，dp[i][j] = (s[i] == s[j])，长度为 2 或 3 的子串，是否为回文子串取决于 s[i] 和 s[j] 是否相等；
        // j - i > 2 时，dp[i][j] == (s[i] == s[j] && dp[i+1][j-1)，子串是否为回文子串取决于 s[i] 和 s[j] 是否相等，
        // 且去掉 s[i] 和 s[j] 后是否依旧是回文子串。
        boolean[][] dp = new boolean[len][len];

        // 记录当前最长回文子串的起始位置和最大长度，初始化 s[0] 是回文子串。
        int start = 0, maxLen = 1;

        // i 从后往前，j 从小往大
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                // 长度为 2 或 3 的子串
                if (j - i <= 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }
                // 如果找到更长的回文子串，更新起始位置和最大长度
                if (dp[i][j] && j-i+1 > maxLen) {
                    maxLen = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
