package findTheLongestSubstringContainingVowelsInEvenCounts1371;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 思路：前缀和 + 状态压缩
 *
 * 子字符串 = 区间 = 两个前缀和的差值
 *
 * 偶数次 = 使用 00000 表示 aeiou 均出现了偶数次，使用 11111 表示 aeiou 均出现了奇数次，
 * 这样就可以使用 0-31 表示元音出现奇偶次的状态，通过一个大小为 32 的数组，就能够存储每个状态最先出现的索引
 *
 * 执行用时 :16 ms, 在所有 Java 提交中击败了80.93%的用户
 * 内存消耗 :43.9 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution2 {
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
        int[] pos = new int[32];
        Arrays.fill(pos, -1);
        pos[0] = 0;

        int ans = 0;
        int xor = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a':
                    xor ^= (1 << 0);
                    break;
                case 'e':
                    xor ^= (1 << 1);
                    break;
                case 'i':
                    xor ^= (1 << 2);
                    break;
                case 'o':
                    xor ^= (1 << 3);
                    break;
                case 'u':
                    xor ^= (1 << 4);
                    break;
            }
            if (pos[xor] != -1) {
                ans = Math.max(ans, i + 1 - pos[xor]);
            }

            if (pos[xor] == -1) {
                pos[xor] = i + 1;
            }
        }
        return ans;
    }
}
