package BOJ.BOJ10159;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Integer>> g = new ArrayList<>();
        List<List<Integer>> rg = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
            rg.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g.get(a).add(b);
            rg.get(b).add(a);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int light = bfs(i, g, N);
            int heavy = bfs(i, rg, N);

            int known = light + heavy;
            sb.append(N - 1 - known).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int start, List<List<Integer>> graph, int N) {
        boolean[] visited = new boolean[N + 1];
        Deque<Integer> q = new ArrayDeque<>();

        visited[start] = true;
        q.offer(start);

        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : graph.get(cur)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.offer(nxt);
                    count++;
                }
            }
        }
        return count;
    }
}
