package longestConsecutiveSequence128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 思路 1：并查集
 *
 * 执行用时 :28 ms, 在所有 Java 提交中击败了13.44%的用户
 * 内存消耗 :42.6 MB, 在所有 Java 提交中击败了8.33%的用户
 */
class Solution1 {
    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * 要求算法的时间复杂度为 O(n)。
     *
     * 示例:
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 未排序的整数数组
     * @return 最长连续序列的长度
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        UnionFind unionFind = new UnionFind(nums);

        for (int num : nums) {
            // System.out.println(unionFind);
            if (unionFind.exist(num-1)) {
                unionFind.union(num, num-1);
            }
            if (unionFind.exist(num+1)) {
                unionFind.union(num, num+1);
            }
        }

        Map<Integer, Integer> ans = new HashMap<>();
        Set<Integer> dedup = new HashSet<>();

        for (int num : nums) {
            if (dedup.contains(num)) {
                continue;
            }
            dedup.add(num);
            int p = unionFind.parent(num);
            ans.put(p, ans.getOrDefault(p, 0) + 1);
        }

        return ans.values().stream().max(Integer::compareTo).orElse(0);
    }


    class UnionFind {

        Map<Integer, Integer> parent;  // 节点的祖先节点
        Map<Integer, Integer> rank;    // 节点的辈份权重

        UnionFind(int[] nums) {
            parent = new HashMap<>();
            rank = new HashMap<>();

            for (int num : nums) {
                parent.put(num, num);
                rank.put(num, 0);
            }
        }

        int parent(int i) {
            if (parent.get(i) != i) parent.put(i, parent(parent.get(i)));
            return parent.get(i);
        }

        void union(int i, int j) {
            int pi = parent(i);
            int pj = parent(j);
            if (pi != pj) {
                if (rank.get(pi) > rank.get(pj)) {
                    parent.put(pj, pi);
                }
                else if (rank.get(pi) < rank.get(pj)) {
                    parent.put(pi, pj);
                }
                else {
                    parent.put(pj, pi);
                    rank.put(pi, rank.get(pi) + 1);
                }
            }
        }

        boolean exist(int i) {
            return parent.containsKey(i);
        }

        @Override
        public String toString() {
            return "UnionFind{" +
                    "parent=" + parent +
                    ", rank=" + rank +
                    '}';
        }
    }
}
