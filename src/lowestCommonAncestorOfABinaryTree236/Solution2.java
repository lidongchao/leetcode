package lowestCommonAncestorOfABinaryTree236;

import utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 思路 2：存储父节点 (阔气版)
 *
 * 申请一个 HashSet visited、一个 HashMap parent
 * DFS 遍历整棵树，将每个节点到其父节点的信息存储在 parent 中
 * 通过 parent，将 P 和 P 的所有祖先节点存储于 visited 中
 * 通过 parent，依次判断 Q、Q 的父节点、Q 的爷爷节点 ... 是否存在于 visited 中，如果存在且第一次找到的节点就是 P 和 Q 的公共祖先
 *
 * 执行用时 :13 ms, 在所有 Java 提交中击败了20.94%的用户
 * 内存消耗 :42.3 MB, 在所有 Java 提交中击败了5.71%的用户
 */
class Solution2 {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root 二叉树的根节点
     * @param p 指定节点1
     * @param q 指定节点2
     * @return 最近公共祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        visitChild(root);

        // 存储 P 和 P 的所有祖先节点于 visited 中
        while (p != null) {
            visited.add(p);
            p = parent.get(p.val);
        }

        // 依次判断 Q、Q 的父节点、Q 的爷爷节点 ... 是否存在于 visited 中，如果存在且第一次找到的节点就是 P 和 Q 的公共祖先
        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    // 将二叉树的所有节点及其父节点信息存储在 parent 中
    private void visitChild(TreeNode node) {
        if (node.left != null) {
            parent.put(node.left.val, node);
            visitChild(node.left);
        }
        if (node.right != null) {
            parent.put(node.right.val, node);
            visitChild(node.right);
        }
    }

    private Map<Integer, TreeNode> parent = new HashMap<>();
    private Set<TreeNode> visited = new HashSet<>();
}
