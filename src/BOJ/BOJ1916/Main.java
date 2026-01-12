package BOJ.BOJ1916;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final long INF = 10_000_000_000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            g.get(sc.nextInt()).add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        long[] dp = new long[N + 1];
        Arrays.fill(dp, INF);
        dp[start] = 0;
        go(g, dp, start);

        System.out.println(dp[end]);
    }

    private static void go(List<List<int[]>> g, long[] dp, int start) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        pq.offer(new long[]{start, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();

            if (cur[1] != dp[(int) cur[0]]) {
                continue;
            }
            List<int[]> nexts = g.get((int) cur[0]);
            for (int i = 0; i < nexts.size(); i++) {
                if (dp[(int) cur[0]] + nexts.get(i)[1] < dp[nexts.get(i)[0]]) {
                    dp[nexts.get(i)[0]] = dp[(int) cur[0]] + nexts.get(i)[1];
                    pq.offer(new long[]{nexts.get(i)[0], dp[nexts.get(i)[0]]});
                }
            }
        }
    }
}
