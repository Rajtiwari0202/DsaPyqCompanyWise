class Node {

    int val;
    Node next;

    Node(int val){
        this.val = val;
        this.next = null;
    }
}

class MergeTwoSortedLists {

    static Node merge(Node l1, Node l2){

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        // Ensure l1 starts smaller
        if(l1.val > l2.val){
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        Node ans = l1;

        while(l1 != null && l2 != null){

            Node temp = null;

            while(l1 != null && l1.val <= l2.val){
                temp = l1;
                l1 = l1.next;
            }

            temp.next = l2;

            Node t = l1;
            l1 = l2;
            l2 = t;
        }

        return ans;
    }

    static void printList(Node head){

        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args){

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(4);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        Node mergedHead = merge(head1, head2);

        printList(mergedHead);
    }
}