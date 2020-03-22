package findWordsThatCanBeFormedByCharacters1160;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路 1：哈希表记录字符出现的次数
 *
 * 执行用时 :58 ms, 在所有 Java 提交中击败了22.50%的用户
 * 内存消耗 :42.6 MB, 在所有 Java 提交中击败了5.08%的用户
 */
class Solution1 {
    /**
     * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
     * 注意：每次拼写时，chars 中的每个字母都只能用一次。
     * 返回词汇表 words 中你掌握的所有单词的 长度之和。
     *
     * 所有字符串中都仅包含小写英文字母。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words 词汇表
     * @param chars 字母表
     * @return 掌握的所有单词的长度之和
     */
    public int countCharacters(String[] words, String chars) {
        int ans = 0;

        Map<Character, Integer> dict = generateDict(chars);

        for (String w : words) {
            if (spellWord(w, dict)) {
                ans += w.length();
            }
        }

        return ans;
    }

    /**
     * 检查是否能用字典拼写词汇
     * @param word 词汇
     * @param dict 字典
     * @return 是否能够拼写
     */
    private boolean spellWord(String word, Map<Character, Integer> dict) {
        boolean containsWord = true;
        Map<Character, Integer> wordMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
        }
        for (char c : word.toCharArray()) {
            if (wordMap.get(c) > dict.getOrDefault(c, 0)) {
                containsWord = false;
                break;
            }
        }

        return containsWord;
    }

    /**
     * 根据字母表生成字典
     * @param chars 字母表
     * @return HashMap 字典
     */
    private Map<Character, Integer> generateDict(String chars) {
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : chars.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }
        return dict;
    }
}
