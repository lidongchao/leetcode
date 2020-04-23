package binaryTreeRightSideView199;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 思路 2：DFS，对二叉树进行先右后左的深度优先遍历，需要记录每个结点的深度，因为每一层的第一个结点就是右侧所能看到的结点。
 *
 * 执行用时 :2 ms, 在所有 Java 提交中击败了31.17%的用户
 * 内存消耗 :38.1 MB, 在所有 Java 提交中击败了5.00%的用户
 */
class Solution2 {
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

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        // 记录当前已遍历到的最深的层数
        int maxDepth = -1;

        // 从根结点开始 DFS
        nodeStack.push(root);
        depthStack.push(0);

        // DFS
        while (!nodeStack.empty()) {
            TreeNode node = nodeStack.pop();
            Integer depth = depthStack.pop();

            // 比当前记录的层数更深，记录此结点值
            if (depth > maxDepth) {
                ans.add(node.val);
                maxDepth = depth;
            }

            // 分别将左结点和右结点入栈，同时维护每个结点的深度
            if (null != node.left) {
                nodeStack.add(node.left);
                depthStack.add((depth + 1));
            }
            if (null != node.right) {
                nodeStack.add(node.right);
                depthStack.add((depth + 1));
            }
        }

        return ans;
    }
}
