package shortEncodingOfWords820;

import java.util.HashSet;
import java.util.Set;

/**
 * 思路 1：暴力法，将每个单词与其他单词比较，如果被其他单词包含 (其他单词 endsWith 该单词)，说明该单词可以被压缩掉
 *
 * 时间复杂度 O(n^2)
 *
 * 执行用时 :1747 ms, 在所有 Java 提交中击败了5.07%的用户
 * 内存消耗 :40.8 MB, 在所有 Java 提交中击败了24.24%的用户
 */
class Solution1 {
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

        // 单词总长度
        int totalLength = 0;
        // 已压缩的单词数量，控制 # 的数量
        int compress = 0;
        // 相同单词的索引
        Set<Integer> equals = new HashSet<>();
        // 从头到尾依次取出字符串
        for (int i = 0; i < words.length; i++) {
            // 如果发现此前出现过相同的字符串，则直接跳过，不需要做任何处理
            if (equals.contains(i)) continue;
            // 增加单词总长度
            totalLength += words[i].length();
            // 从尾部开始遍历单词列表，查看是否有字符串包含 words[i]
            for (int j = words.length-1; j > -1; j--) {
                if (i == j) continue;
                // 如果发现有字符串包含了 words[i]，则 words[i] 是可以被压缩的单词，减去相应的长度
                if (words[i].length() < words[j].length() && words[j].endsWith(words[i])) {
                    totalLength -= words[i].length();
                    compress++;
                    break;
                }
                // 如果发现有字符串与 words[i] 相同，则这些相同的字符串都是可以被压缩的单词，同时标记这些字符串，下次遍历的时候直接跳过
                if (words[i].length() == words[j].length() && words[i].equals(words[j])) {
                    equals.add(j);
                    compress++;
                }
            }
        }

        return totalLength + words.length - compress;
    }
}
