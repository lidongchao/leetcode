package gameOfLife289;

/**
 * 思路 1：另开辟一个面板存储下一个状态，然后遍历每一个细胞，根据周围活细胞数量判断该细胞的状态，并写入到新的面板中。
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了37.80%的用户
 * 内存消耗 :38.4 MB, 在所有 Java 提交中击败了5.71%的用户
 */
public class Solution1 {
    /**
     * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
     * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），
     * 或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
     *
     * 1. 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
     * 2. 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     * 3. 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
     * 4. 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
     *
     * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
     * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/game-of-life
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board 面板
     */
    public void gameOfLife(int[][] board) {
        if (null == board || board.length == 0 || board[0].length == 0) return;

        row = board.length;
        col = board[0].length;

        final int[][] newBoard = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 遍历每一个细胞，计算出周围八个位置的活细胞数量
                final int liveAround = checkAround(board, i, j);
                // 根据当前细胞状态和周围活细胞数量，得到当前细胞的下一个状态
                if (board[i][j] == 1) {
                    if (liveAround > 3 || liveAround < 2) {
                        newBoard[i][j] = 0;
                    } else {
                        newBoard[i][j] = 1;
                    }
                } else {
                    if (liveAround == 3) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    /**
     * 检查细胞周围八个位置的活细胞数量并返回
     * @param board 面板
     * @param x 待检查的细胞横坐标
     * @param y 待检查的细胞纵坐标
     * @return 待检查的细胞周围八个位置的活细胞数量
     */
    private int checkAround(int[][] board, int x, int y) {
        int liveAround = 0;
        int[][] directions = {{-1, -1},{-1, 0},{-1, 1},{0, -1},{0, 1},{1, -1},{1, 0},{1, 1}};
        for (int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];
            if (newX >= 0 && newX < row && newY >= 0 && newY < col && board[newX][newY] == 1) {
                liveAround++;
            }
        }
        return liveAround;
    }

    private int row;
    private int col;
}
