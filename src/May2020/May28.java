package May2020;

public class May28 {
    /*

     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode ans = new ListNode(0);
        ListNode head = ans;

        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                if(l1.val > l2.val) {
                    ans.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    ans.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
            } else if(l1 == null) {
                if(l2 == null) {
                    break;
                } else {
                    ans.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            } else {
                ans.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            ans = ans.next;
        }
        return head.next;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
