class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class AllNodesDistanceKFromBT {

    Node root;

    void printKdistanceNodeDown(Node root, int k) {

        if (root == null || k < 0) {
            return;
        }

        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }

        printKdistanceNodeDown(root.left, k - 1);
        printKdistanceNodeDown(root.right, k - 1);
    }

    int printKdistanceNode(Node root, Node target, int k) {

        if (root == null) return -1;

        if (root == target) {
            printKdistanceNodeDown(root, k);
            return 0;
        }

        int dl = printKdistanceNode(root.left, target, k);

        if (dl != -1) {

            if (dl + 1 == k) {
                System.out.print(root.data + " ");
            } else {
                printKdistanceNodeDown(root.right, k - dl - 2);
            }

            return dl + 1;
        }

        int dr = printKdistanceNode(root.right, target, k);

        if (dr != -1) {

            if (dr + 1 == k) {
                System.out.print(root.data + " ");
            } else {
                printKdistanceNodeDown(root.left, k - dr - 2);
            }

            return dr + 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        AllNodesDistanceKFromBT tree = new AllNodesDistanceKFromBT();

        tree.root = new Node(3);
        tree.root.left = new Node(5);
        tree.root.right = new Node(1);
        tree.root.left.left = new Node(6);
        tree.root.left.right = new Node(2);
        tree.root.right.left = new Node(0);
        tree.root.right.right = new Node(8);
        tree.root.left.right.left = new Node(7);
        tree.root.left.right.right = new Node(4);

        Node target = tree.root.left; // target = 5
        int k = 2;

        tree.printKdistanceNode(tree.root, target, k);
    }
}