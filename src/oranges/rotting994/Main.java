package oranges.rotting994;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution3 solution = new Solution3();

        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(solution.orangesRotting(grid));  // 4

        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(solution.orangesRotting(grid2));  // -1

        int[][] grid3 = {{0,2}};
        System.out.println(solution.orangesRotting(grid3));  // 0

        int[][] grid4 = {{0,0,1,2},{2,0,1,1}};
        System.out.println(solution.orangesRotting(grid4));  // 2

        int[][] grid5 = {{1,0,0,0,2,1,0}};
        System.out.println(solution.orangesRotting(grid5));  // -1

    }

    public static void printArrays(int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
