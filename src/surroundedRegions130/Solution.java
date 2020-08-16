package surroundedRegions130;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路：多源广度优先搜索
 *
 * 执行用时：4 ms, 在所有 Java 提交中击败了27.50%的用户
 * 内存消耗：42.2 MB, 在所有 Java 提交中击败了13.24%的用户
 */
class Solution {
    /**
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     * 
     * 解释:
     * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，
     * 或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/surrounded-regions
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param board 包含 X 和 O 的二维矩阵
     */
    public void solve(char[][] board) {
        row = board.length;
        if (row == 0) return;
        col = board[0].length;
        
        boolean[][] visited = new boolean[row][col];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            if (i == 0 || i == row - 1) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') {
                        visited[i][j] = true;
                        queue.offer(id(i, j));
                    }
                }
            } else {
                if (board[i][0] == 'O') {
                    visited[i][0] = true;
                    queue.offer(id(i, 0));
                }
                if (board[i][col-1] == 'O') {
                    visited[i][col-1] = true;
                    queue.offer(id(i, col-1));
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int x = poll / col;
            int y = poll % col;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nx][ny] && board[nx][ny] == 'O') {
                    visited[nx][ny] = true;
                    queue.offer(id(nx, ny));
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
    }

    private int id(int x, int y) {
        return y + (x * col);
    }

    private int row;
    private int col;
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
}
