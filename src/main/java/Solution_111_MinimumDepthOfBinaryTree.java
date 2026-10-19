public class Solution_111_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        var node3 = new TreeNode2(3);
        var node9 = new TreeNode2(9);
        var node20 = new TreeNode2(20);
        var nod15 = new TreeNode2(15);
        var node7 = new TreeNode2(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = nod15;
        node20.right = node7;

        minDepth(node3);
    }

    /**
     * Обходим каждый узел, если какой-то дочерний узел null, то идем в другой
     * если дочерний узел не null, прибавляем меньшее из значений
     */
    private static int minDepth(TreeNode2 root) {
        if (root == null) return 0;
        if (root.left == null) return  1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return Math.min(1 + minDepth(root.right), 1 + minDepth(root.left));
    }

}
