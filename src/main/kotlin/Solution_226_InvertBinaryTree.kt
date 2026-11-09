/**
 * 226 Invert Binary Tree
 *
 * Easy
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example 1:
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
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

    invertTree(node3)
}

/**
 * DFS
 */
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    // Меняем местами левое и правое поддеревья
    val tmp = root.left
    root.left = root.right
    root.right = tmp

    // Рекурсивно инвертируем поддеревья
    invertTree(root.left)
    invertTree(root.right)

    return root
}

/**
 * BFS
 */
fun invertTreeBFS(root: TreeNode?): TreeNode? {
    if (root == null) return null

    val queue: ArrayDeque<TreeNode> = ArrayDeque()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()

        // Меняем детей местами
        val temp = node.left
        node.left = node.right
        node.right = temp

        // Добавляем детей в очередь
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
    }

    return root
}