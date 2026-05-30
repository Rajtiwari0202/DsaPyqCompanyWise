class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class FlattenBTtoLL {

    static void flatten(Node root) {

        while (root != null) {

            if (root.left != null) {

                Node curr = root.left;

                // Find rightmost node of left subtree
                while (curr.right != null) {
                    curr = curr.right;
                }

                // Attach original right subtree
                curr.right = root.right;

                // Move left subtree to right
                root.right = root.left;

                root.left = null;
            }

            // Move to next node
            root = root.right;
        }
    }

    static void print(Node root) {

        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.right = new Node(6);

        flatten(root);

        print(root);
    }
}