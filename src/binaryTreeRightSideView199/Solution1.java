package binaryTreeRightSideView199;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 思路 1：BFS，对二叉树进行从左到右的广度优先遍历/层次遍历，每一层的最后一个元素就是右测能够观察到的结点。
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了97.36%的用户
 * 内存消耗 :38.2 MB, 在所有 Java 提交中击败了5.00%的用户
 */
class Solution1 {
    /**
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root 根结点
     * @return 右侧观察的结点列表
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (null == root) return ans;

        Queue<TreeNode> nodeQueue = new LinkedList<>();

        // 从根结点开始 BFS
        nodeQueue.add(root);

        // BFS
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();

            // 每一次遍历一层，并将下一层添加进队列
            // 对每一层最后一个元素特殊处理————打印出来
            while (size > 1) {
                TreeNode node = nodeQueue.poll();
                if (null != node.left) nodeQueue.add(node.left);
                if (null != node.right) nodeQueue.add(node.right);
                size--;
            }
            TreeNode last = nodeQueue.poll();
            if (null != last.left) nodeQueue.add(last.left);
            if (null != last.right) nodeQueue.add(last.right);
            ans.add(last.val);
        }

        return ans;

    }
}
