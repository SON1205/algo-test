package BOJ.BOJ1520;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(go(map, dp, 0, 0));
    }

    private static int go(int[][] map, int[][] dp, int i, int j) {
        if (i == map.length - 1 && j == map[0].length - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = 0;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                continue;
            }

            if (map[nx][ny] < map[i][j]) {
                dp[i][j] += go(map, dp, nx, ny);
            }
        }

        return dp[i][j];
    }
}
