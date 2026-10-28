public class Solution_101_SymmetricTree {
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

        isSymmetric(node3);
    }

    /**
     * Сравниваем значения симметричных узлов
     */
    private static boolean isSymmetric(TreeNode2 root) {
        return symmetric(root.left, root.right);
    }

    private static boolean symmetric(TreeNode2 left, TreeNode2 right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
}
