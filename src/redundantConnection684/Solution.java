package redundantConnection684;

/**
 * 思路：并查集
 *
 * 寻找最小生成树的 Kruskal 算法，就是使用的贪心算法与并查集。
 * 算法步骤：
 * 1. 初始化并查集和最小生成树，此时树中只有节点，没有边，节点之间均没有连通，所以并查集中的每一个节点的父节点都是自己。
 * 2. 根据权重对边进行排序，利用贪心算法优先遍历权重更低的点。
 * 3. 依次遍历排序后的边，如果该边的两个点没有连通，则将边加入树中，同时在并查集中将两个点连通。
 *
 * 另一种最小生成树的算法是 Prim 算法，本质是贪心算法与小顶堆。
 * 算法步骤：
 * 1. 初始化一个访问数组，用于标记已加入最小生成树的节点。
 * 2. 选择任意一个节点作为原点，标记为已访问，并将该点相关的所有边加入小顶堆。
 * 3. 每次从小顶堆中取出权重最小的边，如果该边的两个点都已经访问过，则忽略，否则将没有访问的点标记为已访问，并将该点相关的所有边加入小顶堆。
 * 4. 重复上一步骤，直到所有点都已标记为已访问。
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了33.33%的用户
 * 内存消耗：40.3 MB, 在所有 Java 提交中击败了26.78%的用户
 */
class Solution {
    /**
     * 在本问题中, 树指的是一个连通且无环的无向图。
     * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，
     * 这条附加的边不属于树中已存在的边。
     *
     * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
     * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
     *
     * 注意:
     * 输入的二维数组大小在 3 到 1000。
     * 二维数组中的整数在1到N之间，其中N是输入数组的大小。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/redundant-connection
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param edges 边集合
     * @return 附加边
     */
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(1000);

        for (int[] edge : edges) {
            if (unionFind.isConnected(edge[0], edge[1])) {
                return edge;
            }
            unionFind.union(edge[0], edge[1]);
        }
        return null;
    }

    private static class UnionFind {
        int[] parent;
        int[] weight;

        UnionFind(int num) {
            parent = new int[num + 1];
            weight = new int[num + 1];
            for (int i = 0; i < num; i++) {
                parent[i] = i;
            }
        }

        public void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi == pj) {
                return;
            }
            // 按秩合并
            if (weight[pi] > weight[pj]) {
                parent[pj] = pi;
            } else if (weight[pi] < weight[pj]) {
                parent[pi] = pj;
            } else {
                parent[pj] = pi;
                weight[pi]++;
            }
        }

        public int find(int i) {
            // 路径压缩
            if (i != parent[i]) parent[i] = find(parent[i]);
            return parent[i];
        }

        public boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }

    }
}