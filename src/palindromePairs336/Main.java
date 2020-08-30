package palindromePairs336;

import utils.ArrayUtils;
import utils.AssertUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Solution2 solution = new Solution2();

        int[][] expect_1 = {{0,1}, {1,0}, {3,2}, {2,4}};
        List<List<Integer>> actual_1 = solution.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
        AssertUtils.assertEquals2DArray(ArrayUtils.primitiveTo2DObject(expect_1), ArrayUtils.listTo2DIntArray(actual_1));
        
        int[][] expect_2 = {{0,1}, {1,0}};
        List<List<Integer>> actual_2 = solution.palindromePairs(new String[]{"bat", "tab", "cat"});
        AssertUtils.assertEquals2DArray(ArrayUtils.primitiveTo2DObject(expect_2), ArrayUtils.listTo2DIntArray(actual_2));

        int[][] expect_3 = {{0,1}, {1,0}};
        List<List<Integer>> actual_3 = solution.palindromePairs(new String[]{"a", ""});
        AssertUtils.assertEquals2DArray(ArrayUtils.primitiveTo2DObject(expect_3), ArrayUtils.listTo2DIntArray(actual_3));

        int[][] expect_4 = {{3,0}, {1,3}, {4,0}, {2,4}, {5,0}, {0,5}};
        List<List<Integer>> actual_4 = solution.palindromePairs(new String[]{"a", "b", "c", "ab", "ac", "aa"});
        AssertUtils.assertEquals2DArray(ArrayUtils.primitiveTo2DObject(expect_4), ArrayUtils.listTo2DIntArray(actual_4));

        int[][] expect_5 = {{0,1}, {1,0}, {2,1}, {2,3}, {0,3}, {3,2}};
        List<List<Integer>> actual_5 = solution.palindromePairs(new String[]{"ab", "ba", "abc", "cba"});
        AssertUtils.assertEquals2DArray(ArrayUtils.primitiveTo2DObject(expect_5), ArrayUtils.listTo2DIntArray(actual_5));

    }
}
