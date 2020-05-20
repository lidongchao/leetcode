package findTheLongestSubstringContainingVowelsInEvenCounts1371;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：前缀和 + 哈希表 + 异或
 *
 * 子字符串 = 区间 = 两个前缀和的差值
 *
 * 偶数次 = 异或
 *
 * 执行用时 :52 ms, 在所有 Java 提交中击败了45.88%的用户
 * 内存消耗 :48.1 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution1 {
    /**
     * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：
     * 每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
     *
     * 提示：
     *
     * 1 <= s.length <= 5 x 10^5
     * s 只包含小写英文字母。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 字符串
     * @return 每个元音包含偶数次的最长子字符串长度
     */
    public int findTheLongestSubstring(String s) {

        Map<Integer, Integer> map = new HashMap<>();
        // 状态 0 代表 aeiou 均出现了偶次，-1 表示可以把当前子串作为最长子串
        map.put(0, -1);

        int ans = 0;
        int status = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a':
                    status ^= 'a';
                    break;
                case 'e':
                    status ^= 'e';
                    break;
                case 'i':
                    status ^= 'i';
                    break;
                case 'o':
                    status ^= 'o';
                    break;
                case 'u':
                    status ^= 'u';
                    break;
            }
            // 找到 前缀和 [0..i] 与 前缀和 [0..j]，其中 xor(0..i) = xor(0..j) = status
            // 所以 xor(0..i) ^ xor(0..j) = xor(j+1..i) = 0，代表 aeiou 均为偶数次，符合题意
            ans = Math.max(ans, i - map.getOrDefault(status, i));

            // 只存储最早出现的 xor
            if (!map.containsKey(status)) {
                map.put(status, i);
            }
        }
        return ans;
    }
}
