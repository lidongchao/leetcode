package numberOfIslands200;

import java.util.Arrays;

/**
 * 思路 2：并查集
 *
 * 执行用时 :9 ms, 在所有 Java 提交中击败了10.41%的用户
 * 内存消耗 :42.1 MB, 在所有 Java 提交中击败了6.25%的用户
 */
class Solution2 {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid 地图
     * @return 岛的数量
     */
    public int numIslands(char[][] grid) {
        if (null == grid || 0 == grid.length || 0 == grid[0].length) return 0;

        // 地图的行数和列数
        int row = grid.length;
        int col = grid[0].length;

        // 使用地图初始化并查集
        UnionFind unionFind = new UnionFind(grid);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println(unionFind);

                // 将访问到的每一个陆地，都和相邻的陆地做并查集的合并操作，同时删除该陆地，避免重复合并
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';

                    if (i - 1 >= 0 && i - 1 < row && grid[i-1][j] == '1') {
                        unionFind.union(i * col + j, (i - 1) * col + j);
                    }
                    if (i + 1 >= 0 && i + 1 < row && grid[i+1][j] == '1') {
                        unionFind.union(i * col + j, (i + 1) * col + j);
                    }
                    if (j - 1 >= 0 && j - 1 < col && grid[i][j-1] == '1') {
                        unionFind.union(i * col + j, i * col + (j - 1));
                    }
                    if (j + 1 >= 0 && j + 1 < col && grid[i][j+1] == '1') {
                        unionFind.union(i * col + j, i * col + (j + 1));
                    }
                }
            }
        }
        return unionFind.count;
    }

    // 并查集
    class UnionFind {
        int count;    // 陆地节点数量
        int[] parent; // 每个节点的祖先节点
        int[] rank;   // 每个节点的辈份权重

        UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            count = 0;
            parent = new int[row * col];
            rank = new int[row * col];
            // 初始化两个数组
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        // 每个陆地的 parent 都是自己
                        parent[i * col + j] = i * col + j;
                        count++;
                    }
                    // 所有陆地的 rank 初始化为 0
                    rank[i * col + j] = 0;
                }
            }
        }

        // 寻找节点 i 的祖先节点，顺便修正因合并两个家族树带来的祖先变更的问题
        int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        // 合并 x 所在的家族树和 y 所在的家族树为一个更大的家族树
        void union(int x, int y) {
            // 找到 x 和 y 的祖先节点
            int rootx = find(x);
            int rooty = find(y);
            // 不同才需要合并
            if (rootx != rooty) {
                // rootx 的辈份更高，rooty 认 rootx 为祖先
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                }
                // rooty 的辈份更高，rootx 认 rooty 为祖先
                else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                }
                // 两个辈份相同，认为规定让 rooty 认 rootx 为祖先，同时提升 rootx 的辈份
                else {
                    parent[rooty] = parent[rootx];
                    rank[rootx] += 1;
                }
                // 合并后节点数量减少
                count--;
            }
        }

        @Override
        public String toString() {
            return "UnionFind{" +
                    "count=" + count +
                    ", parent=" + Arrays.toString(parent) +
                    ", rank=" + Arrays.toString(rank) +
                    '}';
        }
    }
}
