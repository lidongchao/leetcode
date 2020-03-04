package oranges.rotting994;

/**
 * 不用额外空间，不断扫描网格，每一轮都只关注好橘子和烂橘子的右方和下方
 * 如果好橘子的右方和下方是烂橘子，则好橘子变烂
 * 如果烂橘子的右方和下方是好橘子，则好橘子变烂
 * 需要额外注意区分本轮变烂的橘子和此前变烂的橘子，前者没有传染能力，不能算作上面所说的烂橘子
 * 执行用时 : 2 ms, 在所有 Java 提交中击败了97.47%的用户
 * 内存消耗 : 38 MB, 在所有 Java 提交中击败了62.74%的用户
 */
class Solution2 {
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
        int turn = 0;
        boolean stillFresh;
        boolean rotting;
        // 烂度-2 表示是第几分钟腐烂的
        while (true) {
            rotting = false;
            stillFresh = false;
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    // 以前的烂橘子，可以腐烂右边和下边的新鲜橘子，同时烂度加一
                    if (grid[x][y] == 2 + turn) {
                        rotting |= rottingRightAndDown(grid, x, y, turn);
                        grid[x][y]++;
                    } else if (grid[x][y] == 1) {
                        // 新鲜橘子，看看右边和下边有没有烂橘子，判断自己是否会腐烂
                        if (peekRightAndDown(grid, x, y, turn)) {
                            grid[x][y] = 2 + turn + 1;
                            rotting = true;
                        } else {
                            stillFresh = true;
                        }
                    } else {
                        // 空地和当天腐烂的橘子会走到这里来
                        // continue;
                    }
                }
            }
            if (!rotting) break;
            turn++;
        }
        if (stillFresh) return -1;
        return turn;
    }

    /**
     * 腐烂右边和下边的新鲜橘子
     * @param grid 网格
     * @param x 当前烂橘子的 x 坐标
     * @param y 当前烂橘子的 y 坐标
     * @param turn 当前天数
     * @return 是否产生新的烂橘子
     */
    private static boolean rottingRightAndDown(int[][] grid, int x, int y, int turn) {
        boolean rotting = false;
        if (x != grid.length-1 && grid[x+1][y] == 1) {
            grid[x+1][y] = 2 + turn + 1;
            rotting = true;
        }
        if (y != grid[0].length-1 && grid[x][y+1] == 1) {
            grid[x][y+1] = 2 + turn + 1;
            rotting = true;
        }
        return rotting;
    }

    /**
     * 看一看右边和下边有没有非当天新产生的烂橘子
     * @param grid 网格
     * @param x 当前新鲜橘子的 x 坐标
     * @param y 当前新鲜橘子的 y 坐标
     * @param turn 当前天数
     * @return 是否存在非当天新产生的烂橘子
     */
    private static boolean peekRightAndDown(int[][] grid, int x, int y, int turn) {
        return ( (x != grid.length-1 && grid[x+1][y] > 1 && grid[x+1][y] <= 2+turn ) ||
                (y != grid[0].length-1 && grid[x][y+1] > 1 && grid[x][y+1] <= 2+turn) );
    }
}
