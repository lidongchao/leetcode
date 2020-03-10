package diameterOfBinaryTree543;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int res = solution.diameterOfBinaryTree(root);
        System.out.println(res);

    }
}
