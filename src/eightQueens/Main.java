package eightQueens;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        List<List<String>> queens = solution.solveNQueens(4);
        for (List<String> row : queens) {
            System.out.println(row);
        }
    }
}
