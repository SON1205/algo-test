package BOJ.BOJ13913;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] visited = new int[100_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        bfs(N, K);
    }

    private static void bfs(int n, int k) {
        Queue<Integer> q = new ArrayDeque<>();
        Arrays.fill(visited, -1);

        q.offer(n);
        visited[n] = n;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == k) {
                List<Integer> path = new ArrayList<>();
                int tmp = k;
                while (tmp != n) {
                    path.add(tmp);
                    tmp = visited[tmp];
                }
                path.add(n);
                Collections.reverse(path);

                System.out.println(path.size() - 1);
                for (int v : path) {
                    System.out.print(v + " ");
                }
                return;
            }

            for (int next : new int[]{curr - 1, curr + 1, curr * 2}) {
                if (next < 0 || next > 100_000 || visited[next] != -1) {
                    continue;
                }

                visited[next] = curr;
                q.offer(next);
            }
        }
    }
}
