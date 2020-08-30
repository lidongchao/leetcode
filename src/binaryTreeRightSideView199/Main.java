package binaryTreeRightSideView199;

import utils.ArrayUtils;
import utils.AssertUtils;
import utils.TreeNode;
import utils.TreeUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        Integer[] tree = {1,2,3,null,5,null,4};
        TreeNode root = TreeUtils.construct(tree);
        int[] expect = {1,3,4};
        AssertUtils.assertEqualsArray(expect, ArrayUtils.objectToPrimitive(solution.rightSideView(root).toArray(new Integer[0])));

    }
}
