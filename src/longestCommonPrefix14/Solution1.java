package longestCommonPrefix14;

/**
 * 思路 1：纵向比较
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了78.40%的用户
 * 内存消耗 :37.6 MB, 在所有 Java 提交中击败了42.50%的用户
 */
class Solution1 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     *
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     *
     * 说明:
     * 所有输入只包含小写字母 a-z 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs 字符串数组
     * @return 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int prefix = 0;
        boolean diff = false;

        while (prefix < minLen) {
            char c = strs[0].charAt(prefix);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(prefix) != c) {
                    diff = true;
                    break;
                }
            }
            if (diff) break;
            prefix++;
        }

        return strs[0].substring(0, prefix);
    }
}
