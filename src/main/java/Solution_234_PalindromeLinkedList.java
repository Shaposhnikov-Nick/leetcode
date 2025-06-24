public class Solution_234_PalindromeLinkedList {
    public static void main(String[] args) {
        var node1 = new ListNode2(1);
        var node2 = new ListNode2(2);
        var node3 = new ListNode2(3);
        var node4 = new ListNode2(4);
        var node5 = new ListNode2(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        System.out.println(isPalindrome(node1));
    }

    private static boolean isPalindrome(ListNode2 head) {
        if (head.next == null) return true;
        var size = 0;
        var current = head;

        while (current != null) {
            size++;
            current = current.next;
        }

        var nums = new int[size];
        current = head;

        for (int i = 0; i < size; i++) {
            nums[i] = current.val;
            current = current.next;
        }

        for (int i = 0; i <= size / 2; i++) {
            if (nums[i] != nums[size - i - 1]) return false;
        }

        return true;
    }
}
