package shortEncodingOfWords820;

/**
 * 思路 4：trie 字典树
 *
 * 执行用时 :12 ms, 在所有 Java 提交中击败了99.45%的用户
 * 内存消耗 :47 MB, 在所有 Java 提交中击败了5.09%的用户
 */
class Solution4 {
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

        int totalLen = 0;
        final Trie trie = new Trie();

        int[] insertSuccess = new int[words.length];
        // 构造字典树，给成功加入的单词做上标记，这一步主要是为了剔出相同内容的单词
        for (int i = 0; i < words.length; i++) {
            if (trie.insert(words[i])) {
                insertSuccess[i] = 1;
            }
        }
        // 遍历成功加入字典树的单词，检查是否仍然是完整的单词，而不是其他单词的一部分。
        // 只有完整的单词，才能够加入编码。
        for (int i = 0; i < words.length; i++) {
            if (insertSuccess[i] == 1) {
                if (trie.find(words[i])) {
                    totalLen += words[i].length() + 1;
                }
            }
        }

        return totalLen;
    }
}

class Trie {
    private TrieNode root;

    Trie() {
        this.root = new TrieNode('/');
    }

    /**
     * 向字典树中加入一个新词，返回是否让树产生了新的结点
     * @param word 新加入的单词
     * @return 是否让树产生了新的结点
     */
    boolean insert(CharSequence word) {
        TrieNode p = root;
        boolean hasNewNode = false;
        for (int i = word.length()-1; i > -1; i--) {
            char c = word.charAt(i);
            if (p.children[c-'a'] == null) {
                p.childrenNum++;
                hasNewNode = true;
                p.children[c-'a'] = new TrieNode(c);
            }
            p = p.children[c-'a'];
        }
        return hasNewNode;
    }

    /**
     * 查找字典树中是否完整存在一个单词
     * @param word 查找的单词
     * @return 是否完整存在这个单词
     */
    boolean find(CharSequence word) {
        TrieNode p = root;
        for (int i = word.length()-1; i > -1; i--) {
            char c = word.charAt(i);
            if (p.children[c-'a'] == null) {
                return false;
            }
            p = p.children[c-'a'];
        }
        return p.childrenNum == 0;
    }

    class TrieNode {
        char value;
        int childrenNum = 0;
        TrieNode[] children = new TrieNode[26];

        TrieNode(char value) {
            this.value = value;
        }
    }
}