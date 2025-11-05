package BOJ.BOJ12851;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int MAX = 100_000;
    static int[] dist = new int[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Arrays.fill(dist, -1);
        int[] result = bfs(N, K);

        for (int i : result) {
            System.out.println(i);
        }
    }

    static int[] bfs(int n, int k) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        dist[n] = 0;

        int time = Integer.MAX_VALUE;
        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == k) {
                time = dist[cur];
                count++;
                continue;
            }

            int[] nexts = {cur - 1, cur + 1, cur * 2};

            for (int next : nexts) {
                if (next < 0 || next > MAX) {
                    continue;
                }
                
                if (dist[next] == -1 || dist[next] == dist[cur] + 1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        return new int[]{time, count};
    }
}