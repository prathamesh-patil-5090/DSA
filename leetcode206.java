public class leetcode206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        leetcode206 solution = new leetcode206();
        
        ListNode node1 = solution.new ListNode(1);
        ListNode node2 = solution.new ListNode(2);
        ListNode node3 = solution.new ListNode(3);
        ListNode node4 = solution.new ListNode(4);
        ListNode node5 = solution.new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode head = node1;

        ListNode newHead = reverseList(head);
        ListNode current = newHead;
        System.out.print("null -> ");
        while(current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }
    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode ahead = current.next;
            current.next = prev;
            prev = current;
            current = ahead;
        }

        return prev;
    }
}
