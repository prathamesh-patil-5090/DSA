public class leetcode203 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        leetcode203 solution = new leetcode203();

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
        
        ListNode newHead = removeElements(node1, node5.val);
        ListNode current = newHead;
        while(current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        while(node != null){
            if(node.val == val){
                node = node.next;
                head = node;
            }
            else if(node.next != null && node.next.val == val){
                node.next = node.next.next;
            }else{
                node = node.next;
            } 
        }
        return head;
    }
}
