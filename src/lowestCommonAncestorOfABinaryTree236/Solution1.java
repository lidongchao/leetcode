package lowestCommonAncestorOfABinaryTree236;

import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 思路 1：存储父节点 (抠门版)
 *
 * 申请一个 HashSet visited；
 * DFS 寻找 P，存储 P 和 P 的所有祖先节点于 visited 中；
 * DFS 寻找 Q，依次判断 Q、Q 的父节点、Q 的爷爷节点 ... 是否存在于 visited 中，如果存在且第一次找到的节点就是 P 和 Q 的公共祖先
 *
 * 执行用时 :12 ms, 在所有 Java 提交中击败了31.13%的用户
 * 内存消耗 :41.7 MB, 在所有 Java 提交中击败了5.71%的用户
 */
class Solution1 {
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
        visited.clear();
        ans = null;
        findP(root, p);
        findQ(root, q);

        return ans;
    }

    // DFS 寻找 P，存储 P 和 P 的所有祖先节点于 visited 中
    private boolean findP(TreeNode node, TreeNode p) {
        if (node == p) {
            visited.add(node);
            return true;
        }
        if (node == null) return false;

        boolean findLeft;
        boolean findRight = false;

        // 依次在左子树和右子树中寻找 P，只要在任何一个子树中找到 P，就可以证明当前 node 是 P 的祖先节点
        findLeft = findP(node.left, p);
        if (findLeft) {
            visited.add(node);
        } else {
            findRight = findP(node.right, p);
            if (findRight) {
                visited.add(node);
            }
        }

        return findLeft || findRight;
    }

    // DFS 寻找 Q，依次判断 Q、Q 的父节点、Q 的爷爷节点 ... 是否存在于 visited 中，如果存在且第一次找到的节点就是 P 和 Q 的公共祖先
    private boolean findQ(TreeNode node, TreeNode q) {
        if (node == q) {
            checkAns(node);
            return true;
        }
        if (node == null) return false;

        boolean findLeft;
        boolean findRight = false;

        // 依次在左子树和右子树中寻找 Q，递归能够保证最先判断 Q 是否存在于 visited 中，再判断 Q 的父节点、爷爷节点
        findLeft = findQ(node.left, q);
        if (findLeft) {
            checkAns(node);
        } else {
            findRight = findQ(node.right, q);
            if (findRight) {
                checkAns(node);
            }
        }

        return findLeft || findRight;
    }

    // 只有第一次判断 node 存在于 visited 中，才会赋值给 ans，保证一定是最近公共祖先
    private void checkAns(TreeNode node) {
        if (ans == null && visited.contains(node)) {
            ans = node;
        }
    }

    private Set<TreeNode> visited = new HashSet<>();
    private TreeNode ans = null;
}
