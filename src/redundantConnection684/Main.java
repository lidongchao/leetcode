package redundantConnection684;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] edges = {{1,4},{3,4},{1,3},{1,2},{4,5}};
        int[] expect = {1,3};
        AssertUtils.assertEqualsArray(expect, solution.findRedundantConnection(edges));

    }
}
