package findLatestGroupOfSizeM5497;

import java.util.Arrays;

/**
 * 思路 1：并查集
 *
 * 执行用时：22 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：55.4 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution {
    /**
     * 给你一个数组 arr ，该数组表示一个从 1 到 n 的数字排列。有一个长度为 n 的二进制字符串，该字符串上的所有位最初都设置为 0 。
     * 在从 1 到 n 的每个步骤 i 中（假设二进制字符串和 arr 都是从 1 开始索引的情况下），二进制字符串上位于位置 arr[i] 的位将会设为 1 。
     * 给你一个整数 m ，请你找出二进制字符串上存在长度为 m 的一组 1 的最后步骤。一组 1 是一个连续的、由 1 组成的子串，且左右两边不再有可以延伸的 1 。
     *
     * 返回存在长度 恰好 为 m 的 一组 1  的最后步骤。如果不存在这样的步骤，请返回 -1 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-latest-group-of-size-m
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 提示：
     * n == arr.length
     * 1 <= n <= 10^5
     * 1 <= arr[i] <= n
     * arr 中的所有整数 互不相同
     * 1 <= m <= arr.length
     *
     * @param arr 数组
     * @param m 要求的整数
     * @return 最后一次存在长度为 m 的一组 1 的步骤序号
     */
    public int findLatestStep(int[] arr, int m) {

        int len = arr.length;
        // 通过数组记录是否已经将 0 变为 1
        boolean[] status = new boolean[len + 1];
        // 并查集维护所有连续的 1，以及这些 1 的长度
        UnionFind unionFind = new UnionFind(len);
        int last = 0;
        int step = 0;
        for (int i : arr) {
            step++;
            status[i] = true;
            unionFind.resize(i);
            // 如果左边有 1，与左边合并
            if (i > 1 && status[i-1]) {
                unionFind.union(i-1, i);
            }
            // 如果右边有 1，与右边合并
            if (i < len && status[i+1]) {
                unionFind.union(i, i+1);
            }
//            System.out.println(unionFind);
            // 查看是否有长度为 m 的一组 1
            if (unionFind.validM(m)) {
                last = step;
            }
        }
        return last == 0 ? -1 : last;
    }

    private static final class UnionFind {
        int[] parent;  // 每一组 1 都是一棵树，拥有同一个祖先
        int[] weight;  // 每个祖先的权重，权重越大说明该树越庞大，合并时通过控制大树吞并小树，可以合理控制整个树的深度
        int[] size;  // 只有祖先节点有效，记录该组的大小
        int[] sizeMap;  // 记录每个大小对应的树的个数

        UnionFind(int n) {
            parent = new int[n + 1];
            weight = new int[n + 1];
            size = new int[n + 1];
            sizeMap = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        void resize(int i) {
            size[i] = 1;
            sizeMap[1]++;
        }

        boolean validM(int m) {
            return sizeMap[m] > 0;
        }

        int find(int i) {
            if (i != parent[i]) parent[i] = find(parent[i]);
            return parent[i];
        }

        void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi == pj) return;

            sizeMap[size[pi]]--;
            sizeMap[size[pj]]--;
            sizeMap[size[pi] + size[pj]]++;
            if (weight[pi] > weight[pj]) {
                parent[pj] = pi;
                size[pi] = size[pi] + size[pj];
            } else if (weight[pi] < weight[pj]) {
                parent[pi] = pj;
                size[pj] = size[pi] + size[pj];
            } else {
                parent[pj] = pi;
                size[pi] = size[pi] + size[pj];
                weight[pi]++;
            }
        }

        @Override
        public String toString() {
            return "UnionFind{" +
                    "parent=" + Arrays.toString(parent) +
                    '}';
        }
    }
}
