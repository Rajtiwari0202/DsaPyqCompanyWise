class Node {

    int val;
    Node next;

    Node(int val){
        this.val = val;
        this.next = null;
    }
}

public class PalindromicLL {

    static Node reverse(Node head){

        Node prev = null;

        while(head != null){

            Node next = head.next;

            head.next = prev;

            prev = head;

            head = next;
        }

        return prev;
    }

    static boolean isPalindrome(Node head){

        Node fast = head;
        Node slow = head;

        // Find middle
        while(fast != null && fast.next != null){

            fast = fast.next.next;

            slow = slow.next;
        }

        // Odd length
        if(fast != null){
            slow = slow.next;
        }

        // Reverse second half
        slow = reverse(slow);

        fast = head;

        // Compare halves
        while(slow != null){

            if(slow.val != fast.val){
                return false;
            }

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    public static void main(String[] args){

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        System.out.println(isPalindrome(head));
    }
}