package ua.lviv.iot;

public class Node {
    int key;
    int height;
    Node right;
    Node left;

    Node(int d) {
        key = d;
        height = 1;
    }
}
