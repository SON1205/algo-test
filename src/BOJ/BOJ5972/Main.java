package BOJ.BOJ5972;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            g.get(u).add(new int[]{v, w});
            g.get(v).add(new int[]{u, w});
        }

        int[] dist = new int[N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Arrays.fill(dist, INF);
        dist[1] = 0;
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] != dist[cur[0]]) {
                continue;
            }

            List<int[]> nexts = g.get(cur[0]);
            for (int[] next : nexts) {
                if (cur[1] + next[1] < dist[next[0]]) {
                    dist[next[0]] = cur[1] + next[1];
                    pq.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }

        System.out.println(dist[N]);
    }
}
