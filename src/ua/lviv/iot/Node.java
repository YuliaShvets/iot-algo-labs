package ua.lviv.iot;

public class Node {
    private int dist;
    private int x;
    private int y;

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    public Node() {
    }

    public int getDist() {
        return dist;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
