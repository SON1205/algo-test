package BOJ.BOJ9370;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Edge {
        int to, w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static final int INF = 1_000_000_000;

    static int[] dijkstra(int start, List<List<Edge>> graph) {
        int n = graph.size() - 1;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (dist[now] < cost) {
                continue;
            }

            for (Edge nxt : graph.get(now)) {
                int nc = cost + nxt.w;
                if (dist[nxt.to] > nc) {
                    dist[nxt.to] = nc;
                    pq.offer(new int[]{nxt.to, nc});
                }
            }
        }
        return dist;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();

            int s = sc.nextInt();
            int g = sc.nextInt();
            int h = sc.nextInt();

            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            int ghWeight = 0;

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int d = sc.nextInt();

                graph.get(a).add(new Edge(b, d));
                graph.get(b).add(new Edge(a, d));

                if ((a == g && b == h) || (a == h && b == g)) {
                    ghWeight = d;
                }
            }

            List<Integer> candidates = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                candidates.add(sc.nextInt());
            }
            Collections.sort(candidates);

            int[] distS = dijkstra(s, graph);
            int[] distG = dijkstra(g, graph);
            int[] distH = dijkstra(h, graph);

            for (int dest : candidates) {
                int path1 = distS[g] + ghWeight + distH[dest];
                int path2 = distS[h] + ghWeight + distG[dest];

                if (distS[dest] == path1 || distS[dest] == path2) {
                    sb.append(dest).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
