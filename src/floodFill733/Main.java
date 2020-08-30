package floodFill733;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
        int[][] expect = {{2,2,2},{2,2,0},{2,0,1}};
        AssertUtils.assertEquals2DArray(expect, solution.floodFill(image, sr, sc, newColor));

    }
}
