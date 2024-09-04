package BOJ1197;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] root;
    static int[] rank;

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }


        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        root = new int[V + 1];
        rank = new int[root.length];

        makeSet();

        Edge[] edges = new Edge[E];

        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(edges);

        int result = 0;
        int pick = 0;

        for (int i = 0; i < edges.length; i++) {
            int x = findSet(edges[i].x);
            int y = findSet(edges[i].y);

            if (x != y) {
                union(x, y);
                result += edges[i].w;
                pick++;
            }

            if (pick == V) {
                break;
            }
        }

        System.out.println(result);
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

    static boolean union(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        if (x == y) {
            return false;
        }

        if (rank[x] > rank[y]) {
            root[y] = x;
        } else {
            root[x] = y;

            if (rank[x] == rank[y]) {
                rank[y]++;
            }
        }
        return true;
    }
}
