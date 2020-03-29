package shortEncodingOfWords820;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * 思路 2：自定义排序算法，从字符串的尾字符开始比较，相同的排在一起，同时长度更长的排在前面
 *
 * 执行用时 :36 ms, 在所有 Java 提交中击败了47.37%的用户
 * 内存消耗 :40.7 MB, 在所有 Java 提交中击败了24.24%的用户
 */
class Solution2 {
    /**
     * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
     * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
     * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
     * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
     *
     * 提示：
     * 1 <= words.length <= 2000
     * 1 <= words[i].length <= 7
     * 每个单词都是小写字母 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/short-encoding-of-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words 单词列表
     * @return 压缩编码字符串的最小长度
     */
    public int minimumLengthEncoding(String[] words) {
        if (0 == words.length) return 0;
        // 自定义排序算法，从字符串的尾字符开始比较，相同的排在一起，同时长度更长的排在前面
        final Stream<String> sorted = Arrays.stream(words).sorted((x, y) -> {
            int i = 0;
            int minLen = Math.min(x.length(), y.length());
            while (i < minLen) {
                if (x.charAt(x.length() - i - 1) == y.charAt(y.length() - i - 1)) {
                    i++;
                } else {
                    return x.charAt(x.length() - i - 1) - y.charAt(y.length() - i - 1);
                }
            }
            return y.length() - x.length();
        });

        // 遍历排序后的字符串数组，如果 x# 能够压缩编码 x y z，那么一定先遍历到 x，然后紧接着遍历 y 和 z
        final Iterator<String> iter = sorted.iterator();
        String base = iter.next();
        int len = base.length();
        while (iter.hasNext()) {
            String next = iter.next();
            if (!base.endsWith(next)) {
                // 旧的 base 能够压缩编码的字符串已经没有了，替换为新的 base，且增加相应的长度
                base = next;
                // +1 是 # 的个数
                len += next.length() + 1;
            }
        }
        sorted.close();
        // 末尾还有一个 #
        return len + 1;
    }
}
