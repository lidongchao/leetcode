package editDistance72;

/**
 * 思路：动态规划
 *
 * 执行用时 :9 ms, 在所有 Java 提交中击败了37.30%的用户
 * 内存消耗 :39.7 MB, 在所有 Java 提交中击败了5.06%的用户
 */
class Solution {
    /**
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     *
     *你可以对一个单词进行如下三种操作：
     *
     *插入一个字符
     *删除一个字符
     *替换一个字符
     * 
     *
     *来源：力扣（LeetCode）
     *链接：https://leetcode-cn.com/problems/edit-distance
     *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param word1 第一个单词
     * @param word2 第二个单词
     * @return 单词之间的编辑距离
     */
    public int minDistance(String word1, String word2) {
        final int len1 = word1.length();
        final int len2 = word2.length();

        // 假设 word.substring(0, i) = word[1..i]，word[0] = ""
        // 定义状态转移矩阵，dp[i][j] 代表 word1[1..i] 和 word2[1..j] 的编辑距离
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化边界值，word1[1..i] 到 word2[0] = "" 的编辑距离是 i，需要删除 i 个字符
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        // 同理，word1[0] = "" 到 word2[1..j] 的编辑距离是 j，需要插入 j 个字符
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // 填写状态转移矩阵
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 如果 word1[i] 和 word2[j] 相同，则：
                // word1[1..i-1] 到 word2[1..j-1] 的距离 ======= word1[1..i] 到 word2[1..j] 的距离
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                // 否则，从 dp[i-1][j-1], dp[i-1][j], dp[i][j-1] 选择一个最小的编辑距离，加一作为 dp[i][j] 的编辑距离
                // 如果选择 dp[i-1][j-1] + 1，则表明是在 dp[i-1][j-1] 的基础上替换 word1[i] 为 word2[j]，编辑距离加一
                // 如果选择 dp[i-1][j] + 1，则表明是在 dp[i-1][j] 的基础上加上 word1[i]，编辑距离加一
                // 如果选择 dp[i][j-1] + 1，则表明是在 dp[i][j-1] 的基础上加上 word2[j]，编辑距离加一
                else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
