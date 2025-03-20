package BOJ.BOJ1012;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class OneMore {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();

            answer = 0;

            boolean[][] land = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                land[y][x] = true;
            }

            //DFS
            for (int p = 0; p < n; p++) {
                for (int q = 0; q < m; q++) {
                    if (land[p][q]) {
                        land[p][q] = false;
                        dfs(p, q, land);
                        answer++;
                    }
                }
            }

            //BFS
//            for (int p = 0; p < n; p++) {
//                for (int q = 0; q < m; q++) {
//                    if (land[p][q]) {
//                        bfs(p, q, land);
//                    }
//                }
//            }

            System.out.println(answer);
        }
    }

    static void dfs(int p, int q, boolean[][] land) {
        for (int i = 0; i < dx.length; i++) {
            int x = p + dx[i];
            int y = q + dy[i];

            if (x < 0 || x >= land.length || y < 0 || y >= land[0].length) {
                continue;
            }

            if (!land[x][y]) {
                continue;
            }

            land[x][y] = false;
            dfs(x, y, land);
        }
    }

    static void bfs(int p, int q, boolean[][] land) {
        Deque<Integer> queue = new ArrayDeque<>();
        land[p][q] = false;
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            int tmpX = queue.poll();
            int tmpY = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int x = tmpX + dx[i];
                int y = tmpY + dy[i];

                if (x < 0 || x >= land.length || y < 0 || y >= land[0].length) {
                    continue;
                }

                if (!land[x][y]) {
                    continue;
                }

                land[x][y] = false;
                queue.offer(x);
                queue.offer(y);
            }
        }

        answer++;
    }
}
