import java.util.ArrayList;
import java.util.List;

public class Solution_94_BinaryTreeInorderTraversal {
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
        inorderTraversal(node3);
    }

    private static List<Integer> inorderTraversal(TreeNode2 root) {
        var result = new ArrayList<Integer>();
        inorder(root, result);
        return result;
    }

    /**
     * Добавляем сначала значение из левого узла, затем из самого узла, затем из правого узла
     */
    private static void inorder(TreeNode2 node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
