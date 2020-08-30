package serializeAndDeserializeBinaryTree297;

import utils.AssertUtils;
import utils.TreeNode;

public class Main {
    public static void main(String[] args) {
        Codec codec = new Codec();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        TreeNode root2 = codec.deserialize(codec.serialize(root));

        AssertUtils.assertEquals(root.toString(), root2.toString());

    }
}
