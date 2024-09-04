package BOJ9372;

import java.util.Scanner;

public class Main {
    static int[] root;
    static int[] rank;

    static class Edge {
        int x;
        int y;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            root = new int[N + 1];
            rank = new int[root.length];

            makeSet();

            Edge[] edges = new Edge[M];

            for (int i = 0; i < M; i++) {
                edges[i] = new Edge(sc.nextInt(), sc.nextInt());
            }

            int airplane = 0;

            for (int i = 0; i < M; i++) {
                int tmpX = findSet(edges[i].x);
                int tmpY = findSet(edges[i].y);

                if (tmpX != tmpY) {
                    union(tmpX, tmpY);
                    airplane++;
                }

                if (airplane == N) {
                    break;
                }
            }

            System.out.println(airplane);
        }
    }

    static void makeSet() {
        for (int i = 1; i < root.length; i++) {
            root[i] = i;
        }
    }

    static int findSet(int x) {
        if (root[x] == x) {
            return x;
        }

        return root[x] = findSet(root[x]);
    }

    static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        if (x == y) {
            return;
        }

        if (rank[x] > rank[y]) {
            root[y] = x;
        } else {
            root[x] = y;

            if (rank[x] == rank[y]) {
                rank[y]++;
            }
        }
    }
}
