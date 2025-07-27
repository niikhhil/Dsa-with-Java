public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static void display(ListNode ptr) {
        ListNode temp = ptr;
        while (temp != null) {
            System.out.print(" " + temp.val + " ");
            temp = temp.next;
        }
    }

    public static void rev_display(ListNode ptr) {
        if (ptr == null)
            return;
        else {
            rev_display(ptr.next);
            System.out.print(" " + ptr.val + " ");
        }
    }

    public static ListNode inserAtEnd(ListNode head, int val) {
        ListNode ptr = head;
        ListNode temp = new ListNode(val);
        if (head == null) {
            return head;
        } else {
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = temp;
            temp.next = null;
        }
        return head;
    }

    public static ListNode reverse(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        ListNode t1 = cur;
        ListNode t = head;
        for (int i = 1; i <= right; i++) {
            t = t.next;
        }
        ListNode end = t;
        end = end.next;
        t.next = null;
        ListNode beh = null;
        while (cur != null) {
            ListNode Next = cur.next;
            cur.next = beh;
            beh = cur;
            cur = Next;
        }
        prev.next = beh;
        t1.next = end;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
         ListNode c = new ListNode(3);
         ListNode d = new ListNode(4);
         ListNode e = new ListNode(5);
        // ListNode f = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
       // f.next = null;

        display(a);
        // rev_display(a);
        // inserAtEnd(a, 18);
        System.out.println("\n");
        reverse(a, 2, 4);
        display(a);
    }
}
