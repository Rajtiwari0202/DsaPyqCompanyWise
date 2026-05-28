class Node {

    int val;
    Node next;

    Node(int val){
        this.val = val;
        this.next = null;
    }
}

public class IntersectionOfTwoLL {

    static Node intersection(Node l1, Node l2){

        if(l1 == null || l2 == null) return null;

        Node p1 = l1;
        Node p2 = l2;

        while(p1 != p2){

            p1 = (p1 == null) ? l2 : p1.next;
            p2 = (p2 == null) ? l1 : p2.next;
        }

        return p1;
    }

    static void print(Node head){

        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // Common intersection part
        Node common = new Node(8);
        common.next = new Node(4);
        common.next.next = new Node(5);

        // First list
        Node l1 = new Node(4);
        l1.next = new Node(1);
        l1.next.next = common;

        // Second list
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(1);
        l2.next.next.next = common;

        Node ans = intersection(l1, l2);

        if(ans != null){
            System.out.println("Intersection at node: " + ans.val);
        }
        else{
            System.out.println("No intersection");
        }
    }
}