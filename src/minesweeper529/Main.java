package minesweeper529;

import utils.ArrayUtils;
import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        char[][] updated = solution.updateBoard(board, click);
        char[][] expected = {
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};

        AssertUtils.assertEquals2DArray(ArrayUtils.primitiveTo2DObject(expected), ArrayUtils.primitiveTo2DObject(updated));


    }
}
