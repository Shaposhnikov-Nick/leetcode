/**
 * 234 Palindrome Linked List
 *
 * Easy
 *
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 10^5].
 * 0 <= Node.val <= 9
 *
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(1)
    val node3 = ListNode(0)
    val node4 = ListNode(1)
//    val node5 = ListNode(2)
//    val node6 = ListNode(1)
    node1.next = node2
    node2.next = node3
    node3.next = node4
//    node4.next = node5
//    node5.next = node6
    println(isPalindrome(node1))
}

fun isPalindrome(head: ListNode?): Boolean {
    if (head?.next == null) return true
    var current = head
    var size = 1

    // считаем размер списка
    while (current?.next != null) {
        size++
        current = current.next
    }

    // добавляем значения из списка в массив
    val digits = IntArray(size)
    current = head
    for (i in 0 until size) {
        digits[i] = current!!.`val`
        current = current.next
    }

    // сравниваем крайние значения в массиве
    for (i in 0 until size) {
        if (digits[i] != digits[size - i - 1]) return false
    }

    return true
}