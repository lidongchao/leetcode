package binaryTreeRightSideView199;

import utils.ArrayUtils;
import utils.AssertUtils;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        Integer[] tree = {1,2,3,null,5,null,4};
        TreeNode root = construct(tree);
        int[] expect = {1,3,4};
        AssertUtils.assertEqualsIntArray(expect, ArrayUtils.toPrimitive(solution.rightSideView(root).toArray(new Integer[0])));

    }

    // 根据树的完全二叉树列表形式，构造一棵树
    private static TreeNode construct(Integer[] nodeVal) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        TreeNode root = null;
        for (int i = 0; i < nodeVal.length; i++) {
            Integer left = nodeVal[i];
            // 处理根结点
            if (null == root) {
                root = new TreeNode(left);
                treeNodeQueue.add(root);
                continue;
            }

            // 取出当前遍历的结点，添加其左右叶子结点
            TreeNode poll = treeNodeQueue.poll();

            // 添加左边叶子
            if (null != poll && null != left) {
                poll.left = new TreeNode(left);
                treeNodeQueue.add(poll.left);
            } else {
                treeNodeQueue.add(null);
            }

            // 添加右边叶子
            if (i + 1 < nodeVal.length){
                Integer right = nodeVal[i+1];
                if (null != poll && null != right) {
                    poll.right = new TreeNode(right);
                    treeNodeQueue.add(poll.right);
                } else {
                    treeNodeQueue.add(null);
                }
                i++;
            }

        }
        return root;
    }
}
