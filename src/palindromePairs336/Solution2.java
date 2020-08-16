package palindromePairs336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 思路 2：枚举前后缀
 *
 * 执行用时：82 ms, 在所有 Java 提交中击败了39.54%的用户
 * 内存消耗：41.4 MB, 在所有 Java 提交中击败了92.59%的用户
 */
class Solution2 {
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


        // 构建哈希索引
        for (int i = 0; i < words.length; i++) {
            map.put(words[i].hashCode(), i);
        }


        // 处理每一个单词
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int m = word.length();

            for (int j = 0; j <= m; j++) {
                // 判断前缀是否是回文
                if (j == 0 || isPalindrome(word, 0, j - 1)) {
                    // 当 j = 0 时，代表前缀是 ""，同样是回文，此时需要寻找整个单词的反转是否存在
                    // 前缀是回文的情况下，判断后缀的反转是否在原数组中存在
                    Integer index = map.get(reverseTail(word, m - j).hashCode());
                    if (index != null && index != i) {
                        ans.add(Arrays.asList(index, i));
                    }
                }
                // 判断后缀是否是回文
                if (j != 0 && isPalindrome(word, m - j, m - 1)) {
                    // 不再处理 j = 0 的情况，避免重复
                    // 后缀是回文的情况下，判断前缀的反转是否在原数组中存在
                    Integer index = map.get(reverseHead(word, m - j).hashCode());
                    if (index != null && index != i) {
                        ans.add(Arrays.asList(i, index));
                    }
                }
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
    private boolean isPalindrome(String s, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.reverseTail("", 1).length());
        System.out.println(solution2.reverseTail("a", 0).length());
        System.out.println(solution2.isPalindrome("abccba", 0, 5));
    }

}
