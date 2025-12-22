package BOJ.BOJ2644;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sol = new int[2];
        for (int i = 0; i < sol.length; i++) {
            sol[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.get(x).add(y);
            g.get(y).add(x);
        }

        System.out.println(bfs(sol, g));
    }

    private static int bfs(int[] sol, List<List<Integer>> g) {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[g.size()];
        visited[sol[0]] = true;
        q.offer(sol[0]);
        int cnt = 0;

        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int next : g.get(cur)) {
                    if (!visited[next]) {
                        if (next == sol[1]) {
                            return cnt;
                        }

                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }

        return -1;
    }
}
