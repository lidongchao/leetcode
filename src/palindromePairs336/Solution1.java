package palindromePairs336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 思路 1：枚举反转子串
 *
 * 执行用时：383 ms, 在所有 Java 提交中击败了13.59%的用户
 * 内存消耗：42.4 MB, 在所有 Java 提交中击败了45.24%的用户
 */
class Solution1 {
    /**
     * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
     *
     * 示例 1：
     * 输入：["abcd","dcba","lls","s","sssll"]
     * 输出：[[0,1],[1,0],[3,2],[2,4]]
     * 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
     *
     * 示例 2：
     * 输入：["bat","tab","cat"]
     * 输出：[[0,1],[1,0]]
     * 解释：可拼接成的回文串为 ["battab","tabbat"]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words 单词组
     * @return 能组成回文串的索引对
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        int zeroIndex = -1;  // 空串的下标

        // 构建哈希索引
        for (int i = 0; i < words.length; i++) {
            map.put(words[i].hashCode(), i);
            if (words[i].length() == 0) {
                zeroIndex = i;
            }
        }

        // 处理每一个单词
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // 单词集合中存在空串，特殊处理
            if (zeroIndex != -1) {
                if (zeroIndex != i && isPalindrome(word)) {
                    ans.add(Arrays.asList(zeroIndex, i));
                    ans.add(Arrays.asList(i, zeroIndex));
                }
            }
            // 对该单词截取不同长度的子串并反转，判断在原数组中是否存在，截取子串的长度从 1 一直到 word.length()-1
            for (int j = 1; j < word.length(); j++) {
                // 截取后部分并反转
                String tail = reverseTail(word, j);
                Integer indexTail = map.get(tail.hashCode());
                // 如果 indexTail 存在，而且不是自身，而且 word 截取后剩余的部分也是回文串，那么 indexTail 和 i 能够构成一个索引对
                if (indexTail != null && indexTail != i && isPalindrome(word.substring(0, word.length() - j))) {
                    ans.add(Arrays.asList(indexTail, i));
                }
                // 截取前部分并反转
                String head = reverseHead(word, j);
                Integer indexHead = map.get(head.hashCode());
                // 如果 indexHead 存在，而且不是自身，而且 word 截取后剩余的部分也是回文串，那么 indexHead 和 i 能够构成一个索引对
                if (indexHead != null && indexHead != i && isPalindrome(word.substring(j))) {
                    ans.add(Arrays.asList(i, indexHead));
                }
            }
            // 对没有截取的原字符串，搜索有没有镜像字符串
            Integer indexWhole = map.get(reverseHead(word, word.length()).hashCode());
            if (indexWhole != null && indexWhole != i) {
                ans.add(Arrays.asList(indexWhole, i));
            }
        }

        return ans;
    }

    // 截取后 len 位并反转
    private String reverseTail(String str, int len) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        int last = chars.length - 1;
        len = Math.min(chars.length, len);
        for (int i = 0; i < len; i++) {
            sb.append(chars[last - i]);
        }
        return sb.toString();
    }

    // 截取前 len 位并反转
    private String reverseHead(String str, int len) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        len = Math.min(chars.length, len);
        for (int i = len - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    // 判断是否为回文
    private boolean isPalindrome(String s) {
        return s.equals(reverseTail(s, s.length()));
    }

}
