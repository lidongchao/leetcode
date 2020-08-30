package minesweeper529;

import java.util.*;

/**
 * 思路：广度优先遍历
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了41.48%的用户
 * 内存消耗：40.1 MB, 在所有 Java 提交中击败了61.46%的用户
 */
class Solution {

    private static final char MINE = 'M';  // 代表一个未挖出的地雷
    private static final char EMPTY = 'E';  // 代表一个未挖出的空方块
    private static final char BLANK = 'B';  // 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块
    private static final char EXPLODE = 'X';  // 表示一个已挖出的地雷
    private static final int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    /**
     * 让我们一起来玩扫雷游戏！
     *
     * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻
     * （上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，
     * 'X' 则表示一个已挖出的地雷。
     *
     * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
     *
     * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
     * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
     * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
     * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minesweeper
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board 面板
     * @param click 点击位置
     * @return 点击后根据规则变化后的面板
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = board.length;
        int col = board[0].length;
        int x = click[0];
        int y = click[1];

        // 挖到地雷
        if (board[x][y] == MINE) {
            board[x][y] = EXPLODE;
            return board;
        }
        // 没有挖到地雷，从起点开始递归遍历
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);

        while (!queue.isEmpty()) {
            // 取出队列头的点，进行排雷
            int[] pos = queue.poll();
            assert Objects.requireNonNull(pos).length == 2;
            board[pos[0]][pos[1]] = checkMine(queue, board, row, col, pos[0], pos[1]);

        }

        return board;
    }

    /**
     * 对 board(x, y) 进行排雷，先判断周围八个点是否有雷，如果有，返回埋雷数量，不再遍历；
     * 否则当前点是 BLANK，将周围的 EMPTY 点加入队列，进行下一轮遍历
     * @param queue EMPTY 队列
     * @param board 面板
     * @param row 行数
     * @param col 列数
     * @param x 当前位置横坐标
     * @param y 当前位置纵坐标
     * @return 当前位置周围的埋雷数量
     */
    private char checkMine(Queue<int[]> queue, char[][] board, int row, int col, int x, int y) {
        int numOfMine = 0;
        List<int[]> readyToQueue = new LinkedList<>();
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                if (board[nx][ny] == MINE) {
                    numOfMine++;
                } else if (board[nx][ny] == EMPTY) {
                    readyToQueue.add(new int[]{nx, ny});
                }
            }
        }
        if (numOfMine == 0) {
            for (int[] rtq : readyToQueue) {
                board[rtq[0]][rtq[1]] = BLANK;
                queue.add(rtq);
            }
            return BLANK;
        }
        return Character.forDigit(numOfMine, 10);
    }
}
