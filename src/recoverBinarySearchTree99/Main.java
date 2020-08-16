package recoverBinarySearchTree99;

import utils.AssertUtils;
import utils.TreeNode;
import utils.TreeUtils;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        test(new Integer[]{3, 1, 4, null, null, 2});
        test(new Integer[]{2, 1, null, null, 3});
    }

    private static void test(Integer[] nodeVal) {
        TreeNode root1 = TreeUtils.construct(nodeVal);
        TreeNode root2 = TreeUtils.construct(nodeVal);

        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();

        solution2.recoverTree(root1);
        solution3.recoverTree(root2);

        AssertUtils.assertEqualsString(root1.toString(), root2.toString());
    }
}
