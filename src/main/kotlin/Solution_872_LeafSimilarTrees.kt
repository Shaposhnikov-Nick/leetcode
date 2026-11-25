/**
 * 872 Leaf-Similar Trees
 *
 * Easy
 *
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 * Example 1:
 *
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 * Example 2:
 *
 *
 * Input: root1 = [1,2,3], root2 = [1,3,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in each tree will be in the range [1, 200].
 * Both of the given trees will have values in the range [0, 200].
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

    leafSimilar(node3, node3)
}

fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val values1 = mutableListOf<Int>()
    val values2 = mutableListOf<Int>()
    getValue(root1, values1)
    getValue(root2, values2)

    if (values1.size != values2.size) return false

    values1.forEachIndexed { index, value1 ->
        if (value1 != values2[index])
            return false
    }

    return true
}

/**
 * DFS
 * Обходим каждое дерево в одной и той же последовательности (сначала левый узел, потом правый)
 * и кладем значения листовых узлов в лист.
 * Потом сравниваем оба листа
 */
fun getValue(node: TreeNode?, values: MutableList<Int>) {
    if (node == null) return

    // если узел листовой, берем его значение
    if (node.right == null && node.left == null) {
        values.add(node.`val`)
    }

    // идем сначала в левый узле
    getValue(node.left, values)
    // потом идем в правый узел
    getValue(node.right, values)
}