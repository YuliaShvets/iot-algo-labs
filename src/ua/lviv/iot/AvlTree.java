package ua.lviv.iot;

public class AvlTree {

    Node root;

    int getHeight(Node n) {
        if (n == null) {
            return 0;
        }
        return n.height;
    }

    Node rotateRightChild(Node b) {
        Node a = b.left;
        Node c = a.right;
        a.right = b;
        b.left = c;

        b.height = Math.max(getHeight(b.left), getHeight(b.right)) + 1;
        a.height = Math.max(getHeight(a.left), getHeight(a.right)) + 1;

        return a;
    }

    Node rotateLeftChild(Node a) {
        Node b = a.right;
        Node c = b.left;

        b.left = a;
        a.right = c;

        a.height = Math.max(getHeight(a.left), getHeight(a.right)) + 1;
        b.height = Math.max(getHeight(b.left), getHeight(b.right)) + 1;

        return b;
    }

    int getBalance(Node n) {
        if (n == null) {
            return 0;
        }
        return getHeight(n.left) - getHeight(n.right);
    }

    Node insert(Node node, int key) {
        if (node == null) {
            return (new Node(key));
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);
        if (balance > 1 && key < node.left.key)
            return rotateRightChild(node);

        if (balance < -1 && key > node.right.key)
            return rotateLeftChild(node);

        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeftChild(node.left);
            return rotateRightChild(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rotateRightChild(node.right);
            return rotateLeftChild(node);
        }

        return node;
    }

}
