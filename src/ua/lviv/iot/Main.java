package ua.lviv.iot;

public class Main {

    public static void main(String[] args) {

        AvlTree tree = new AvlTree();
        tree.root = tree.insert(tree.root, 18);
        tree.root = tree.insert(tree.root, 35);
        tree.root = tree.insert(tree.root, 13);
        tree.root = tree.insert(tree.root, 42);
        tree.root = tree.insert(tree.root, 7);

    }
}
