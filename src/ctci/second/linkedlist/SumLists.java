package ctci.second.linkedlist;

public class SumLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);

        SumLists o = new SumLists();
        //ListNode ans = o.sumForward(l1, l2);
        ListNode ans = o.sumBackward(l1, l2);
        while (ans != null) {
            System.out.printf("%d ", ans.val);
            ans = ans.next;
        }
    }

    ListNode sumBackward(ListNode l1, ListNode l2) {
        int l1Size = getSize(l1);
        int l2Size = getSize(l2);

        if (l1Size > l2Size) {
            ListNode zero = new ListNode(0);
            ListNode zeroHead = zero;
            for (int i = 0; i < (l1Size - l2Size) - 1; i++) {
                zero.next = new ListNode(0);
                zero = zero.next;
            }
            zero.next = l2;
            l2 = zeroHead;
        } else if (l2Size > l1Size) {
            ListNode zero = new ListNode(0);
            ListNode zeroHead = zero;
            for (int i = 0; i < (l2Size - l1Size) - 1; i++) {
                zero.next = new ListNode(0);
                zero = zero.next;
            }
            zero.next = l1;
            l1 = zeroHead;
        }

        ListNodeWrapper sumNode = sumRec(l1, l2);
        if (sumNode.carry == 1) {
            ListNode one = new ListNode(1);
            one.next = sumNode.node;
            return one;
        }
        return sumNode.node;
    }

    ListNodeWrapper sumRec(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNodeWrapper next = sumRec(l1.next, l2.next);
        int sum = next == null ? 0 : next.carry;
        sum += l1.val;
        sum += l2.val;
        ListNodeWrapper newNode = new ListNodeWrapper();
        newNode.node = new ListNode(sum % 10);
        newNode.carry = sum / 10;
        if (next != null) newNode.node.next = next.node;
        return newNode;
    }

    int getSize(ListNode n) {
        int size = 0;
        ListNode curr = n;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    ListNode sumForward(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
        }
        return head.next;
    }

    static class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class ListNodeWrapper {
        ListNode node;
        int carry;
    }

}
