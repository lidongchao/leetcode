package rottingOranges994;

import java.util.HashSet;

/**
 * 暴力解法，好橘子分一堆，烂橘子分一堆，不断循环判断好橘子能不能变成烂橘子
 * 执行用时 : 12 ms, 在所有 Java 提交中击败了5.96%的用户
 * 内存消耗 : 38.9 MB, 在所有 Java 提交中击败了49.41%的用户
 */
class Solution1 {
    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     *
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     *
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotting-oranges
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid 橘子网格
     * @return 所有的橘子腐烂所需要的分钟数，-1表示不可能。
     */
    public int orangesRotting(int[][] grid) {
        // 分出好橘子和烂橘子
        HashSet<Orange> good = new HashSet<>();
        HashSet<Orange> bad = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                switch (grid[i][j]) {
                    case 0:
                        break;
                    case 1:
                        good.add(new Orange(i,j));
                        break;
                    case 2:
                        bad.add(new Orange(i,j));
                        break;
                    default:
                        break;
                }
            }
        }
        // 每一轮迭代，都将所有好橘子和烂橘子配对，看是否相邻，相邻则将好橘子变为烂橘子。
        int turn = 0;
        HashSet<Orange> infected = new HashSet<>();
        while (true) {
            for (Orange goodOrange : good) {
                for (Orange badOrange : bad) {
                    if (badOrange.nearBy(goodOrange)) {
                        infected.add(goodOrange);
                        break;
                    }
                }
            }
            // 如果迭代完成后没有好橘子变烂，则结束迭代。
            if (infected.size() == 0) break;
            // 将最近变烂的橘子从好橘子堆移至烂橘子堆
            bad.addAll(infected);
            good.removeAll(infected);
            infected.clear();
            turn++;
        }
        // 结束后如果仍有好橘子，则返回 -1，否则返回迭代次数。
        return good.size() == 0 ? turn : -1;
    }
}


class Orange {
    private int x;
    private int y;

    Orange(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 判断两个橘子是否相邻
     * @param other 判断的另一个橘子
     * @return 相邻返回 true，否则返回 false
     */
    boolean nearBy(Orange other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y) == 1;
    }
}
