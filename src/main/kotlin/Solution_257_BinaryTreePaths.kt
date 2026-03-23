/**
 * 257 Binary Tree Paths
 *
 * Easy
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * Example 2:
 *
 * Input: root = [1]
 * Output: ["1"]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 */
fun main() {
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node5 = TreeNode(5)
    node1.left = node2
    node1.right = node3
    node2.right = node5
    binaryTreePaths(node1)
}

/**
 * Начинаем обход дерева с корня
 * Для каждого узла добавляем его значение в path
 * Если узел листовой, добавляем путь к нему в result и выходим из рекурсии
 * Если узел не листовой, идем туда, где есть ответвления
 */
fun binaryTreePaths(root: TreeNode?): List<String> {
    val path = ""
    val result = mutableListOf<String>()
    // Начинаем обход дерева с корня
    paths(path, root, result)
    return result
}

fun paths(path: String, node: TreeNode?, result: MutableList<String>) {
    // Для каждого узла добавляем его значение в path
    var newPath = ""
    if (path.isNotEmpty()) newPath = "$path->"
    newPath += node?.`val`

    // Если узел листовой, добавляем путь к нему в result и выходим из рекурсии
    if (node?.left == null && node?.right == null) {
        result.add(newPath)
        return
    }

    // Если узел не листовой, идем туда, где есть ответвления
    if (node.left != null) paths(newPath, node.left, result)
    if (node.right != null) paths(newPath, node.right, result)
}

/**
 * Решение в котором путь формируется через StringBuilder
 */
fun binaryPath2(sb: StringBuilder, node: TreeNode?, result: MutableList<String>) {
    if (sb.isNotEmpty()) sb.append("->")
    sb.append(node?.`val`)

    if (node?.left == null && node?.right == null) {
        result.add(sb.toString())
        return
    }

    if (node.left != null) {
        val newLeftSb = StringBuilder()
        newLeftSb.append(sb.toString())
        binaryPath2(newLeftSb, node.left, result)
    }


    if (node.right != null) {
        val newRightSb = StringBuilder()
        newRightSb.append(sb.toString())
        binaryPath2(newRightSb, node.right, result)
    }
}