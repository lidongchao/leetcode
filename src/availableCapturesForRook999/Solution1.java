package availableCapturesForRook999;

/**
 * 思路 1：暴力法，找到 R，然后上下左右试探能否捕获到 p
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了5.40%的用户
 */
public class Solution1 {
    /**
     * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
     * 它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
     *
     * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，
     * 直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
     *
     * 返回车能够在一次移动中捕获到的卒的数量。
     *
     * 提示：
     *   + board.length == board[i].length == 8
     *   + board[i][j] 可以是 'R'，'.'，'B' 或 'p'
     *   + 只有一个格子上存在 board[i][j] == 'R'
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/available-captures-for-rook
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board 棋盘
     * @return 能够被 R 捕获的 p 的数量
     */
    public int numRookCaptures(char[][] board) {
        int ans = 0;
        int i, j = 0;
        // 找到 R 就可以跳出循环了
        findR:
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') break findR;
            }
        }
        // 向上
        int k = 1;
        while (i-k >= 0) {
            if (board[i-k][j] == 'B') break;
            if (board[i-k][j] == 'p') {
                ans++;
                break;
            }
            k++;
        }
        // 向左
        k = 1;
        while (j-k >= 0) {
            if (board[i][j-k] == 'B') break;
            if (board[i][j-k] == 'p') {
                ans++;
                break;
            }
            k++;
        }
        // 向下
        k = 1;
        while (i+k < board.length) {
            if (board[i+k][j] == 'B') break;
            if (board[i+k][j] == 'p') {
                ans++;
                break;
            }
            k++;
        }
        // 向右
        k = 1;
        while (j+k < board[0].length) {
            if (board[i][j+k] == 'B') break;
            if (board[i][j+k] == 'p') {
                ans++;
                break;
            }
            k++;
        }

        return ans;
    }
}
