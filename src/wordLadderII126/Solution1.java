package wordLadderII126;

import java.util.*;

/**
 * 思路 1：图 + DFS + BFS
 *
 * 第一个通过的版本
 *
 * 执行用时 :521 ms, 在所有 Java 提交中击败了27.24%的用户
 * 内存消耗 :41.8 MB, 在所有 Java 提交中击败了90.00%的用户
 */
class Solution1 {
    /**
     * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     *
     * 说明:
     * 如果不存在这样的转换序列，返回一个空列表。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-ladder-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param beginWord 起始单词，不一定在字典中
     * @param endWord 结束单词，不一定在字典中
     * @param wordList 字典
     * @return 从起始单词到结束单词的最短转换序列
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> wordMap = new HashMap<>();  // 图
        Map<String, Integer> visit = new HashMap<>();  // 0=未访问 1=正在访问 2=已访问
        Queue<String> queue = new ArrayDeque<>();  // BFS 辅助队列
        Map<String, List<String>> fromMap = new HashMap<>();  // BFS 访问路径中每个点的前一个点

        // 遍历字典的每一个单词
        for (int i = 0; i < wordList.size(); i++) {
            String w1 = wordList.get(i);

            // 将能由 beginWord 转换的单词放入 queue 中，作为初始状态
            if (isNeighbour(beginWord, w1)) {
                queue.add(w1);
                visit.put(w1, 2);
                fromMap.computeIfAbsent(w1, x -> new LinkedList<>()).add(beginWord);
            } else {
                visit.put(w1, 0);
            }
            for (int j = i+1; j < wordList.size(); j++) {
                String w2 = wordList.get(j);
                if (isNeighbour(w1, w2)) {
                    wordMap.computeIfAbsent(w1, x -> new LinkedList<>()).add(w2);
                    wordMap.computeIfAbsent(w2, x -> new LinkedList<>()).add(w1);
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        boolean valid = false;

        // 词典中不存在 endWord
        if (!wordMap.containsKey(endWord)) {
            return ans;
        }

        // 两个单词相同
        if (beginWord.equals(endWord)) {
            ans.add(Collections.singletonList(beginWord));
            return ans;
        }

        // 先通过 bfs 找到 beginWord 到 endWord 的最短路径
        while (!queue.isEmpty()) {
            // 按层遍历
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                // 找到了 endWord，尽快退出循环
                if (word.equals(endWord)) {
                    valid = true;
                    break;
                }
                // 判断每个未访问、访问中的、能由当前单词 word 转换的单词
                for (String next : wordMap.get(word)) {
                    // 跳过所有已访问的单词
                    int status = visit.get(next);
                    if (status == 2) continue;
                    // 将未访问的单词加入到 queue 中，状态置为访问中，此操作对于每个单词只会执行一次
                    if (status == 0) {
                        visit.put(next, 1);
                        queue.add(next);
                    }
                    // 将 word <- next 的关系写入 fromMap
                    fromMap.computeIfAbsent(next, x -> new LinkedList<>()).add(word);
                }
            }
            // 找到 endWord，尽快退出循环
            if (valid) {
                break;
            }
            // queue 中的词，状态都是 1，自动更新为 2
            for (String s : queue) {
                visit.put(s, 2);
            }
        }

        if (valid) {
            // 再通过 dfs 还原所有最短路径
            LinkedList<String> path = new LinkedList<>();
            path.add(endWord);
            dfs(endWord, beginWord, path, ans, fromMap);
        }

        return ans;

    }

    private void dfs(String current, String endWord, LinkedList<String> path, List<List<String>> ans, Map<String, List<String>> fromMap) {
        // path 包含 beginWord -> ... -> endWord
        if (current.equals(endWord)) {
            // 复制一份
            ans.add(new ArrayList<>(path));
            return;
        }
        // 递归能到达当前单词 current 的所有单词
        for (String s : fromMap.get(current)) {
            path.addFirst(s);
            dfs(s, endWord, path, ans, fromMap);
            path.pollFirst();
        }
    }

    // 判断 word1 和 word2 能否相互转换
    private boolean isNeighbour(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        boolean diff = false;
        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if (c1 != c2) {
                if (diff) {
                    return false;
                } else {
                    diff = true;
                }
            }
        }
        return true;

    }

}
