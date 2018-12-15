package blog.linkedlist;

public class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public int hashCode() {
        return data;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode)) return false;

        ListNode node = (ListNode) o;

        return node.data == this.data;
    }
}
