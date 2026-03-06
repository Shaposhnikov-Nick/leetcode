public class Solution_104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        var root = new Integer[]{3, 9, 20, null, null, 15, 7};
        var node3 = new TreeNode2(3);
        var node9 = new TreeNode2(9);
        var node20 = new TreeNode2(20);
        var nod15 = new TreeNode2(15);
        var node7 = new TreeNode2(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = nod15;
        node20.right = node7;
        maxDepth(node3);
    }

    private static int maxDepth(TreeNode2 root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}


class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2() {
    }

    TreeNode2(int val) {
        this.val = val;
    }

    TreeNode2(int val, TreeNode2 left, TreeNode right2) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}