package BOJ.BOJ1800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int K = sc.nextInt();

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[] history = new int[N + 1];
        Arrays.fill(history, -1);

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < P; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int dist = sc.nextInt();
            graph.get(x).add(new int[]{y, dist});
            graph.get(y).add(new int[]{x, dist});
        }

        dijkstra(dp, N, graph, history);
    }

    private static void dijkstra(int[] dp, int N, List<List<int[]>> graph, int[] history) {
        dp[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, dp[1]});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[0] == N) {
                break;
            }

            List<int[]> next = graph.get(cur[0]);
            for (int i = 0; i < next.size(); i++) {
                int v = next.get(i)[0];
                int w = next.get(i)[1];

                if (cur[1] + w < dp[v]) {
                    dp[v] = cur[1] + w;
                    history[v] = cur[0];
                    pq.offer(new int[]{v, dp[v]});
                    System.out.println("v = " + v);
                    System.out.println(Arrays.toString(dp));
                    System.out.println(Arrays.toString(history));
                }
            }
        }
    }
}