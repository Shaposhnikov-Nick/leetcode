import java.util.ArrayList;

public class Solution_2130_MaximumTwinSumOfLinkedList {
    public static void main(String[] args) {
        var node1 = new ListNode2(1);
        var node2 = new ListNode2(2);
        var node3 = new ListNode2(3);
        var node4 = new ListNode2(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node4.setNext(node2);
        System.out.println(pairSum(node1));
    }

    private static int pairSum(ListNode2 head) {
        var values = new ArrayList<Integer>();
        var current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        var maxSum = 0;
        var n = values.size();

        for (int i = 0; i < n / 2; i++) {
            var twinIndex = n - i - 1;
            var sum = values.get(i) + values.get(twinIndex);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
