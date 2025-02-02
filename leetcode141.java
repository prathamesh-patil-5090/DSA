public class leetcode141{
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static void main(String[] args) {
        leetcode141 solution = new leetcode141();

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

        boolean result = hasCycle(node1);
        System.out.println(result);
    }
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(fast == null) return false;
        if(fast == fast.next) return true;
        do{
            if(fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }while(fast != null);
        return false;
    }
}