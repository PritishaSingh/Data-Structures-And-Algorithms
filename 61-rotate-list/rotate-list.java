class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0) {
            return head;
        }

        int size = 1;
        ListNode temp = head;

        // reach last node and count size
        while(temp.next != null) {
            size++;
            temp = temp.next;
        }

        // reduce rotations
        k = k % size;

        if(k == 0) return head;

        // make circular list
        temp.next = head;

        int rem = size - k;

        ListNode newTail = head;

        // move to new tail
        for(int i = 1; i < rem; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        // break circle
        newTail.next = null;

        return newHead;
    }
}