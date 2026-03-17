import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution_1290_ConvertBinaryNumberInLinkedListToInteger {
    public static void main(String[] args) {
        var node1 = new ListNode2(1);
        var node2 = new ListNode2(0);
        var node3 = new ListNode2(1);
        var node4 = new ListNode2(1);
        var node5 = new ListNode2(1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        getDecimalValue(node1);
    }

    private static int getDecimalValue(ListNode2 head) {
        var bits = new ArrayList<Integer>();
        var current = head;

        while (current != null) {
            bits.add(current.val);
            current = current.next;
        }

        var binaryString = bits.stream().map(Objects::toString).collect(Collectors.joining(""));
        return Integer.parseInt(binaryString, 2);
    }
}
