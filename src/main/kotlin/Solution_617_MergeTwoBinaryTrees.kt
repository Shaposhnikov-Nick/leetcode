/**
 * 617 Merge Two Binary Trees
 *
 * Easy
 *
 * You are given two binary trees root1 and root2.
 *
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 *
 * Return the merged tree.
 *
 * Note: The merging process must start from the root nodes of both trees.
 *
 * Example 1:
 *
 * Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * Output: [3,4,5,5,4,null,7]
 * Example 2:
 *
 * Input: root1 = [1], root2 = [1,2]
 * Output: [2,2]
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 2000].
 * -104 <= Node.val <= 104
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

    mergeTrees(node3, node3)
}

/**
 * DFS
 * Попарно складываем значения из соответстувющих узлов
 * Если каждый узел в паре - null, результирующий тоже будет null
 * Рекурсивно добавляем получившемуся узлу сумму правых и левых узлов
 */
fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    val v1 = root1?.`val`
    val v2 = root2?.`val`

    // Попарно складываем значения из соответстувющих узлов
    // Если каждый узел в паре - null, результирующий тоже будет null
    val sum = if (v1 == null && v2 == null) null
    else (v1 ?: 0) + (v2 ?: 0)

    val node = if (sum != null) TreeNode(sum) else null

    // Рекурсивно добавляем получившемуся узлу сумму правых и левых узлов
    if (node != null) {
        node.left = mergeTrees(root1?.left, root2?.left)
        node.right = mergeTrees(root1?.right, root2?.right)
    }

    return node
}