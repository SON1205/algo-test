package BOJ.BOJ12869;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int[] dx = {9, 9, 3, 3, 1, 1};
    static int[] dy = {3, 1, 9, 1, 9, 3};
    static int[] dz = {1, 3, 1, 9, 3, 9};
    static int[][][] dp = new int[61][61][61];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] scv = new int[3];
        for (int i = 0; i < N; i++) {
            scv[i] = sc.nextInt();
        }

        System.out.println(bfs(scv[0], scv[1], scv[2]));
    }

    static int bfs(int a, int b, int c) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{a, b, c});
        dp[a][b][c] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1], z = now[2];

            if (x == 0 && y == 0 && z == 0) {
                return dp[x][y][z] - 1;
            }

            for (int i = 0; i < 6; i++) {
                int nx = Math.max(0, x - dx[i]);
                int ny = Math.max(0, y - dy[i]);
                int nz = Math.max(0, z - dz[i]);

                if (dp[nx][ny][nz] == 0) {
                    dp[nx][ny][nz] = dp[x][y][z] + 1;
                    q.offer(new int[]{nx, ny, nz});
                }
            }
        }
        
        return -1;
    }
}
