/**
 * 111  Minimum Depth of Binary Tree
 *
 * Easy
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 *
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 */
fun main() {
    val node3 = TreeNode(3)
    val node9 = TreeNode(9)
    val node20 = TreeNode(20)
    val nod15 = TreeNode(15)
    val node7 = TreeNode(7)
    node3.left = node9
    node3.right = node20
    node20.left = nod15
    node20.right = node7

    minDepth(node3)
}

/**
 * DFS обход в глубину
 * Создаем список для хранения глубин
 * переходим от узла к узлу и считаем глубину
 * если дошли то листового ущла, добавляем его глубину в depths
 * возвращаем минимальную глубину из depths
 */
fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0

    // список для хранения глубин
    val depths = mutableListOf<Int>()

    // переходим от узла к узлу и считаем глубину
    calcDepth(root, 0, depths)

    //  возвращаем минимальную глубину из depths
    return depths.min()
}

fun calcDepth(node: TreeNode?, depth: Int, depths: MutableList<Int>) {
    if (node == null) return

    // считаем глубину
    val newDepth = depth + 1

    // если дошли то листового ущла, добавляем его глубину в depths
    if (node.left == null && node.right == null) depths.add(newDepth)

    calcDepth(node.left, newDepth, depths)
    calcDepth(node.right, newDepth, depths)
}