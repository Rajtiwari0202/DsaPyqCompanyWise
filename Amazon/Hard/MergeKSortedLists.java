class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class MergeKSortedLists {

    static Node merge(Node h1, Node h2) {

        Node dummy = new Node(0);
        Node p = dummy;

        while (h1 != null && h2 != null) {

            if (h1.val < h2.val) {
                p.next = h1;
                h1 = h1.next;
            } else {
                p.next = h2;
                h2 = h2.next;
            }

            p = p.next;
        }

        p.next = (h1 == null) ? h2 : h1;

        return dummy.next;
    }

    static Node mergeKLists(Node[] lists) {

        Node ans = null;

        for (Node list : lists) {
            ans = merge(ans, list);
        }

        return ans;
    }
}