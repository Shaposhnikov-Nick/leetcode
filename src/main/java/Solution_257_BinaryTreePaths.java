import java.util.ArrayList;
import java.util.List;

public class Solution_257_BinaryTreePaths {
    public static void main(String[] args) {
        var node1 = new TreeNode2(1);
        var node2 = new TreeNode2(2);
        var node3 = new TreeNode2(3);
        var node5 = new TreeNode2(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        binaryTreePaths(node1);
    }

    private static List<String> binaryTreePaths(TreeNode2 root) {
        var path = "";
        var result = new ArrayList<String>();
        paths(path, root, result);
        return result;
    }

    private static void paths(String path, TreeNode2 node, List<String> result) {
        var newPath = "";
        if (!path.isBlank()) newPath = path + "->";
        newPath = newPath + node.val;

        if (node.left == null && node.right == null) {
            result.add(newPath);
            return;
        }

        if (node.left != null) paths(newPath, node.left, result);
        if (node.right != null) paths(newPath, node.right, result);
    }
}
