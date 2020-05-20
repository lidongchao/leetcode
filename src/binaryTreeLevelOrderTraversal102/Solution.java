package binaryTreeLevelOrderTraversal102;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * 思路：使用队列进行二叉树的层次遍历
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了91.30%的用户
 * 内存消耗 :40 MB, 在所有 Java 提交中击败了5.71%的用户
 */
class Solution {
    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root 二叉树的根结点
     * @return 按层序遍历得到的节点值
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        queue.add(root);

        // 层次遍历
        while(!queue.isEmpty()) {
            // 将当前队列中所有元素视为同一层
            int size = queue.size();
            List<Integer> inner = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                inner.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(inner);
        }
        return ans;
    }
}
