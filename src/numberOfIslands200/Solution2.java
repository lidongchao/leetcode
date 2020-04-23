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

        UnionFind unionFind = new UnionFind(grid);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println(unionFind);

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

    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            count = 0;
            parent = new int[row * col];
            rank = new int[row * col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * col + j] = i * col + j;
                        count++;
                    }
                    rank[i * col + j] = 0;
                }
            }
        }

        int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = parent[rootx];
                    rank[rootx] += 1;
                }
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
