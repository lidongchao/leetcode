package longestCommonPrefix14;

/**
 * 思路 2：二分
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了78.40%的用户
 * 内存消耗 :37.7 MB, 在所有 Java 提交中击败了27.50%的用户
 */
class Solution2 {
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

        // 找到最短的字符串及其长度
        int minLen = Integer.MAX_VALUE;
        String s = "";
        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
                s = str;
            }
        }

        // 最长公共前缀肯定不会超过最短的字符串
        // 所以在 0 到 minLen-1 之间找到一个值 x，使得 s[0..x] 是 strs 的公共前缀，s[0..x+1] 不是 strs 的公共前缀
        int low = 0;
        int high = minLen-1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            String sub = s.substring(0, mid+1);
            if (commonPrefix(strs, sub)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return s.substring(0, low);
    }

    // 判断 prefix 是不是 strs 的公共前缀
    private boolean commonPrefix(String[] strs, String prefix) {
        for (String str : strs) {
            if (!str.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
