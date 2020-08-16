package constructBinaryTreeFromPreorderAndInorderTraversal105;

import utils.TreeNode;

/**
 * 思路 1：递归
 *
 * 对于一棵树，前序遍历可以看作 根结点 + 左子树的前序遍历 + 右子树的前序遍历，
 * 中序遍历可以看作 左子树的中序遍历 + 根结点 + 右子树的中序遍历。
 *
 * 因此，前序遍历的第一个元素一定是树的根结点，然后在中序遍历中找到根结点的位置，就能确定左子树和右子树的元素个数，从而确定
 * 左子树的前序遍历和中序遍历，以及右子树的前序遍历和中序遍历，递归构造左右子树，最后能够得到完整的二叉树。
 *
 * 执行用时 :4 ms, 在所有 Java 提交中击败了63.81%的用户
 * 内存消耗 :39.7 MB, 在所有 Java 提交中击败了76.67%的用户
 */
class Solution1 {
    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param preorder 一棵树的前序遍历
     * @param inorder 一棵树的中序遍历
     * @return 这棵树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder.length != inorder.length) return null;
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        // 前序遍历的第一个元素一定是树 (子树) 的根结点
        TreeNode node = new TreeNode(preorder[pstart]);
        // 在中序遍历中找到根结点的位置
        int mid = find(inorder, istart, iend, preorder[pstart]);
        // 确定左子树的元素个数
        if (istart < mid) {
            // 根据左子树的前序遍历和中序遍历，递归构造左子树
            node.left = build(preorder, pstart+1, pstart+(mid-istart), inorder, istart, mid-1);
        }
        // 确定右子树的元素个数
        if (mid < iend) {
            // 根据右子树的前序遍历和中序遍历，递归构造右子树
            node.right = build(preorder, pstart+(mid-istart)+1, pend, inorder, mid+1, iend);
        }

        return node;
    }

    private int find(int[] arr, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        // 前序遍历和中序遍历均有效的情况下，绝对不可能返回 -1
        return -1;
    }
}
