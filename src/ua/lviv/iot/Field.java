package ua.lviv.iot;

import java.util.ArrayDeque;
import java.util.Queue;

public class Field {

    private int[] row = {-1, 0, 1, 0};
    private int[] column = {0, -1, 0, 1};

    public boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
    public boolean isSave(int[][] cell, boolean[][] used, int x, int y) {
        return cell[x][y] == 1 && !used[x][y];
    }

    public int BFS(int[][] cell) {
        int m = cell.length;
        int n = cell[0].length;

        Queue<Node> queue = new ArrayDeque<>();

        boolean[][] used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            if (cell[i][0] == 1) {
                queue.add(new Node(i, 0, 0));
                used[i][0] = true;
            }
        }

        while (!queue.isEmpty()) {
            int k = queue.peek().getX();
            int l = queue.peek().getY();
            int dist = queue.peek().getDist();
            queue.poll();

            if (l == n - 1) {
                return dist;
            }

            for (int i = 0; i < row.length; i++) {
                if (isValid(k + row[i], l + column[i], m, n) &&
                        isSave(cell, used, k + row[i], l + column[i])) {
                    used[k + row[i]][l + column[i]] = true;
                    queue.add(new Node(k + row[i], l + column[i], dist + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public int findShortPath(int[][] matrix) {

        if (matrix == null && matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[] r = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] c = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                for (int p = 0; p < row.length; p++) {
                    if (matrix[i][k] == 0 &&
                            isValid(i + row[p], k + c[p], m, n) &&
                            matrix[i + row[p]][k + c[p]] == 1) {
                        matrix[i + row[p]][k + c[p]] = Integer.MAX_VALUE;

                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; n++) {
                if (matrix[i][k] == Integer.MAX_VALUE) {
                    matrix[i][k] = 0;
                }
            }
        }
        return BFS(matrix);
    }
}

