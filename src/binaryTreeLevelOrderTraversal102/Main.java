package binaryTreeLevelOrderTraversal102;

import utils.AssertUtils;
import utils.TreeUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        Integer[] nodes = {3,9,20,null,null,15,7};
        List<List<Integer>> ans = solution.levelOrder(TreeUtils.construct(nodes));
        AssertUtils.assertEquals(3, ans.size());
        AssertUtils.assertEquals(3, ans.get(0).get(0));
        AssertUtils.assertEquals(9, ans.get(1).get(0));
        AssertUtils.assertEquals(20, ans.get(1).get(1));
        AssertUtils.assertEquals(15, ans.get(2).get(0));
        AssertUtils.assertEquals(7, ans.get(2).get(1));
    }
}
